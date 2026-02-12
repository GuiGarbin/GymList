package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import java.time.temporal.Temporal;
import java.util.List;

import Models.Exercise;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {
    private Context context;
    private List<Exercise> exerciseList;

    public ExerciseAdapter(Context context, List<Exercise> exerciseList) {
        this.context = context;
        this.exerciseList = exerciseList;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemExercise = LayoutInflater.from(context).inflate(R.layout.item_exercise_row, parent, false);
        return new ExerciseViewHolder(itemExercise);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise exercise = exerciseList.get(position);
        holder.nameExercise.setText(exercise.getName());
        holder.timesExercise.setText(String.valueOf(exercise.getTimeExecuted()));
        holder.weight.setText(String.valueOf(exercise.getWeight()));
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public static class ExerciseViewHolder extends RecyclerView.ViewHolder {
        public TextView nameExercise;
        public TextView timesExercise;
        public TextView weight;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameExercise = itemView.findViewById(R.id.name_exercise_row);
            this.timesExercise = itemView.findViewById(R.id.times_exercised);
            this.weight = itemView.findViewById(R.id.exercise_weight_row);
        }
    }
}
