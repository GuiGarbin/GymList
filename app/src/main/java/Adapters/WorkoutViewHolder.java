package Adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

public class WorkoutViewHolder extends RecyclerView.ViewHolder {

    public TextView classWorkout;
    public TextView name;

    public WorkoutViewHolder(@NonNull View itemView) {
        super(itemView);
        this.classWorkout = itemView.findViewById(R.id.number_class);
        this.name = itemView.findViewById(R.id.name_exercise_workout_card);
    }
}
