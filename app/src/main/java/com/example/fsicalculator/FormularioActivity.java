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
    String[] formulas = {"Ley de Ohm", "Circulo de formulas", "Ley de Coulomb","Energía potencial electroestática","En construcción"};
    Intent intent;
    private static int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
//      intentoInfo = new Intent(this,activity_info.class);
        listFormulas = findViewById(R.id.listFormulas);
        listFormulas.setAdapter(new ArrayAdapter<String>(
                this,R.layout.row,formulas
        ));
        listFormulas.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,formulas[position], Toast.LENGTH_SHORT).show();
        posicion = position;
        intent = new Intent(this,ActivityFormulas.class);
        intent.putExtra("posicion",position);
        startActivity(intent);

    }
}
