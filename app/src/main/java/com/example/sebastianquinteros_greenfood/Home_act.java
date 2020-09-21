package com.example.sebastianquinteros_greenfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] image = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper) findViewById (R.id.slider);

        for(int i = 0; i< image.length; i++){
            flip_image(image[i]);

        }
    }
    //Configurar Slider
    public void flip_image(int i){

        ImageView view = new ImageView(this);                       //Obtiene imageViews
        view.setBackgroundResource(i);                                      //Seteamos el Background
        vf.addView(view);                                                   //Anadimos Background al ViewFlipper
        vf.setFlipInterval(2700);                                           //anadimos un intervalo de cambio
        vf.setAutoStart(true);                                              //Le decimos que inice de forma automatica

        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }
    public void Base(View v){

        Intent i = new Intent(this, Base_act.class);
        startActivity(i);
    }

    public void Usuarios(View v){

        Intent i = new Intent(this, Usuarios_act.class);
        startActivity(i);
    }

    public void Nutricion(View v){

        Intent i = new Intent(this, Nutricion_act.class);
        i.putExtra("titulo","Cuida tu nutricion con nuestros alimentos");
        startActivity(i);
    }
    public void Maps(View v){

        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }
}
