package Controlers;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import java.util.ArrayList;
import java.util.List;

import Adapters.CycleAdapter;
import Adapters.WorkoutAdapter;
import Models.MacroCycle;
import Models.Workout;
import dataCenter.AppDatabase;

public class CycleEditorActivity extends AppCompatActivity implements AddWorkoutSheet.OnWorkoutSelectedListener{
    private EditText name;
    private EditText objective;
    private RecyclerView recyclerView;
    private List<Workout> listWorkouts;
    private WorkoutAdapter workoutAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_add_cycle);
        listWorkouts = new ArrayList<>();
        initializeConfig();
    }

    private void initializeConfig(){
        name = findViewById(R.id.add_name_cycle);
        objective = findViewById(R.id.add_objective_cycle);
        recyclerView = findViewById(R.id.add_recycler_view_cycle);
        workoutAdapter = new WorkoutAdapter(this, listWorkouts, position -> {
            listWorkouts.remove(position);
            workoutAdapter.notifyItemRemoved(position);
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(workoutAdapter);
        configButton();
    }

    private void configButton(){
        Button buttonSelectWorkout = findViewById(R.id.add_workout_in_cycle);
        buttonSelectWorkout.setOnClickListener(v-> openAddWorkoutSheet());

        Button buttonSaveCycle = findViewById(R.id.button_add_save_cycle);
        buttonSaveCycle.setOnClickListener(v-> {
            saveFullCycle();
        });
    }

    private void saveFullCycle() {
        String cycleName = name.getText().toString();
        String cycleObjective = objective.getText().toString();
        List<Integer> workoutIds = new ArrayList<>();
        for (Workout w : listWorkouts) {
            workoutIds.add(w.getId());
        }

        MacroCycle newCycle = new MacroCycle(cycleName, cycleObjective, workoutIds);

        AppDatabase.getInstance(this).macroCycleDao().insert(newCycle);

        finish();
    }

    private void openAddWorkoutSheet(){
        AddWorkoutSheet sheet = new AddWorkoutSheet();
        sheet.setListener(this);
        sheet.show(getSupportFragmentManager(), "AddWorkoutSheet");
    }

    @Override
    public void onWorkoutSelected(Workout workout) {
        listWorkouts.add(workout);
        workoutAdapter.notifyItemInserted(listWorkouts.size()-1);
    }
}
