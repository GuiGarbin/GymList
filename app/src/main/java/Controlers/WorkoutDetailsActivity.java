package Controlers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import Adapters.ExerciseAdapter;
import Models.Workout;
import dataCenter.AppDatabase;

public class WorkoutDetailsActivity extends AppCompatActivity {
    private TextView name;
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_workout);
        initializeConfig();

    }

    @Override
    protected void onResume(){
        super.onResume();
        loadData();
    }

    private void loadData(){
        Workout oldWorkout = (Workout) getIntent().getSerializableExtra("selected_workout");

        if(oldWorkout!= null){
            Workout newWorkout = AppDatabase.getInstance(this).workoutDao().getWorkoutById(oldWorkout.getId());

            if(newWorkout != null){
                name.setText(newWorkout.getName());

                adapter = new ExerciseAdapter(this, newWorkout.getExercisesList(), position -> {
                });
                recyclerView.setAdapter(adapter);

            }
        }
    }

    private void initializeConfig(){
        name = findViewById(R.id.exercise_name_active_session);
        recyclerView = findViewById(R.id.recycler_view_active_session);

        Workout workout = (Workout) getIntent().getSerializableExtra("selected_workout");

        if(workout!=null){
            name.setText(workout.getName());
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapter = new ExerciseAdapter(this, workout.getExercisesList(), position -> {

            });
            recyclerView.setAdapter(adapter);
        }

        configButton();
    }

    public void configButton(){
        ImageButton buttonBack = findViewById(R.id.button_back_active_session);
        buttonBack.setOnClickListener(v-> {
            finish();
        });
        ImageButton buttonDelet = findViewById(R.id.button_delete_workout);
        buttonDelet.setOnClickListener(v-> {
            Workout workout = (Workout) getIntent().getSerializableExtra("selected_workout");
            if(workout != null){
                AppDatabase.getInstance(this).workoutDao().delete(workout);
            }
            finish();
        });

        Button editButton = findViewById(R.id.button_edit_workout_details);
        editButton.setOnClickListener(v-> {
            Intent intent = new Intent(this, WorkoutEditorActivity.class);
            Workout workout = (Workout) getIntent().getSerializableExtra("selected_workout");
            intent.putExtra("workout_edit", workout);
            startActivity(intent);
        });
    }
}
