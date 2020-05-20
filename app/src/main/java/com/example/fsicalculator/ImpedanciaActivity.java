package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ImpedanciaActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private EditText impedancia11, impedancia12, impedancia21, impedancia23, impedancia24, impedancia31, impedancia32, impedancia33;
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impedancia);

        impedancia11 = findViewById(R.id.impedancia11);
        impedancia12 = findViewById(R.id.impedancia12);
        button1 = findViewById(R.id.impedanciaButton1);

        impedancia21 = findViewById(R.id.impedancia21);
        impedancia23 = findViewById(R.id.impedancia23);
        impedancia24 = findViewById(R.id.impedancia24);
        button2 = findViewById(R.id.impedanciaButton2);

        impedancia31 = findViewById(R.id.impedancia31);
        impedancia32 = findViewById(R.id.impedancia32);
        impedancia33 = findViewById(R.id.impedancia33);
        button3 = findViewById(R.id.impedanciaButton3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        intent = new Intent(this, ResultadoActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.impedanciaButton1:
                if (!empty1()) {
                    intent.putExtra("titulo", "Impedancia");
                    intent.putExtra("valor", obtener1());
                    intent.putExtra("unidad", "Ω (Ohms)");
                    startActivity(intent);
                }
                break;
            case R.id.impedanciaButton2:
                if (!empty2()) {
                    intent.putExtra("titulo", "Impedancia");
                    intent.putExtra("valor", obtener2());
                    intent.putExtra("unidad", "Ω (Ohms)");
                    startActivity(intent);
                }
                break;
            case R.id.impedanciaButton3:
                if (!empty3()) {
                    intent.putExtra("titulo", "Impedancia");
                    intent.putExtra("valor", obtener3());
                    intent.putExtra("unidad", "Ω (Ohms)");
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        impedancia11.setText("");
        impedancia12.setText("");
        impedancia21.setText("");
        impedancia23.setText("");
        impedancia24.setText("");
        impedancia31.setText("");
        impedancia32.setText("");
        impedancia33.setText("");
    }

    private boolean empty1() {
        if (impedancia11.getText().toString().isEmpty()) {
            makeToast(impedancia11, "Ingrese R");
            return true;
        } else if (impedancia12.getText().toString().isEmpty()) {
            makeToast(impedancia12, "Ingrese x");
            return true;
        } else {
            return false;
        }
    }

    private boolean empty2() {
        if (impedancia21.getText().toString().isEmpty()) {
            makeToast(impedancia21, "Ingrese R");
            return true;
        } else if (impedancia23.getText().toString().isEmpty()) {
            makeToast(impedancia23, "Ingrese L");
            return true;
        } else if (impedancia24.getText().toString().isEmpty()) {
            makeToast(impedancia24, "Ingrese C");
            return true;
        } else {
            return false;
        }

    }

    private boolean empty3() {
        if (impedancia31.getText().toString().isEmpty()) {
            makeToast(impedancia31, "Ingrese R");
            return true;
        } else if (impedancia32.getText().toString().isEmpty()) {
            makeToast(impedancia32, "Ingrese X");
            return true;
        } else if (impedancia33.getText().toString().isEmpty()) {
            makeToast(impedancia33, "Ingrese j");
            return true;
        } else {
            return false;
        }
    }

    private void makeToast(EditText editText, String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        editText.requestFocus();
    }

    private double obtener1() {
        double r = Double.parseDouble(impedancia11.getText().toString());
        double x = Double.parseDouble(impedancia12.getText().toString());
        double r2 = Math.pow(r, 2);
        double x2 = Math.pow(x, 2);
        double suma = r2 + x2;
        return Math.sqrt(suma);
    }

    private double obtener2() {
        double r = Double.parseDouble(impedancia21.getText().toString());
        double l = Double.parseDouble(impedancia23.getText().toString());
        double c = Double.parseDouble(impedancia24.getText().toString());

        double restaabsoluta = Math.abs(l - c);
        double resta2 = Math.sqrt(restaabsoluta);
        double suma = Math.pow(r, 2) + resta2;
        return Math.sqrt(suma);
    }

    private double obtener3() {
        double r = Double.parseDouble(impedancia31.getText().toString());
        double x = Double.parseDouble(impedancia32.getText().toString());
        double j = Double.parseDouble(impedancia33.getText().toString());

        double multiplicacion = j * x;
        return r + multiplicacion;
    }
}
