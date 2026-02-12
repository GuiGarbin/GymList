package Controlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gymlist.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ProfileFragment extends Fragment {

    private FloatingActionButton buttonAddAssessment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        configButton();
        return view;
    }


    public void configButton(){
        buttonAddAssessment.findViewById(R.id.button_add_assassment);
        buttonAddAssessment.setOnClickListener(v-> {
            Intent intent = new Intent(this, ActiveSessionActivity.class);
        });
    }
}
