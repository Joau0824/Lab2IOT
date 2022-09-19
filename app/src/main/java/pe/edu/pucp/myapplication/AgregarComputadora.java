package pe.edu.pucp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pe.edu.pucp.myapplication.entity.Computadora;
import pe.edu.pucp.myapplication.entity.listaComputadoras;

public class AgregarComputadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_computadora);
        this.setTitle(R.string.titulo_agregar_computadora);

        //spinner computadoras
        List<String> spinner = new ArrayList<>();
        spinner.add(0,"Computadora Activo");

        for(Computadora computadora: listaComputadoras.getListaComputadoras()){
            spinner.add(computadora.getActivo());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinner);
        Spinner spinner1;

    }

}