package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button infoButton, formulasButton, calculadoraButton;
    private Intent intentoInfo, intentoFomulas, intentoCalculadora;
    private ImageView infoImagen, formularioImagen, calculadoraImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formulasButton = findViewById(R.id.btnFormularios);
        formularioImagen = findViewById(R.id.imgFormularios);

        infoButton = findViewById(R.id.btnInformacion);
        infoImagen = findViewById(R.id.imgInformacion);

        calculadoraButton = findViewById(R.id.btnCalculadora);
        calculadoraImagen = findViewById(R.id.imgCalculadora);

        infoButton.setOnClickListener(this);
        infoImagen.setOnClickListener(this);

        formularioImagen.setOnClickListener(this);
        formulasButton.setOnClickListener(this);

        calculadoraImagen.setOnClickListener(this);
        calculadoraButton.setOnClickListener(this);

        intentoInfo = new Intent(this,activity_info.class);
        intentoFomulas= new Intent(this, FormularioActivity.class);
        intentoCalculadora = new Intent(this, FormularioActivity.class);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInformacion:
                startActivity(intentoInfo);
                break;

            case R.id.btnFormularios:
                intentoFomulas.putExtra("calculadora",false);
                startActivity(intentoFomulas);
                break;

            case R.id.btnCalculadora:
                intentoCalculadora.putExtra("calculadora",true);
                startActivity(intentoCalculadora);
                break;

            case R.id.imgInformacion:
                startActivity(intentoInfo);
                break;

            case R.id.imgFormularios:
                intentoFomulas.putExtra("calculadora",false);
                startActivity(intentoFomulas);
                break;

            case R.id.imgCalculadora:
                intentoCalculadora.putExtra("calculadora",true);
                startActivity(intentoCalculadora);
                break;

        }
    }
}
