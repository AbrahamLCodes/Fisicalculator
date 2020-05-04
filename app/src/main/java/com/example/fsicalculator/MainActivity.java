package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button infoButton, formulasButton;
    Intent intentoInfo, intentoFomulas, IntentoCalculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formulasButton = findViewById(R.id.btnFormularios);
        intentoFomulas= new Intent(this, FormularioActivity.class);
        formulasButton.setOnClickListener(this);

        infoButton = findViewById(R.id.btnInformacion);
        intentoInfo = new Intent(this,activity_info.class);
        infoButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInformacion:
                startActivity(intentoInfo);
                break;
            case R.id.btnFormularios:
                startActivity(intentoFomulas);
                break;
            case R.id.btnCalculadora:
                break;
        }
    }

}
