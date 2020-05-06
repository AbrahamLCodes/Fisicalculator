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
    ListView listFormulas;
    String[] formulas = {"Ley de Ohm", "Circulo de formulas", "Ley de Coulomb","Energía potencial electroestática",
            "Reactancia capacitiva", "Reactancia inductiva","Impedancia","Magnetismo y almacenamiento de la informacion"};
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        listFormulas = findViewById(R.id.listFormulas);
        listFormulas.setAdapter(new ArrayAdapter<String>(
                this,R.layout.row,formulas
        ));
        listFormulas.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(this,ActivityFormulas.class);
        intent.putExtra("posicion",position);
        startActivity(intent);
    }
}
