package Controlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gymlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LibraryFragment extends Fragment {

    FloatingActionButton buttonAddTrain;
    ActivityResultLauncher<Intent> addTrainLauncher;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_library, container, false);
        initializeLauncher();
        configButton(view);
        return view;
    }

    public void configButton(View view){
        buttonAddTrain = view.findViewById(R.id.button_add_train);
        buttonAddTrain.setOnClickListener(v-> {
            Intent intent = new Intent(getContext(), WorkoutEditorActivity.class);
            addTrainLauncher.launch(intent);
        });
    }

    private void initializeLauncher(){
        addTrainLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result-> {
                    if(result.getResultCode()== MainActivity.RESULT_OK){

                    }
                }
        );
    }
}
