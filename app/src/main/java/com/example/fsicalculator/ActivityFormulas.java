package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFormulas extends AppCompatActivity {

    private  LinearLayout layoutPrincipal;
    private  ImageView formulaImagen;
    private  TextView tituloTxt, infoTextView;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulas);

        bundle = getIntent().getExtras();
        layoutPrincipal = findViewById(R.id.layoutPrincipal);
        formulaImagen = findViewById(R.id.formulaView);
        tituloTxt = findViewById(R.id.txtTituloFormula);
        infoTextView = findViewById(R.id.infoText);

        switch (bundle.getInt("posicion")){
            case 0:
                tituloTxt.setText("Ley de Ohm");
                infoTextView.setText(R.string.LeyDeOhm);
                formulaImagen.setImageResource(R.drawable.ohmformula);
                break;
            case 1:
                tituloTxt.setText("Circulo de Formas");
                infoTextView.setText(R.string.DiagramaCircular);
                formulaImagen.setImageResource(R.drawable.circuloformula);
                break;
            case 2:
                tituloTxt.setText("Ley de Coulomb");
                infoTextView.setText(R.string.LeyDeCoulomb);
               formulaImagen.setImageResource(R.drawable.leycoulomb);
                break;
            case 3:
                tituloTxt.setText("Energía potencial electroestática");
                infoTextView.setText(R.string.EnergiaPotencialElectroestatica);
                formulaImagen.setImageResource(R.drawable.ep);
                break;
            case 4:
                tituloTxt.setText("Reactancia capacitiva");
                infoTextView.setText(R.string.ReactanciaCapacitiva);
                formulaImagen.setImageResource(R.drawable.reactanciacapacitiva);
                break;
            case 5:
                tituloTxt.setText("Reactancia inductiva");
                infoTextView.setText(R.string.ReactanciaInductiva);
                formulaImagen.setImageResource(R.drawable.reactanciainductiva);
                break;
            case 6:
                tituloTxt.setText("Impedancia");
                infoTextView.setText(R.string.Impedancia);
                formulaImagen.setImageResource(R.drawable.impedanciados);
                break;
            case 7:
                tituloTxt.setText("Magnetismo y almacenamiento de la informacion");
                infoTextView.setText("A continuación se mostrarán 2 tablas. Una con fórmulas del campo magnético " +
                        " y otra del significado de sus símbolos.");
                formulaImagen.setImageResource(R.drawable.dostablas);
                break;
        }
    }
}
