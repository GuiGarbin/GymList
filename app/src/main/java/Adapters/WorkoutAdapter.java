package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import java.util.List;

import Controlers.ActiveSessionActivity;
import Models.Workout;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutViewHolder> {
    private Context context;
    private List<Workout> listTrain;

    public WorkoutAdapter(Context context, List<Workout> listTrain){
        this.context = context;
        this.listTrain = listTrain;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemWorkoutList = LayoutInflater.from(context).inflate(R.layout.item_workout_card, parent, false);
        return new WorkoutViewHolder(itemWorkoutList);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position){
        Workout train = listTrain.get(position);
        holder.name.setText(train.getName());
        holder.itemView.setOnClickListener(v-> {
            Intent intent = new Intent(context, ActiveSessionActivity.class);
            intent.putExtra("TREINO_EXTRA", train);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listTrain.size();
    }

}
