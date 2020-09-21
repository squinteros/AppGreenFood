package com.example.sebastianquinteros_greenfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Base_act extends AppCompatActivity {

    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_act);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText)findViewById(R.id.et2);
        et3 = (EditText)findViewById(R.id.et3);
    }

    public void AddProductos(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alimentos", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        if(!et1.getText().toString().isEmpty() && !et2.getText().toString().isEmpty() && !et3.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", et1.getText().toString());
            registro.put("nombre", et2.getText().toString());
            registro.put("precio", et3.getText().toString());

            database.insert("alimentos", null, registro);
            database.close();

            Toast.makeText(this, "Se ha guardado el dato", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Debe llenar los campos necesarios", Toast.LENGTH_SHORT).show();
        }
    }


    public void MostrarProductos(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alimentos",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        if(!codigo.isEmpty())
        {
            Cursor fila = db.rawQuery("SELECT nombre, precio FROM alimentos WHERE codigo=" +codigo, null);

            if(fila.moveToFirst()){

                et2.setText(fila.getString(0));
                et3.setText(fila.getString(1));
            }

            else{
                Toast.makeText(this, "No existe profucto con codigo asociado", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Debe ingresar codigo",Toast.LENGTH_SHORT).show();
        }
    }

    public void EliminarProductos(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alimentos", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        if(!codigo.isEmpty()){
            database.delete("alimentos", "codigo="+codigo, null);
            database.close();

            Toast.makeText(this, "Se ha eliminado el producto " +codigo, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_LONG).show();
        }
    }

    public void ModificarProductos(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "alimentos", null, 1);
        SQLiteDatabase database = admin.getWritableDatabase();

        String codigo = et1.getText().toString();

        ContentValues content = new ContentValues();
        content.put("codigo", et1.getText().toString());
        content.put("nombre", et2.getText().toString());
        content.put("precio", et3.getText().toString());

        if(!codigo.isEmpty()){
            database.update("alimentos", content, "codigo="+codigo, null);
            database.close();

            Toast.makeText(this, "Se ha actualizado el producto: ="+codigo, Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this, "Debe ingresar un codigo", Toast.LENGTH_LONG).show();

        }
    }
}
