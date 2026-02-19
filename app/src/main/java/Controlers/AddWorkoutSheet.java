package Controlers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

import Adapters.WorkoutAdapter;
import Models.Workout;
import dataCenter.AppDatabase;

public class AddWorkoutSheet extends BottomSheetDialogFragment {
    private OnWorkoutSelectedListener listener;

    public interface OnWorkoutSelectedListener {
        void onWorkoutSelected(Workout workout);
    }

    public AddWorkoutSheet() {}

    public void setListener(OnWorkoutSelectedListener listener) {this.listener = listener;}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sheet_add_workout_in_cycle, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_select_workout);
        List<Workout> list = AppDatabase.getInstance(getContext()).workoutDao().getAll();
        WorkoutAdapter adapter = new WorkoutAdapter(getContext(), list, position-> {
            Workout selected = list.get(position);
            listener.onWorkoutSelected(selected);
            dismiss();
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }
}
