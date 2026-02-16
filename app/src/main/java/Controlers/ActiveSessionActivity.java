package Controlers;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import Adapters.ExerciseAdapter;
import Models.Workout;

public class ActiveSessionActivity extends AppCompatActivity {
    private TextView name;
    private RecyclerView recyclerView;
    private ExerciseAdapter adapter;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_session);
        initializeConfig();
        configButton();
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
    }

    public void configButton(){
        ImageButton buttonBack = findViewById(R.id.button_back_active_session);
        buttonBack.setOnClickListener(v-> {
            finish();
        });
    }
}
