package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.basedatos.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding vista;
    private BaseDatos baseDatos;
    private String nombreDB = "Escuela";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vista = ActivityMainBinding.inflate(getLayoutInflater());
        View vistaview =  vista.getRoot();
        setContentView(vistaview);
        buttons();
    }
    private void crearDB(){
        baseDatos = new BaseDatos(getApplicationContext(),nombreDB);
        baseDatos.abrirCrearDB();
        baseDatos.crearTabla();
        baseDatos.cerrarDB();
    }
    private void insertarMateria(){
        try {
            baseDatos = new BaseDatos(getApplicationContext(), nombreDB);
            baseDatos.abrirCrearDB();
            Materia materia = new Materia(Integer.parseInt(vista.txtEdClave2.getText().toString()), vista.txtEdNombre.getText().toString());
            baseDatos.insertarMateria(materia);
            Toast.makeText(this, "Inserada correctamente", Toast.LENGTH_SHORT).show();
        }
        catch (Exception err){
            Log.i("Error insertar", err.toString());
        }
    }
    private void consultarMateriaporID(){

            baseDatos = new BaseDatos(getApplicationContext(), nombreDB);
            baseDatos.abrirCrearDB();
            Cursor resultado = baseDatos.consultarMat(Integer.parseInt((vista.txtEdClave2.getText().toString())));
        if (resultado.getCount() == 0){
            Toast.makeText(getApplicationContext(), "No se encuentra la clave. ", Toast.LENGTH_LONG).show();
        }
        else {
            resultado.moveToFirst();
            vista.txtEdNombre.setText(resultado.getString(1));
        }
            baseDatos.cerrarDB();
    }


    private void buttons(){
        vista.btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearDB();
            }
        });
        vista.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarMateria();
            }
        });
        vista.btnSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {consultarMateriaporID();}
        });
    }
}