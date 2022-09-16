package pe.edu.pucp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

import pe.edu.pucp.myapplication.entity.Monitor;

public class MonitorActivity2 extends AppCompatActivity {

    ArrayList<Monitor> monitores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor2);
        //monitor solo es listar, buscar y borrar


        

    }



    public void borrarMonitor(Integer i){
        monitores.remove(i);
    }

    public Monitor buscar(String buscar){
        Monitor respuesta = null;
        for (Monitor moni : monitores){
            if (moni.getActivo().equals(buscar)){
                return respuesta;
            }
        }
        return respuesta;
    }
}