package com.gmail.escolhatime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView caixa_time = findViewById(R.id.editText);
        caixa_time.setText("");

    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(this, ListaTimesActivity.class);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String timeEscolhido = data.getStringExtra("time");
                TextView caixa_time = findViewById(R.id.editText);
                caixa_time.setText(timeEscolhido);
            }
        }
    }
}