package com.example.basedatos;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BaseDatos {

    private SQLiteDatabase sqlitedDB;
    private Context context;

    private String nombreDB;
    private String tablaMat = "create table materia(claveMateria int not null, nombreMateria varchar(50) not null, constraint cveMatPK primary key(claveMateria))";

    public BaseDatos(Context context, String nombreDB) {
        this.context = context;
        this.nombreDB = nombreDB;
    }
    public void abrirCrearDB(){
        sqlitedDB = context.openOrCreateDatabase(nombreDB, Context.MODE_PRIVATE, null);
    }
    public void cerrarDB(){
        sqlitedDB.close();
    }
    public void crearTabla(){
        sqlitedDB.execSQL(tablaMat);
    }
    public void insertarMateria(Materia materia){
        ContentValues valores = new ContentValues();
        valores.put("claveMateria", materia.getClaveMateria());
        valores.put("nombreMateria", materia.getNombreMateria());
    sqlitedDB.insert("materia", null, valores);
    }
    public Cursor consultarMat(int clave){
        Cursor resultado = sqlitedDB.rawQuery("select * from materia where claveMateria="+clave, null);
        return  resultado;
    }
}


