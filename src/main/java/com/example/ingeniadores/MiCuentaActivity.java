package com.example.ingeniadores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MiCuentaActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_cuenta);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String email = sharedpreferences.getString("email","").toString();
        Database db = new Database(getApplicationContext(),"ingeniadores",null,1);
        String username = db.getuser(email);
        TextView textView = findViewById(R.id.editCuentaEmail);
        textView.setText(username);

        btn = findViewById(R.id.buttonCerrarSesion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(MiCuentaActivity.this,LoginActivity.class));
            }
        });
    }
}