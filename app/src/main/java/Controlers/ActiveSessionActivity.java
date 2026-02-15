package Controlers;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymlist.R;

public class ActiveSessionActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_session);
        configButton();
    }

    public void configButton(){
        ImageButton buttonBack = findViewById(R.id.button_back_active_session);
        buttonBack.setOnClickListener(v-> {
            finish();
        });
    }
}
