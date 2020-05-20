package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CapacitivaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText f, c;
    private Button reactanciaButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacitiva);

        f = findViewById(R.id.fEdit);
        c = findViewById(R.id.cEdit);
        reactanciaButton = findViewById(R.id.reactanciaButton);
        intent = new Intent(this, ResultadoActivity.class);

        reactanciaButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reactanciaButton:
                if(!editsEmpty()){
                    intent.putExtra("titulo","Reactancia Capacitiva");
                    intent.putExtra("valor", getReactancia());
                    intent.putExtra("unidad","Ω (Ohms)");
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        f.setText("");
        c.setText("");
    }

    private boolean editsEmpty(){
        if(f.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta ingresar f", Toast.LENGTH_SHORT).show();
            f.requestFocus();
            return true;
        }else if(c.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta ingresar C", Toast.LENGTH_SHORT).show();
            c.requestFocus();
            return true;
        }else{
            return false;
        }
    }

    private double getReactancia(){
        double ef = Double.parseDouble(f.getText().toString());
        double ec = Double.parseDouble(c.getText().toString());
        double pi2 = 2 * Math.PI;
        double multiplicacion = pi2 * ef * ec;
        return 1 / multiplicacion;
    }
}
