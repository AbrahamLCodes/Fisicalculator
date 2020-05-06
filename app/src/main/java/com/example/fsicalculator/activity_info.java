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
    Intent intento3;
    ListView listInfo;
    String[] temas =
            {"3.1-Fenómenos electrostáticos y electrodinámicos",
                    "3.2. Impedancia y reactancia",
                    "3.3. Magnetismo y almacenamiento de información",
                    "3.4. Relación entre corriente y magnetismo",
                    "3.5. Espectro electromagnético  y  su clasificación"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        listInfo = findViewById(R.id.listInfo);
        listInfo.setAdapter(new ArrayAdapter<String>(
                this, R.layout.row, temas
        ));
        listInfo.setOnItemClickListener(this);

        intento3 = new Intent(activity_info.this, InfoClickedActivity.class);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, temas[position], Toast.LENGTH_SHORT).show();
        intento3.putExtra("subtema", position);
        startActivity(intento3);
    }
}
