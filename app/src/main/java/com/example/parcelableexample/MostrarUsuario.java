package com.example.parcelableexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MostrarUsuario extends AppCompatActivity {

    Button button;
    TextView dni,nombre,apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuario);
        button=findViewById(R.id.button);

        dni = findViewById(R.id.dni2);
        nombre = findViewById(R.id.nombre2);
        apellido= findViewById(R.id.apellido2);

        Usuario u = getIntent().getParcelableExtra("Usuario");

        dni.setText(String.valueOf(u.getId()));
        nombre.setText(u.getNombre());
        apellido.setText(u.getApellido());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MostrarUsuario.this,MainActivity.class);
                i.putExtra("RESULTADO","MOSTRADO CON EXITO");
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });

    }
}