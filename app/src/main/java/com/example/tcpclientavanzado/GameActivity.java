package com.example.tcpclientavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements ComunicacionTCP.OnMessageListener {

    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
        String ip = getIntent().getExtras().getString("IP");
        ComunicacionTCP comm = new ComunicacionTCP(this);
        comm.setObserver(this);
        comm.solicitarConexion( ip );

    }

    @Override
    public void onMessage(String mensaje) {

        if(mensaje.equals("NO")){
           runOnUiThread(

                   ()-> {

                   Toast.makeText(this, "Está mal escrito", Toast.LENGTH_LONG).show();


                   }

           );
        }


}

}
