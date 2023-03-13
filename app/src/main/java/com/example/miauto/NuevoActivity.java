package com.example.miauto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miauto.db.DbAutos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtPlaca, txtMarca, txtModelo, txtCilindraje, txtColor;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtPlaca = findViewById(R.id.txtPlaca);
        txtMarca = findViewById(R.id.txtMarca);
        txtModelo = findViewById(R.id.txtModelo);
        txtCilindraje = findViewById(R.id.txtCilindraje);
        txtColor = findViewById(R.id.txtColor);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbAutos dbAutos = new DbAutos(NuevoActivity.this);
                long id = dbAutos.insertarAutos(txtPlaca.getText().toString(), txtMarca.getText().toString(), txtModelo.getText().toString(), txtCilindraje.getText().toString(),txtColor.getText().toString());

                if(id>0){
                    Toast.makeText(NuevoActivity.this,"REGISTRO GUARDADO",Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this,"ERROR AL GUARDAR REGISTRO",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void limpiar(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCilindraje.setText("");
        txtColor.setText("");
    }
}