package com.example.tleng2023;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tleng2023.configuracion.SQLiteConexion;
import com.example.tleng2023.configuracion.Transacciones;
import com.example.tleng2023.tablas.Personas;

import java.util.ArrayList;

public class ActivitList extends AppCompatActivity
{

    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activit_list);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listapersonas = (ListView) findViewById(R.id.listapersonas);
        ObtenerListaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas );
        listapersonas.setAdapter(adp);
    }

    private void ObtenerListaPersonas()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<Personas>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Transacciones.tablaperson, null);

        while(cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            lista.add(person);
        }

        cursor.close();

        filllist();
    }

    private void filllist()
    {
        ArregloPersonas = new ArrayList<String>();
        for(int i = 0; i < lista.size(); i++)
        {
            ArregloPersonas.add(lista.get(i).getId() + " | "+
                                lista.get(i).getNombres() + " | " +
                                lista.get(i).getId() + " | ");
    }
}