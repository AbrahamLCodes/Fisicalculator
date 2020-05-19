package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LeyDeCoulombActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText k, q1, q2, r, u;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ley_de_coulomb);

        k = findViewById(R.id.kEdit);
        q1 = findViewById(R.id.q1Edit);
        q2 = findViewById(R.id.q2Edit);
        r = findViewById(R.id.rEdit);
        u = findViewById(R.id.uEdit);

        button = findViewById(R.id.coulombButton);
        button.setOnClickListener(this);
        intent = new Intent(this,ResultadoActivity.class);

    }

    @Override
    protected void onResume() {
        super.onResume();
        k.setText("");
        q1.setText("");
        q2.setText("");
        r.setText("");
        u.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.coulombButton:
                if(!textsEmpty(k,q1,q2,r,u)){
                    intent.putExtra("titulo","Fuerza de atracción");
                    intent.putExtra("valor", obtenerCoulomb(k,q1,q2,r,u));
                    intent.putExtra("unidad","N (Newtons)");
                    startActivity(intent);
                }
                break;
        }
    }

    private double obtenerCoulomb(EditText k, EditText q1, EditText q2, EditText r, EditText u){

        double r2 = Math.pow(Double.parseDouble(r.getText().toString()),2);
        double q1q2 = Double.parseDouble(q1.getText().toString())* Double.parseDouble(
                q2.getText().toString());
        double division = q1q2 / r2;
        double ka = Double.parseDouble(k.getText().toString());
        double iu = Double.parseDouble(u.getText().toString());

        return ka * (division) * iu;

    }

    private boolean textsEmpty(EditText k, EditText q1, EditText q2, EditText r, EditText u){
        if(k.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta llenar el campo K", Toast.LENGTH_SHORT).show();
            return true;
        }else if(q1.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta llenar el campo q1", Toast.LENGTH_SHORT).show();
            return true;
        }else if(q2.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta llenar el campo q2", Toast.LENGTH_SHORT).show();
            return true;
        }else if(r.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta llenar el campo r", Toast.LENGTH_SHORT).show();
            return true;
        }else if(u.getText().toString().isEmpty()){
            Toast.makeText(this, "Falta llenar el campo u", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return false;
        }
    }
}
