package com.example.miauto.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.miauto.entidades.Autos;

import java.util.ArrayList;

public class DbAutos extends DbHelper {

    Context context;

    public DbAutos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarAutos(String placa, String marca,String modelo,String cilindraje, String color){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("placa", placa);
            values.put("marca", marca);
            values.put("modelo", modelo);
            values.put("cilindraje", cilindraje);
            values.put("color", color);

            id = db.insert(TABLE_AUTOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
    public ArrayList<Autos>mostrasAutos(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Autos>listaAutos = new ArrayList<>();
        Autos autos = null;
        Cursor cursorAutos = null;

        cursorAutos = db.rawQuery("SELECT * FROM " + TABLE_AUTOS, null);

        if(cursorAutos.moveToFirst()){
            do{
                autos = new Autos();
                autos.setId(cursorAutos.getInt(0));
                autos.setPlaca(cursorAutos.getString(1));
                autos.setMarca(cursorAutos.getString(2));
                autos.setModelo(cursorAutos.getString(3));
                autos.setCilindraje(cursorAutos.getString(4));
                autos.setColor(cursorAutos.getString(5));

                listaAutos.add(autos);
            }while (cursorAutos.moveToNext());
        }
        cursorAutos.close();
        return listaAutos;
    }
}
