package Controlers;

import static java.lang.reflect.Array.getDouble;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;

import Models.Assessment;
import dataCenter.AppDatabase;

public class AddAssessmentActivity extends AppCompatActivity {
    TextInputEditText weight;
    TextInputEditText fat;
    TextInputEditText leftArm;
    TextInputEditText rightArm;
    TextInputEditText leftLeg;
    TextInputEditText rightLeg;
    TextInputEditText leftLowerLeg;
    TextInputEditText rightLowerLeg;
    TextInputEditText chest;
    TextInputEditText belly;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assessment);
        initializeConfig();

    }

    private void initializeConfig(){
        configButton();
        weight = findViewById(R.id.inputWeight);
        fat = findViewById(R.id.inputFat);
        leftArm = findViewById(R.id.inputLeftArm);
        rightArm = findViewById(R.id.inputRightArm);
        leftLeg = findViewById(R.id.inputLeftLeg);
        rightLeg = findViewById(R.id.inputRightLeg);
        leftLowerLeg = findViewById(R.id.inputLowerLeftLeg);
        rightLowerLeg = findViewById(R.id.inputLowerRightLeg);
        chest = findViewById(R.id.inputChest);
        belly = findViewById(R.id.inputBelly);
    }

    public void configButton(){
        ImageButton buttonBack = findViewById(R.id.button_back_add_assessment);
        buttonBack.setOnClickListener(v-> {
            finish();
        });
        Button ButtonSaveAssessment = findViewById(R.id.button_save_assessment);
        ButtonSaveAssessment.setOnClickListener(v-> {
            saveAssessment();
        });
    }

    private void saveAssessment(){
        if(validarCampos()) {
            Assessment assessment = new Assessment(
                    new Date(),
                    getDouble(weight),
                    getDouble(fat),
                    getDouble(chest),
                    getDouble(belly),
                    getDouble(leftArm),
                    getDouble(rightArm),
                    getDouble(leftLeg),
                    getDouble(rightLeg),
                    getDouble(leftLowerLeg),
                    getDouble(rightLowerLeg)
            );

            AppDatabase.getInstance(this).assessmentDao().insert(assessment);
        }
    }

    private double getDouble(EditText edit) {
        String texto = edit.getText().toString().trim();
        return Double.parseDouble(texto.replace(",", "."));
    }

    private boolean validarCampos() {
        TextInputEditText[] todosOsCampos = {
                weight, fat,
                leftArm, rightArm,
                leftLeg, rightLeg,
                leftLowerLeg, rightLowerLeg,
                chest, belly
        };


        for (TextInputEditText campo : todosOsCampos) {
            String valor = campo.getText().toString().trim();

            if (valor.isEmpty()) {
                campo.setError("Este campo é obrigatório");
                campo.requestFocus();
                return false;
            }
            try {
                Double.parseDouble(valor.replace(",", "."));
            } catch (NumberFormatException e) {
                campo.setError("Número inválido");
                campo.requestFocus();
                return false;
            }
        }
        return true;
    }
}
