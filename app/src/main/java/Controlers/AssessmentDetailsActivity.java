package Controlers;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymlist.R;

import java.text.SimpleDateFormat;

import Models.Assessment;

public class AssessmentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessments_details);

        Assessment assessment = (Assessment) getIntent().getSerializableExtra("selected_assessment");

        if (assessment != null) {
            // Data
            TextView txtDate = findViewById(R.id.text_assessment_date_title);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            txtDate.setText("Avaliação: " + sdf.format(assessment.getDate()));

            setVal(R.id.detail_weight, assessment.getWeight(), "kg");
            setVal(R.id.detail_fat, assessment.getFat(), "%");

            setVal(R.id.detail_chest, assessment.getChest(), "cm");
            setVal(R.id.detail_belly, assessment.getBelly(), "cm");

            setVal(R.id.detail_arm_left, assessment.getLeftArm(), "cm");
            setVal(R.id.detail_arm_right, assessment.getRightArm(), "cm");

            setVal(R.id.detail_leg_left, assessment.getLeftLeg(), "cm");
            setVal(R.id.detail_leg_right, assessment.getRightLeg(), "cm");

            setVal(R.id.detail_calf_left, assessment.getLeftLowerLeg(), "cm");
            setVal(R.id.detail_calf_right, assessment.getRightLowerLeg(), "cm");
        }

        ImageButton buttonBack = findViewById(R.id.button_back_assessment_details);
        buttonBack.setOnClickListener(v-> {
            finish();
        });
    }

    // Helper para economizar linhas de código
    private void setVal(int idTextView, double value, String unit) {
        TextView tv = findViewById(idTextView);
        // Usa %.1f para 1 casa decimal (80.5) ou %.0f para inteiro (80)
        tv.setText(String.format("%.1f %s", value, unit));
    }
}
