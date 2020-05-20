package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LeyDeOhmActivity extends AppCompatActivity implements View.OnClickListener {

    private Button resistenciaButton, intensidadButton, voltajeButton;
    EditText res1, res2, int1, int2, volt1, volt2;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ley_de_ohm);

        resistenciaButton = findViewById(R.id.resistenciaButton);
        intensidadButton = findViewById(R.id.corrienteButton);
        voltajeButton = findViewById(R.id.voltajeButton);

        resistenciaButton.setOnClickListener(this);
        intensidadButton.setOnClickListener(this);
        voltajeButton.setOnClickListener(this);

        res1 = findViewById(R.id.res1);
        res2 = findViewById(R.id.res2);

        int1 = findViewById(R.id.int1);
        int2 = findViewById(R.id.int2);

        volt1 = findViewById(R.id.volt1);
        volt2 = findViewById(R.id.volt2);
    }

    @Override
    protected void onResume() {
        super.onResume();
        res1.setText("");
        res2.setText("");

        int1.setText("");
        int2.setText("");

        volt1.setText("");
        volt2.setText("");
    }

    @Override
    public void onClick(View v) {
        intent = new Intent(this, ResultadoActivity.class);
        switch (v.getId()) {
            case R.id.resistenciaButton:
                if (!isEditTextsEmpty(res1, res2)) {
                    intent.putExtra("titulo", "Resistencia");
                    intent.putExtra("valor", obtenerResistencia(res1, res2));
                    intent.putExtra("unidad", "Ω (Ohms)");
                }
                break;

            case R.id.corrienteButton:
                if (!isEditTextsEmpty(int1, int2)) {
                    intent.putExtra("titulo", "Intensidad");
                    intent.putExtra("valor", obtenerIntensidad(int1, int2));
                    intent.putExtra("unidad", "A (Amperes)");
                }
                break;

            case R.id.voltajeButton:
                if (!isEditTextsEmpty(volt1, volt2)) {
                    intent.putExtra("titulo", "Voltaje");
                    intent.putExtra("valor", obtenerVoltaje(volt1, volt2));
                    intent.putExtra("unidad", "V (Voltios)");
                }
                break;
        }
        startActivity(intent);
    }

    private boolean isEditTextsEmpty(EditText e1, EditText e2) {
        if (e1.getText().toString().isEmpty()) {
            return true;
        } else if (e2.getText().toString().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private double obtenerResistencia(EditText voltaje, EditText corriente) {
        return Double.parseDouble(voltaje.getText().toString()) / Double.parseDouble(
                (corriente.getText().toString()));
    }

    private double obtenerIntensidad(EditText voltaje, EditText resistencia) {
        return Double.parseDouble(voltaje.getText().toString()) / Double.parseDouble(
                resistencia.getText().toString());
    }

    private double obtenerVoltaje(EditText intensidad, EditText corriente) {
        return Double.parseDouble(intensidad.getText().toString()) * Double.parseDouble(
                corriente.getText().toString());
    }
}
