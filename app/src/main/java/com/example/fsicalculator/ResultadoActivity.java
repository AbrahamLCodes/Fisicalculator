package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private TextView titulo, resultado, unidad;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        bundle = getIntent().getExtras();

        titulo = findViewById(R.id.tituloText);
        resultado = findViewById(R.id.resultadoText);
        unidad = findViewById(R.id.unidadText);

        titulo.setText(bundle.getString("titulo"));
        resultado.setText("Resultado: " + bundle.getDouble("valor"));
        unidad.setText("Unidad: " + bundle.getString("unidad"));

    }
}
