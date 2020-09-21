package com.example.sebastianquinteros_greenfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Usuarios_act extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios_act);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
    }
    // Mostramos algoritmo de cifrado

    public void MostrarAlgoritmo(View v){
        try{

            String mensaje = Encriptar(et1.getText().toString(), et2.getText().toString());
            tv1.setText(mensaje);
        }
        catch(Exception e){
            e.printStackTrace();

        }

    }
    // Metodo para generar un  SecretKey bajo un algoritmo de cifrado
    private SecretKeySpec genarateKey(String password)
    throws Exception
    {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");//Firma HMAC: se utiliza para verificar la integridad de datos
        byte[] key = password.getBytes("UTF-8");//Que mipassword acepte caracteres UTF-8
        key = sha.digest(key);

        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;

    }

    //Metodo para aplicar el algoritmo de encriptacion
    public String Encriptar(String datos, String password) throws Exception {
        if(!et2.getText().toString().isEmpty()){
            SecretKeySpec secretKey = genarateKey(password);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] datosEncriptados = cipher.doFinal(datos.getBytes());
            String datosEncriptadosString = Base64.encodeToString(datosEncriptados, Base64.DEFAULT);

            return datosEncriptadosString;

        }
        else{

            Toast.makeText(this, "Debe ingresar una contrasena", Toast.LENGTH_SHORT).show();
            return null;
        }

    }

    // Vulnerabilidades
    // Control de procesos : no se verifica la fuente de la libreria
    public native void runEcho();{
        System.loadLibrary("Mis Usuarios");
    }
    public void main(String[] args){
        runEcho();
    }

    //Hard-Coded Password
    public void validarpass(){

        if(et2.getText().toString().equals("123")){
            tv1.setText("Utilizar pass mas fuerte o use algoritmo encriptado");
        }
    }


}
