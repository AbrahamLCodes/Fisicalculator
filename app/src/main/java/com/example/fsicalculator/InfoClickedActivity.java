package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InfoClickedActivity extends AppCompatActivity {

    private Bundle datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_clicked);

        datos = getIntent().getExtras();

        switch (datos.getInt("subtema")){
            case 0:
                setContentView(R.layout.trespuntouno);
                break;
            case 1:
                setContentView(R.layout.trespuntodos);
                break;
            case 2:
                setContentView(R.layout.trespuntotres);
                break;
        }
    }
}
