package com.example.miauto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.miauto.adaptadores.ListaAutosAdapter;
import com.example.miauto.db.DbAutos;
import com.example.miauto.db.DbHelper;
import com.example.miauto.entidades.Autos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaAutos;
    ArrayList<Autos>listaArrayAutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAutos = findViewById(R.id.listaAutos);

        listaAutos.setLayoutManager(new LinearLayoutManager(this));
        DbAutos dbAutos = new DbAutos(MainActivity.this);

        listaArrayAutos = new ArrayList<>();

        ListaAutosAdapter adapter = new ListaAutosAdapter(dbAutos.mostrasAutos());
        listaAutos.setAdapter(adapter);

        /*
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if(db !=null){
                    Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"ERROR AL CREAR BASE DE DATOS ",Toast.LENGTH_LONG).show();
                }
            }
        });*/
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void nuevoRegistro(){
        Intent intent = new Intent(this,NuevoActivity.class);
        startActivity(intent);
    }
}