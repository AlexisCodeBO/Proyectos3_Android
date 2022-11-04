package com.example.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button dj=findViewById(R.id.dosjugadoresButton);
        dj.setOnClickListener(jugadores);
        Button df=findViewById(R.id.dificultadFacilButton);
        df.setOnClickListener(facil);
        Button dm=findViewById(R.id.dificultadMediaButton);
        dm.setOnClickListener(media);
    }
    View.OnClickListener jugadores=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intento=new Intent(MainActivity.this,jugadoresActivity.class);
            intento.putExtra("Variable",1);
            startActivity(intento);
            finish();
        }
    };
    View.OnClickListener facil=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intento=new Intent(MainActivity.this,jugadoresActivity.class);
            intento.putExtra("Variable",2);
            startActivity(intento);
            finish();
        }
    };
    View.OnClickListener media=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intento=new Intent(MainActivity.this,jugadoresActivity.class);
            intento.putExtra("Variable",3);
            startActivity(intento);
            finish();
        }
    };
}
