package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InductivaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText f, l;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inductiva);

        f = findViewById(R.id.fi);
        l = findViewById(R.id.li);
        button = findViewById(R.id.inductivaButton);
        button.setOnClickListener(this);

        intent = new Intent(this, ResultadoActivity.class);

    }

    @Override
    protected void onResume() {
        super.onResume();
        f.setText("");
        l.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.inductivaButton:
                if(!editEmpty()){
                    intent.putExtra("titulo","Reactancia inductiva");
                    intent.putExtra("valor", getInductiva());
                    intent.putExtra("unidad","Ω (Ohms)");
                    startActivity(intent);
                }
                break;
        }
    }

    private boolean editEmpty(){
        if(f.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta introducir f", Toast.LENGTH_SHORT).show();
            f.requestFocus();
            return true;
        }else if(l.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta introducir l", Toast.LENGTH_SHORT).show();
            l.requestFocus();
            return true;
        }else{
            return false;
        }
    }

    private double getInductiva(){
        double ef = Double.parseDouble(f.getText().toString());
        double el = Double.parseDouble(l.getText().toString());
        double pis = 2 * Math.PI;
        return pis * ef * el;
    }
}
