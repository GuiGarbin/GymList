package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import java.util.List;

import Models.ExerciseSet;

public class ActiveSetAdapter extends RecyclerView.Adapter<ActiveSetAdapter.ActiveSetViewHolder>{

    private Context context;
    private List<ExerciseSet> exerciseSetList;

    public ActiveSetAdapter(Context context, List<ExerciseSet> exerciseSetList){
        this.context = context;
        this.exerciseSetList = exerciseSetList;
    }

    @NonNull
    @Override
    public ActiveSetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType){
        View itemActiveSet = LayoutInflater.from(context).inflate(R.layout.item_active_exercise_set, parent, false);
        return new ActiveSetViewHolder(itemActiveSet);
    }

    @Override
    public void onBindViewHolder(@NonNull ActiveSetViewHolder holder, int position){
        ExerciseSet set = exerciseSetList.get(position);
        holder.timesExercised.setText(String.valueOf(set.getNumberTime()));
        holder.weight.setText(String.valueOf(set.getWeight()));
        holder.reps.setText(String.valueOf(set.getReps()));
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setChecked(set.isDone());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            set.setDone(isChecked);
        });
    }
    @Override
    public int getItemCount(){
        return exerciseSetList.size();
    }

    public static class ActiveSetViewHolder extends RecyclerView.ViewHolder {
        public TextView timesExercised;
        public TextView weight;
        public TextView reps;
        public CheckBox checkBox;

        public ActiveSetViewHolder(@NonNull View itemView) {
            super(itemView);
            this.timesExercised = itemView.findViewById(R.id.exercise_number_set);
            this.weight = itemView.findViewById(R.id.weight_exercise_set);
            this.reps = itemView.findViewById(R.id.reps_exercise_set);
            this.checkBox = itemView.findViewById(R.id.checkbox_exercise_set);
        }

    }

}
