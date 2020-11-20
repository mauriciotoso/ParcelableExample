package com.example.parcelableexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText dni,nombre,apellido;
    Button mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dni = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        apellido= findViewById(R.id.apellido);
        mostrar= findViewById(R.id.mostrar);

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dni.getText().toString().compareTo("")!=0&&nombre.getText().toString().compareTo("")!=0&&apellido.getText().toString().compareTo("")!=0){

                    Usuario u= new Usuario(Integer.parseInt(dni.getText().toString()),nombre.getText().toString(),apellido.getText().toString());
                    Intent i = new Intent(MainActivity.this,MostrarUsuario.class);
                    i.putExtra("Usuario",u);
                    startActivityForResult(i,1);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                String s = data.getExtras().getString("RESULTADO");
                Toast t = Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }
}