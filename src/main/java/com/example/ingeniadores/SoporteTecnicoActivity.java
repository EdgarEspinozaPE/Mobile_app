package com.example.ingeniadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SoporteTecnicoActivity extends AppCompatActivity {

    Button btn;
    TextView reporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soporte_tecnico);


        btn=findViewById(R.id.buttonEnvReporte);
        reporte=findViewById(R.id.editTextSopReporte);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reporte.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Complete su reporte", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Reporte enviado con éxito", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SoporteTecnicoActivity.this,HomeActivity.class));
                }
            }
        });
    }
}