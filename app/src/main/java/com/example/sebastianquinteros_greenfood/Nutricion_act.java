package com.example.sebastianquinteros_greenfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Nutricion_act extends AppCompatActivity {

    private EditText et1, et2, et3, et4;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricion_act);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
        et4 = (EditText)findViewById(R.id.et4);
        texto = (TextView) findViewById(R.id.tv1);

        String valor = getIntent().getStringExtra("titulo");
        texto.setText(valor);

    }

    public void Home(View v){

        Intent i = new Intent(this, Nutricion_act.class);
        startActivity(i);
    }

    public void Calcular(View v){
        int dato1 = Integer.parseInt(et2.getText().toString());
        int dato2 = Integer.parseInt(et3.getText().toString());
        et4.setText("El valor Final es: "+Integer.toString(dato1*dato2));

    }

    public void Web(View v){

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.saludstgo.cl/programa-vida-sana/"));
    }

}
