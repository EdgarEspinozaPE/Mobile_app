package com.example.ingeniadores;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MiCodeKeyActivity extends AppCompatActivity{

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_code_key);

        btn = findViewById(R.id.buttonsave);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MiCodeKeyActivity.this,HomeActivity.class));
            }
        });

        SharedPreferences sharedpreferences=getSharedPreferences("shared_prefs",Context.MODE_PRIVATE);
        String email=sharedpreferences.getString("email","").toString();
        Database db= new Database(getApplicationContext(),"ingeniadores",null,1);
        String username = db.getuser(email);
        TextView textView=findViewById(R.id.editkeyusername);
        textView.setText(username);

        String hexKey = generateHexKey(16);
        TextView textView2=findViewById(R.id.editkeyclave);
        textView2.setText(hexKey);
    }

    public static String generateHexKey(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomValue = random.nextInt(16); // Genera un número aleatorio entre 0 y 15 (inclusive)
            char hexChar = (randomValue < 10) ? (char) ('0' + randomValue) : (char) ('A' + (randomValue - 10));
            sb.append(hexChar);
        }

        return sb.toString();
    }

}