package Controlers;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddAssessmentActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_assessment);
        configButton();
    }

    public void configButton(){
        ImageButton buttonBack = findViewById(R.id.button_back_add_assessment);
        buttonBack.setOnClickListener(v-> {
            finish();
        });
    }
}
