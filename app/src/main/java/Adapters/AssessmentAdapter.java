package Adapters;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymlist.R;

import java.text.SimpleDateFormat;
import java.util.List;

import Models.Assessment;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssassmentViewHolder> {
    private Context context;
    private List<Assessment> list;
    private OnRemoveClickListener listenerDelete;
    private OnRemoveClickListener listenerOpen;

    public AssessmentAdapter(Context context, List<Assessment> list,
                             OnRemoveClickListener listenerDelete,
                            OnRemoveClickListener listenerOpen) {
        this.context = context;
        this.list = list;
        this.listenerDelete = listenerDelete;
        this.listenerOpen = listenerOpen;
    }

    @NonNull
    @Override
    public AssassmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemAssessment = LayoutInflater.from(context).inflate(R.layout.item_assessment_history, parent, false);
        return new AssassmentViewHolder(itemAssessment);
    }

    @Override
    public void onBindViewHolder(@NonNull AssassmentViewHolder holder, int position) {
        Assessment assessment = list.get(position);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String date = format.format(assessment.getDate());
        holder.date.setText(date);
        holder.weight.setText(String.format("%.1f kg", assessment.getWeight()));
        holder.fat.setText(String.format("%.1f%%", assessment.getFat()));

        holder.buttonDelete.setOnClickListener(v -> {
            int positionActual = holder.getBindingAdapterPosition();
            if(positionActual != RecyclerView.NO_POSITION){
                listenerDelete.onRemoveClick(positionActual);
            }
        });
        holder.itemView.setOnClickListener(v-> {
            int positionActual = holder.getBindingAdapterPosition();
            if(positionActual != RecyclerView.NO_POSITION) {
                listenerOpen.onRemoveClick(positionActual);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AssassmentViewHolder extends RecyclerView.ViewHolder {
        public TextView date;
        public TextView weight;
        public TextView fat;
        public ImageButton buttonDelete;

        public AssassmentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.date = itemView.findViewById(R.id.date_avaliation);
            this.weight = itemView.findViewById(R.id.weight_avaliation);
            this.fat = itemView.findViewById(R.id.fat_avaliation);
            this.buttonDelete = itemView.findViewById(R.id.button_delete_assessment);
        }
    }
}
