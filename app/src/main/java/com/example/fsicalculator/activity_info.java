package com.example.fsicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class activity_info extends AppCompatActivity implements ListView.OnItemClickListener {
    Intent intentoTema1, intentoTema2,intentoTema3;
    ListView listInfo;
    String[] temas =
            {"3.1-Fenómenos electrostáticos y electrodinámicos",
                    "3.2. Impedancia y reactancia",
                    "3.3. Magnetismo y almacenamiento de información",
                    "3.4. Relación entre corriente y magnetismo",
                    "3.5. Espectro electromagnético  y  su clasificación",
                    "3.6. Efecto (Ley) Joule vs Ley de Termodinámica"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        listInfo = findViewById(R.id.listInfo);
        listInfo.setAdapter(new ArrayAdapter<String>(
                this,R.layout.row,temas
        ));
        listInfo.setOnItemClickListener(this);
        intentoTema1 = new Intent(this,tema1Activity.class);
        intentoTema2 = new Intent(this,tema2Activity.class);
        intentoTema3= new Intent(this,tema3Activity.class);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,temas[position], Toast.LENGTH_SHORT).show();
        if (position==0){
          startActivity(intentoTema1);
        }else if(position==1){
            startActivity(intentoTema2);
        }else if(position==2){
            startActivity(intentoTema3);
        }
    }
}
