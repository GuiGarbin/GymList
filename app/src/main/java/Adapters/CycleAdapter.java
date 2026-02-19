package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import java.util.List;

import Models.MacroCycle;

public class CycleAdapter extends RecyclerView.Adapter<CycleAdapter.CycleViewHolder>{
    private Context context;
    private List<MacroCycle> list;

    public CycleAdapter(Context context, List<MacroCycle> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemCycle = LayoutInflater.from(context).inflate(R.layout.item_cycle, parent, false);
        return new CycleViewHolder(itemCycle);
    }

    @Override
    public void onBindViewHolder(@NonNull CycleViewHolder holder, int position) {
        MacroCycle cycle = list.get(position);
        holder.name.setText(cycle.getName());
        holder.objective.setText(cycle.getObjective());
        holder.time.setText(String.valueOf(cycle.getTimesCycle()));

        holder.itemView.setOnClickListener(v-> {
            int positionActual = holder.getBindingAdapterPosition();
            if(positionActual!=RecyclerView.NO_POSITION){
                //TODO
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CycleViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView objective;
        public TextView time;

        public CycleViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name_cycle);
            this.objective = itemView.findViewById(R.id.objectives_cycle);
            this.time = itemView.findViewById(R.id.time_cycle);
        }
    }
}
