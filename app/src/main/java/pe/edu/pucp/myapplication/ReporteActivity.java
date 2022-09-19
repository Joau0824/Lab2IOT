package pe.edu.pucp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import pe.edu.pucp.myapplication.entity.Computadora;
import pe.edu.pucp.myapplication.entity.listaComputadoras;
import pe.edu.pucp.myapplication.entity.ListaTeclados;
import pe.edu.pucp.myapplication.entity.Teclado;

public class ReporteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        if(listaComputadoras.getListaComputadoras().size() >0){
            String cantidad_computadoras = "-Total: "+ listaComputadoras.getListaComputadoras().size();
            ((TextView)findViewById(R.id.reporte_computadoras)).setText(cantidad_computadoras);

        }else{
            TextView textView= findViewById(R.id.reporte_computadoras);
            textView.setText("No se registran monitores");
        }

        if(listaComputadoras.getListaComputadoras().size() >0){
            String cantidad_computadoras= "Monitores: " + listaComputadoras.getListaComputadoras().size();
            ((TextView)findViewById(R.id.reporte_monitor)).setText(cantidad_computadoras);

        }else{
            TextView textView= findViewById(R.id.reporte_monitor);
            textView.setText("Monitores: No se registran monitores");
        }

        if(ListaTeclados.getListTeclados().size() > 0){
            String cantidad_teclados = "Teclados: "+ListaTeclados.getListTeclados().size();
            ((TextView)findViewById(R.id.reporte_teclado)).setText(cantidad_teclados);

        }else{
            TextView textView= findViewById(R.id.reporte_teclado);
            textView.setText("Teclados: No se registran teclados");
        }
    }
}
