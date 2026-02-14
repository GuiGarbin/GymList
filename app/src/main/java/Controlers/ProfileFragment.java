package Controlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adapters.AssessmentAdapter;
import Models.Assessment;

public class ProfileFragment extends Fragment {

    private FloatingActionButton buttonAddAssessment;
    ActivityResultLauncher<Intent> addAssassmentLauncher;
    private RecyclerView recyclerViewAssessment;
    private AssessmentAdapter assessmentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        initializeLauncher();
        configButton(view);
        configRecycler(view);
        return view;
    }


    public void configButton(View view){
        buttonAddAssessment = view.findViewById(R.id.button_add_assassment);
        buttonAddAssessment.setOnClickListener(v-> {
            Intent intent = new Intent(getContext(), AddAssessmentActivity.class);
            addAssassmentLauncher.launch(intent);
        });
    }

    public void configRecycler(View view){
        recyclerViewAssessment = view.findViewById(R.id.recycler_view_user_profile);
        recyclerViewAssessment.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Assessment> dados = Utils.MockData.gerarAvaliacoesFalsas();
        assessmentAdapter = new AssessmentAdapter(getContext(), dados);
        recyclerViewAssessment.setAdapter(assessmentAdapter);
    }

    private void initializeLauncher(){
        addAssassmentLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result-> {
                    if(result.getResultCode()== MainActivity.RESULT_OK){

                    }
                }
        );
    }
}
