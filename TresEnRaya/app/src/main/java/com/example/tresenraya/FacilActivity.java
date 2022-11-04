package com.example.tresenraya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class FacilActivity extends AppCompatActivity {
    private int tiempo;
    private Timer reloj;
    private TimerTask tarea;
    private TextView cTurno;
    private TextView tiempoCont;
    private Boolean turno=false;
    private int aleatorioF;
    private int aleatorioC;
    private int aleatorio;
    private boolean cambio=false;
    private int[][] matriz={
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };
    private int cantidad=3;
    private Button[][] tableroButton=new Button[cantidad][cantidad];//8
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);
        tiempoCont=findViewById(R.id.tiempoTextView2);
        cTurno=findViewById(R.id.turnoTextView2);
        cTurno.setText("X");
        inicializarTarea();
        ViewGroup fichasGridLayout = findViewById(R.id.teclasGridLayout);//6
        // childCount() obtiene el numero de hijos de una vista que contiene otras vistas
        for (int i=0;i<fichasGridLayout.getChildCount();i++){//7
            //getChildAt obtiene la referencia a una vista de acuerdo a su indice
            tableroButton[i/cantidad][i%cantidad]=(Button) fichasGridLayout.getChildAt(i);//9
        }

        for (int f=0;f<cantidad;f++) {
            for (int c = 0; c < cantidad; c++) {
                tableroButton[f][c].setOnClickListener(seleccionar);
            }
        }
    }

    View.OnClickListener seleccionar=new View.OnClickListener() {
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
                    }}
            }
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    if (matriz[i][j]!=0){
                        if(i==2 && j==2){
                            Intent intento=new Intent(FacilActivity.this,EmpateActivity.class);
                            startActivity(intento);
                            finish();
                        }
                    }

                    else {
                        break;
                    }
                }
            }
        }
    };

    public void comprobarX(){
        if (matriz[0][0] ==1 && matriz[0][1]==1 && matriz[0][2]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        } else if (matriz[1][0] ==1 && matriz[1][1]==1 && matriz[1][2]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        } else if (matriz[2][0] ==1 && matriz[2][1]==1 && matriz[2][2]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][0] ==1 && matriz[1][1]==1 && matriz[2][2]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][2] ==1 && matriz[1][1]==1 && matriz[2][0]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][0] ==1 && matriz[1][0]==1 && matriz[2][0]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][1] ==1 && matriz[1][1]==1 && matriz[2][1]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][2] ==1 && matriz[1][2]==1 && matriz[2][2]==1 && turno==false) {
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivity.class);
            startActivity(inte);
            finish();
        }

    }
    public void comprobarO(){
        if (matriz[0][0] ==2 && matriz[0][1]==2 && matriz[0][2]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        } else if (matriz[1][0] ==2 && matriz[1][1]==2 && matriz[1][2]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        } else if (matriz[2][0] ==2 && matriz[2][1]==2 && matriz[2][2]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][0] ==2 && matriz[1][1]==2 && matriz[2][2]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][2] ==2 && matriz[1][1]==2 && matriz[2][0]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][0] ==2 && matriz[1][0]==2 && matriz[2][0]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][1] ==2 && matriz[1][1]==2 && matriz[2][1]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        } else if (matriz[0][2] ==2 && matriz[1][2]==2 && matriz[2][2]==2 && turno==true) {
            turno=false;
            for (int i = 0; i < cantidad; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j]=0;
                }
            }
            Intent inte=new Intent(FacilActivity.this,VictoriaActivityO.class);
            startActivity(inte);
            finish();
        }
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

