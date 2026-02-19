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

import Models.MacroCycle;
import dataCenter.AppDatabase;

public class CycleProgressFragment extends Fragment {
    ActivityResultLauncher<Intent> addCycleLauncher;
    private RecyclerView recyclerView;
    private List<MacroCycle> macroCycleList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_cycle_progress, container, false);
        initializeLauncher();
        initializeConfig(view);
        return view;
    }

    private void initializeConfig(View view) {
        configButton(view);
        macroCycleList = AppDatabase.getInstance(getContext()).macroCycleDao().getAll();
        recyclerView = view.findViewById(R.id.recycler_view_cycle_progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void configButton(View view){
        FloatingActionButton buttonAddCycle = view.findViewById(R.id.button_add_cycle);
        buttonAddCycle.setOnClickListener(v-> {
            Intent intent = new Intent(getContext(), CycleEditorActivity.class);
            addCycleLauncher.launch(intent);
        });
    }

    private void initializeLauncher(){
        addCycleLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result-> {
                    if(result.getResultCode()== MainActivity.RESULT_OK){

                    }
                }
        );
    }
}
