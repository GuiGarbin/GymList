package Controlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gymlist.R;

public class HomeFragment extends Fragment {

    Button buttonNextTrain;
    ActivityResultLauncher<Intent> addTrainLauncher;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initializeLauncher();
        configButton(view);
        return view;
    }

    public void configButton(View view){
        buttonNextTrain = view.findViewById(R.id.buttonNextTrain);
        buttonNextTrain.setOnClickListener(v-> {
            Intent intent = new Intent(getContext(), WorkoutDetailsActivity.class);
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
