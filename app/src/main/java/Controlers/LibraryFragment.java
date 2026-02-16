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

import Adapters.WorkoutAdapter;
import Models.Assessment;
import Models.Workout;
import dataCenter.AppDatabase;

public class LibraryFragment extends Fragment {

    FloatingActionButton buttonAddTrain;
    ActivityResultLauncher<Intent> addTrainLauncher;
    private RecyclerView recyclerViewWorkout;
    private List<Workout> workoutList = new ArrayList<>();
    private WorkoutAdapter workoutAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_library, container, false);
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
        workoutList = db.workoutDao().getAll();

        workoutAdapter = new WorkoutAdapter(requireContext(), workoutList, position -> {
            removeWorkout(position);
        });

        if(recyclerViewWorkout!=null){
            recyclerViewWorkout.setAdapter(workoutAdapter);
        }
    }

    private void configRecycler(View view){
        configButton(view);
        recyclerViewWorkout = view.findViewById(R.id.recycler_view_workout_library);
        recyclerViewWorkout.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void configButton(View view){
        buttonAddTrain = view.findViewById(R.id.button_add_train);
        buttonAddTrain.setOnClickListener(v-> {
            Intent intent = new Intent(getContext(), WorkoutEditorActivity.class);
            addTrainLauncher.launch(intent);
        });
    }

    private void removeWorkout(int position){
        if (workoutList == null || position < 0 || position >= workoutList.size()) {
            return;
        }
        Workout itemToDelet = workoutList.get(position);

        AppDatabase db = AppDatabase.getInstance(requireContext());
        db.workoutDao().delete(itemToDelet);
        workoutList.remove(position);

        workoutAdapter.notifyItemRemoved(position);
        workoutAdapter.notifyItemRangeChanged(position, workoutList.size());
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
