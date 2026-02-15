package Controlers;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Adapters.ExerciseAdapter;
import Models.Exercise;
import Models.Workout;
import dataCenter.AppDatabase;

public class WorkoutEditorActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;
    private List<Exercise> exerciseList;
    private EditText nameWorkout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_editor);
        initializeConfig();
    }

    private void configButton(){
        ImageButton buttonBack = findViewById(R.id.button_back_workout_editor);
        buttonBack.setOnClickListener(v-> {
            finish();
        });
        FloatingActionButton buttonAddExercise = findViewById(R.id.button_add_exercise_workout_editor);
        buttonAddExercise.setOnClickListener(v-> {
            addExercise();
        });
        Button buttonSaveWorkout = findViewById(R.id.button_save_workout);
        buttonSaveWorkout.setOnClickListener(v-> {
            saveWorkout();
        });
    }

    private void saveWorkout(){
        String nameWorkoutString = nameWorkout.getText().toString().trim();
        if(nameWorkoutString.isEmpty()){
            return;
        }
        if(exerciseList.isEmpty()){
            return;
        }
        Workout newWorkout = new Workout(nameWorkoutString);
        newWorkout.setExercisesList(exerciseList);

        AppDatabase db = AppDatabase.getInstance(this);
        db.workoutDao().insert(newWorkout);
        finish();
    }

    private void initializeConfig(){
        configButton();
        exerciseList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view_workout_editor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameWorkout = findViewById(R.id.name_exercise_workout_editor);

        adapter = new ExerciseAdapter(this, exerciseList, position-> {
                    removeExercise(position);
                });

        recyclerView.setAdapter(adapter);
    }

    private void removeExercise(int position) {
        exerciseList.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, exerciseList.size());
    }

    private void addExercise() {
        AddExerciseSheet sheet = new AddExerciseSheet();

        sheet.setListener(newExercise -> {
            exerciseList.add(newExercise);
            adapter.notifyItemInserted(exerciseList.size() - 1);
            recyclerView.scrollToPosition(exerciseList.size() - 1);
        });
        sheet.show(getSupportFragmentManager(), "AddExerciseTag");
    }
}
