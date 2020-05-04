package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityFormulas extends AppCompatActivity {

    private static LinearLayout layoutPrincipal;
    private static ImageView formulaImagen;
    private static TextView tituloTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);

        layoutPrincipal = findViewById(R.id.layoutPrincipal);
        formulaImagen = findViewById(R.id.formulaView);
        tituloTxt = findViewById(R.id.txtTituloFormula);

        switch (FormularioActivity.getPosicion()){
            case 0:
                tituloTxt.setText("Ley de Ohm");
                formulaImagen.setImageResource(R.drawable.ohmformula);
                break;
            case 1:
                tituloTxt.setText("Circulo de Formas");
                formulaImagen.setImageResource(R.drawable.circuloformula);
                break;
            case 2:
                tituloTxt.setText("Ley de Coulomb");
                formulaImagen.setImageResource(R.drawable.leycoulomb);
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }

}
