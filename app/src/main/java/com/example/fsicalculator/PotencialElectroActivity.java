package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PotencialElectroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ka, qu, qiu, ere;
    private Button button;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potencial_electro);

        ka = findViewById(R.id.kaEdit);
        qu = findViewById(R.id.quEdit);
        qiu = findViewById(R.id.qiuEdit);
        ere = findViewById(R.id.ereEdit);
        button = findViewById(R.id.potencialButton);

        button.setOnClickListener(this);

        intent = new Intent(this, ResultadoActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.potencialButton:
                if(!editsEmptu()){
                    intent.putExtra("titulo","Campo Eléctrico");
                    intent.putExtra("valor", getEnergiaPotencial());
                    intent.putExtra("unidad","J (Julios)");
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ka.setText("");
        qu.setText("");
        qiu.setText("");
        ere.setText("");
    }

    private boolean editsEmptu(){
        if(ka.getText().toString().isEmpty()){
            return true;
        }else if(qu.getText().toString().isEmpty()){
            return  true;
        }else if(qiu.getText().toString().isEmpty()){
            return true;
        }else if(ere.getText().toString().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    private double getEnergiaPotencial(){
        double k = Double.parseDouble(ka.getText().toString());
        double q1 = Double.parseDouble(qu.getText().toString());
        double q2 = Double.parseDouble(qiu.getText().toString());
        double r = Double.parseDouble(ere.getText().toString());

        double multiplicacion = q1 * q2;
        double division = multiplicacion / r;
        return k * division;
    }

}
