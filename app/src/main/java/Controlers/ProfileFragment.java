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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adapters.AssessmentAdapter;
import Models.Assessment;
import dataCenter.AppDatabase;

public class ProfileFragment extends Fragment {

    private FloatingActionButton buttonAddAssessment;
    ActivityResultLauncher<Intent> addAssassmentLauncher;
    private RecyclerView recyclerViewAssessment;
    private List<Assessment> assessmentList = new ArrayList<>();
    private AssessmentAdapter assessmentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        initializeLauncher();
        configRecycler(view);
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        loadDate();
    }

    private void loadDate(){
        AppDatabase db = AppDatabase.getInstance(requireContext());
        assessmentList = db.assessmentDao().getAll();

        assessmentAdapter = new AssessmentAdapter(requireContext(), assessmentList, position -> {
            removeAssessment(position);
        });

        if(recyclerViewAssessment!=null){
            recyclerViewAssessment.setAdapter(assessmentAdapter);
        }
    }

    public void configButton(View view){
        buttonAddAssessment = view.findViewById(R.id.button_add_assassment);
        buttonAddAssessment.setOnClickListener(v-> {
            Intent intent = new Intent(getContext(), AddAssessmentActivity.class);
            addAssassmentLauncher.launch(intent);
        });
    }

    private void removeAssessment(int position){
        if (assessmentList == null || position < 0 || position >= assessmentList.size()) {
            return;
        }
        Assessment itemToDelet = assessmentList.get(position);

        AppDatabase db = AppDatabase.getInstance(requireContext());
        db.assessmentDao().delete(itemToDelet);
        assessmentList.remove(position);

        assessmentAdapter.notifyItemRemoved(position);
        assessmentAdapter.notifyItemRangeChanged(position, assessmentList.size());
    }

    public void configRecycler(View view){
        configButton(view);
        recyclerViewAssessment = view.findViewById(R.id.recycler_view_user_profile);
        recyclerViewAssessment.setLayoutManager(new LinearLayoutManager(getContext()));
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
