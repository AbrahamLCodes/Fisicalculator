package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.Normalizer;

public class FormularioActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    private ListView listFormulas;
    private String[] formulas = {"Ley de Ohm", "Circulo de formulas", "Ley de Coulomb", "Energía potencial electroestática",
            "Reactancia capacitiva", "Reactancia inductiva", "Impedancia", "Magnetismo y almacenamiento de la informacion"};
    private Bundle bundle;
    private boolean isCalculadora;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        listFormulas = findViewById(R.id.listFormulas);
        listFormulas.setAdapter(new ArrayAdapter<String>(
                this, R.layout.row, formulas
        ));
        listFormulas.setOnItemClickListener(this);
        bundle = getIntent().getExtras();
        isCalculadora = bundle.getBoolean("calculadora");

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (isCalculadora) {
            switch (position){
                case 0:
                    intent = new Intent(this, LeyDeOhmActivity.class);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
            startActivity(intent);
        } else {
            intent = new Intent(this, ActivityFormulas.class);
            intent.putExtra("posicion", position);
            startActivity(intent);
        }
    }
}
