package Controlers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import Models.Exercise;

public class AddExerciseSheet extends BottomSheetDialogFragment {
    private OnExerciseSelectedListener listener;

    public interface OnExerciseSelectedListener {
        void onExerciseSelected(Exercise exercise);
    }

    public void setListener(OnExerciseSelectedListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sheet_add_exercise, container, false);

        EditText exerciseName = view.findViewById(R.id.add_name_exercise);
        Button buttonAddExercise = view.findViewById(R.id.button_save_new_exercise);

        buttonAddExercise.setOnClickListener(v-> {
            String name = exerciseName.getText().toString().trim();
            if(name.isEmpty()){
                exerciseName.setError("digite um exercicio");
                return;
            }
            Exercise newExercise = new Exercise(name, 3, 10, 0);

            if(listener != null) {
                listener.onExerciseSelected(newExercise);
            }

            dismiss();
        });
        return view;
    }
}
