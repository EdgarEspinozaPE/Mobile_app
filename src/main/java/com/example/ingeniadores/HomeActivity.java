package com.example.ingeniadores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView ubicacion = findViewById(R.id.cardUbicacion);
        ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,UbicacionActivity.class));
            }
        });

        CardView micuenta = findViewById(R.id.cardCuenta);
        micuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MiCuentaActivity.class));
            }
        });

        CardView serviciotecnico = findViewById(R.id.cardServTec);
        serviciotecnico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SoporteTecnicoActivity.class));
            }
        });

        CardView fotosyvideos = findViewById(R.id.cardFotVid);
        fotosyvideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,FotosVideosActivity.class));
            }
        });

        CardView micodekey = findViewById(R.id.cardCodekey);
        micodekey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,MiCodeKeyActivity.class));
            }
        });

    }
}