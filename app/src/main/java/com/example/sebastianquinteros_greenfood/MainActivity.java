package com.example.sebastianquinteros_greenfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
    }

    public void IniciarSecion(View v)
    {
        if(et1.getText().toString().equals("Android") && et2.getText().toString().equals("123"))
        {

            Intent i = new Intent(this, Home_act.class);
            startActivity(i);

        }
        else
        {

            et1.setText("Usuario Invalido");
        }
    }
}
