package com.gmail.escolhatime;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaTimesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_times);

        List<String> times = new ArrayList<>(Arrays.asList("Vasco", "Outro Vasco", "Mais um Vasco"));
        final ListView listaDeTimes = findViewById(R.id.lista);
        listaDeTimes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, times));

        listaDeTimes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String timeEscolhido = (String) listaDeTimes.getItemAtPosition(position);
                Intent voltaProInicio = new Intent(ListaTimesActivity.this, MainActivity.class);
                voltaProInicio.putExtra("time", timeEscolhido);
                setResult(Activity.RESULT_OK, voltaProInicio);
                finish();
            }
        });

    }
}
