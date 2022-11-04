package com.example.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class jugadoresActivity extends AppCompatActivity {
    private int tiempo;
    private Timer reloj;
    private TimerTask tarea;
    private TextView cTurno;
    private TextView tiempoCont;
    private Boolean turno=false;
    private Boolean cambio=false;
    private int[][] matriz={
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };
    private int cantidad=3;
    private int aleatorioF;
    private int aleatorioC;
    private int aleatorio;
    private int jugadas;
    private int rec;
    private Button[][] tableroButton=new Button[cantidad][cantidad];//8
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);
        tiempoCont=findViewById(R.id.tiempoTextView2);
        cTurno=findViewById(R.id.turnoTextView2);
        cTurno.setText("X");
        inicializarTarea();
        //Bundle
        Bundle datos=this.getIntent().getExtras();
        rec=datos.getInt("Variable");
        //
        ViewGroup fichasGridLayout = findViewById(R.id.teclasGridLayout);//6
        // childCount() obtiene el numero de hijos de una vista que contiene otras vistas
        for (int i=0;i<fichasGridLayout.getChildCount();i++){//7
            //getChildAt obtiene la referencia a una vista de acuerdo a su indice
            tableroButton[i/cantidad][i%cantidad]=(Button) fichasGridLayout.getChildAt(i);//9
        }
        switch (rec) {
            case 1:
            for (int f = 0; f < cantidad; f++) {
                for (int c = 0; c < cantidad; c++) {
                    tableroButton[f][c].setOnClickListener(seleccionar1);
                }
            }
            break;
            case 2:
                for (int f = 0; f < cantidad; f++) {
                    for (int c = 0; c < cantidad; c++) {
                        tableroButton[f][c].setOnClickListener(seleccionar2);
                    }
                }
            break;
            case 3:
                for (int f = 0; f < cantidad; f++) {
                    for (int c = 0; c < cantidad; c++) {
                        tableroButton[f][c].setOnClickListener(seleccionar3);
                    }
                }
            break;
        }
    }

    View.OnClickListener seleccionar1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int f = 0; f < cantidad; f++) {
                for (int c = 0; c < cantidad; c++) {
                    if (tableroButton[f][c] == view && matriz[f][c] == 0) {
                        if (turno == false) {
                            tableroButton[f][c].setText("X");
                            matriz[f][c] = 1;
                            comprobarX();
                            turno = true;
                            cTurno.setText("O");
                            break;
                        } else if(turno==true){
                            tableroButton[f][c].setText("O");
                            matriz[f][c] = 2;
                            comprobarO();
                            turno = false;
                            cTurno.setText("X");
                            break;
                        }
                    }
                }
            }
        }
    };
    View.OnClickListener seleccionar2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int f = 0; f < cantidad; f++) {
                for (int c = 0; c < cantidad; c++) {
                    if (tableroButton[f][c] == view && matriz[f][c] == 0) {
                        matriz[f][c] = 1;
                        tableroButton[f][c].setText("X");
                        comprobarX();
                        turno = true;
                        cTurno.setText("O");

                        //dificultad facil
                        Random ram=new Random();
                        do {
                            aleatorioF = ram.nextInt(cantidad);
                            aleatorioC = ram.nextInt(cantidad);
                            aleatorio++;
                            if(aleatorio==3){
                                cambio=true;
                            }
                        } while (matriz[aleatorioF][aleatorioC]!=0 && cambio==false);
                        if(cambio==true) {
                            aleatorioF=0;
                            aleatorioC=0;
                            for (int v = 0; v < cantidad; v++) {
                                for (int b = 0; b < cantidad; b++) {
                                    if (matriz[v][b] == 0) {
                                        aleatorioF=v;
                                        aleatorioC=b;
                                        cambio = false;
                                        break;
                                    }
                                }
                            }
                        }
                        matriz[aleatorioF][aleatorioC]=2;
                        tableroButton[aleatorioF][aleatorioC].setText("O");
                        comprobarO();
                        turno=false;
                        cTurno.setText("X");
                        break;
                    }
                }
            }
        }
    };

    View.OnClickListener seleccionar3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int f = 0; f < cantidad; f++) {
                for (int c = 0; c < cantidad; c++) {
                    if (tableroButton[f][c] == view && matriz[f][c] == 0) {
                        matriz[f][c] = 1;
                        tableroButton[f][c].setText("X");
                        comprobarX();
                        turno = true;
                        cTurno.setText("O");
                        //dificultad media

                        Random ram=new Random();
                        do {//advertencia: no ingresar mas procesos aqui para evitar bucles
                            aleatorioF = ram.nextInt(cantidad);
                            aleatorioC = ram.nextInt(cantidad);
                            aleatorio++;
                            if(aleatorio==3){
                                cambio=true;
                            }
                        } while (matriz[aleatorioF][aleatorioC]!=0 && cambio==false);
                        if(cambio==true) {
                            aleatorioF=0;
                            aleatorioC=0;
                            for (int v = 0; v < cantidad; v++) {
                                for (int b = 0; b < cantidad; b++) {
                                    if (matriz[v][b] == 0) {
                                        aleatorioF=v;
                                        aleatorioC=b;
                                        cambio = false;
                                        break;
                                    }
                                }
                            }
                        }
                        for(int w=0;w<cantidad;w++){
                            if(matriz[w][0]==1 && matriz [w][1]==1 && matriz[w][2]==0){
                                aleatorioF=w;
                                aleatorioC=2;
                                break;
                            }
                            if (matriz[w][1]==1 && matriz[w][2]==1 && matriz[w][0]==0){
                                aleatorioF=w;
                                aleatorioC=0;
                                break;
                            }
                            if(matriz[w][0]==1 && matriz[w][2]==1 && matriz[w][1]==0){
                                aleatorioF=w;
                                aleatorioC=1;
                                break;
                            }
                            if(matriz[0][w]==1 && matriz[1][w]==1 && matriz[2][w]==0){
                                aleatorioF=2;
                                aleatorioC=w;
                                break;
                            }
                            if(matriz[1][w]==1 && matriz[2][w]==1 && matriz[0][w]==0){
                                aleatorioF=0;
                                aleatorioC=w;
                                break;
                            }
                            if(matriz[0][w]==1 && matriz[2][w]==1 && matriz[1][w]==0){
                                aleatorioF=1;
                                aleatorioC=w;
                                break;
                            }
                        }
                        if(matriz[0][0]==1 && matriz[1][1]==1 && matriz[2][2]==0){
                            aleatorioF=2;
                            aleatorioC=2;
                        }
                        else if(matriz[1][1]==1 && matriz[2][2]==1 && matriz[0][0]==0){
                            aleatorioF=0;
                            aleatorioC=0;
                        }
                        else if(matriz[0][0]==1 && matriz[2][2]==1 && matriz[1][1]==0){
                            aleatorioF=1;
                            aleatorioC=1;
                        }
                        else if(matriz[0][2]==1 && matriz[1][1]==1 && matriz[2][0]==0){
                            aleatorioF=2;
                            aleatorioC=0;
                        }
                        else if(matriz[2][0]==1 && matriz[1][1]==1 && matriz[0][2]==0){
                            aleatorioF=0;
                            aleatorioC=2;
                        }
                        else if(matriz[2][0]==1 && matriz[0][2]==1 && matriz[1][1]==0){
                            aleatorioF=1;
                            aleatorioC=1;
                        }
                        matriz[aleatorioF][aleatorioC]=2;
                        tableroButton[aleatorioF][aleatorioC].setText("O");
                        comprobarO();
                        turno=false;
                        cTurno.setText("X");
                        break;
                    }
                }
            }

        }
    };
    public void comprobarX(){
        jugadas++;

        if (matriz[0][0] ==1 && matriz[0][1]==1 && matriz[0][2]==1 && turno==false) {
            enviarVictoriaX();
        } else if (matriz[1][0] ==1 && matriz[1][1]==1 && matriz[1][2]==1 && turno==false) {
            enviarVictoriaX();
        } else if (matriz[2][0] ==1 && matriz[2][1]==1 && matriz[2][2]==1 && turno==false) {
            enviarVictoriaX();
        } else if (matriz[0][0] ==1 && matriz[1][1]==1 && matriz[2][2]==1 && turno==false) {
            enviarVictoriaX();
        } else if (matriz[0][2] ==1 && matriz[1][1]==1 && matriz[2][0]==1 && turno==false) {
            enviarVictoriaX();
        } else if (matriz[0][0] ==1 && matriz[1][0]==1 && matriz[2][0]==1 && turno==false) {
            enviarVictoriaX();
        } else if (matriz[0][1] ==1 && matriz[1][1]==1 && matriz[2][1]==1 && turno==false) {
            enviarVictoriaX();
        } else if (matriz[0][2] ==1 && matriz[1][2]==1 && matriz[2][2]==1 && turno==false) {
            enviarVictoriaX();
        } else if(jugadas==9){
            enviarEmpate();
        }
    }

    public void comprobarO(){
        jugadas++;
        if (matriz[0][0] ==2 && matriz[0][1]==2 && matriz[0][2]==2 && turno==true) {
            enviarVictoriaO();
        } else if (matriz[1][0] ==2 && matriz[1][1]==2 && matriz[1][2]==2 && turno==true) {
            enviarVictoriaO();
        } else if (matriz[2][0] ==2 && matriz[2][1]==2 && matriz[2][2]==2 && turno==true) {
            enviarVictoriaO();
        } else if (matriz[0][0] ==2 && matriz[1][1]==2 && matriz[2][2]==2 && turno==true) {
            enviarVictoriaO();
        } else if (matriz[0][2] ==2 && matriz[1][1]==2 && matriz[2][0]==2 && turno==true) {
            enviarVictoriaO();
        } else if (matriz[0][0] ==2 && matriz[1][0]==2 && matriz[2][0]==2 && turno==true) {
            enviarVictoriaO();
        } else if (matriz[0][1] ==2 && matriz[1][1]==2 && matriz[2][1]==2 && turno==true) {
            enviarVictoriaO();
        } else if (matriz[0][2] ==2 && matriz[1][2]==2 && matriz[2][2]==2 && turno==true) {
            enviarVictoriaO();
        } else if(jugadas==8){
            enviarEmpate();
        }
    }


    public void enviarEmpate(){

        Intent intento=new Intent(jugadoresActivity.this,VictoriaActivity.class);
        intento.putExtra("Victoria",1);
        intento.putExtra("Volver",rec);
        startActivity(intento);
        finish();
    }
    public void enviarVictoriaX(){
        Intent intento=new Intent(jugadoresActivity.this,VictoriaActivity.class);
        intento.putExtra("Victoria",2);
        startActivity(intento);
        finish();
    }
    public void enviarVictoriaO(){
        Intent intento=new Intent(jugadoresActivity.this,VictoriaActivity.class);
        intento.putExtra("Victoria",3);
        startActivity(intento);
        finish();
    }

    void inicializarTarea(){
        tiempo=0;

        if (reloj!=null){
            reloj.cancel();
            reloj=null;
        }
        reloj=new Timer();

        tarea=new TimerTask() {
            @Override
            public void run() {
                tiempo+=1;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String cadena=String.format("%02d:%02d",tiempo/60,tiempo%60);
                        tiempoCont.setText(cadena);
                    }
                });

            }
        };
        reloj.schedule(tarea,0,1000);
    }
}
