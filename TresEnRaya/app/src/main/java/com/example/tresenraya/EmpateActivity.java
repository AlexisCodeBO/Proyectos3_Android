package com.example.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmpateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empate);
        //Button b1=findViewById(R.id.volver1Button);
        //b1.setOnClickListener(volverJ);
        Button b2=findViewById(R.id.volver2Button);
        b2.setOnClickListener(volverM);
    }

    View.OnClickListener volverM=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intento=new Intent(EmpateActivity.this,MainActivity.class);
            startActivity(intento);
            finish();
        }
    };
}
