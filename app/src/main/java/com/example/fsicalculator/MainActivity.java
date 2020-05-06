package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button infoButton, formulasButton;
    private Intent intentoInfo, intentoFomulas, IntentoCalculadora;
    private ImageView infoImagen, formularioImagen, calculadoraImagen;
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

        infoImagen = findViewById(R.id.imgInformacion);
        formularioImagen = findViewById(R.id.imgFormularios);
        calculadoraImagen = findViewById(R.id.imgCalculadora);

        infoImagen.setOnClickListener(this);
        formularioImagen.setOnClickListener(this);
        calculadoraImagen.setOnClickListener(this);
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

            case R.id.imgInformacion:
                startActivity(intentoInfo);
                break;

            case R.id.imgFormularios:
                startActivity(intentoFomulas);
                break;

            case R.id.imgCalculadora:
                break;
        }
    }

}
