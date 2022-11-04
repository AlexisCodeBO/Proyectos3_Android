package com.example.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VictoriaActivity extends AppCompatActivity {
    //private int valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoria);

        TextView textoo=findViewById(R.id.textoVictoria);
        Bundle db=this.getIntent().getExtras();
        int num=db.getInt("Victoria");
        //valor=db.getInt("Volver");
        //Button b1=findViewById(R.id.volver1Button);
        //b1.setOnClickListener(volverJ);
        Button b2=findViewById(R.id.volver2Button);
        b2.setOnClickListener(volverM);
        switch (num){
            case 1:
                textoo.setText(R.string.tituloEmpate);
                break;
            case 2:
                textoo.setText(R.string.tituloVictoriaX);
                break;
            case 3:
                textoo.setText(R.string.tituloVictoriaO);
                break;
        }
    }

    View.OnClickListener volverM=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intento=new Intent(VictoriaActivity.this,MainActivity.class);
            startActivity(intento);
            finish();
        }
    };
    /*
    View.OnClickListener volverJ=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intento=new Intent(VictoriaActivity.this,jugadoresActivity.class);
            intento.putExtra("Variable",valor);
            startActivity(intento);
            finish();
        }
    };
    */
}
