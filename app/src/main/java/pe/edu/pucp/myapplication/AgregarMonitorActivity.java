package pe.edu.pucp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import pe.edu.pucp.myapplication.entity.Computadora;
import pe.edu.pucp.myapplication.entity.ListaTeclados;
import pe.edu.pucp.myapplication.entity.Teclado;
import pe.edu.pucp.myapplication.entity.listaComputadoras;

public class AgregarMonitorActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_agregar);
        this.setTitle(R.string.titulo_agregar_teclado);


        //spinner PC activos

        List<String> valuesSpinner = new ArrayList<>();
        valuesSpinner.add(0,"PC Activo:");

        for (Computadora comp: listaComputadoras.getListaComputadoras()){
            valuesSpinner.add(comp.getActivo());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,valuesSpinner);
        Spinner spinner = findViewById(R.id.activo_pc_monitor);
        spinner.setAdapter(arrayAdapter);

        //spinner Marcas
        String [] marcas={"Marca:","Asus","Lenovo","Msi","Samsung","Microsoft","VSG"};
        ArrayAdapter<String> adapterMarcas= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,marcas);
        Spinner spinnerMarcas =findViewById(R.id.marca_monitor);
        spinnerMarcas.setAdapter(adapterMarcas);

        //spinner Pulgadas
        String [] pulgadas={"12", "14", "17", "20"};
        ArrayAdapter<String> adapterPulgadas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,pulgadas);
        Spinner spinnerPulgadas = findViewById(R.id.pulgadas_monitor);
        spinnerPulgadas.setAdapter(adapterPulgadas);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.check_teclado:

                //obteniendo texto ingresado
                EditText textoActivoTecl = findViewById(R.id.activo_teclado);
                String textoStringActivo = textoActivoTecl.getText().toString();
                //obteniendo de la lista pcs
                Spinner spinnerPcActivo =findViewById(R.id.activo_pc_teclado);
                String pcactivo=spinnerPcActivo.getSelectedItem().toString();
                if (pcactivo.equals("PC Activo:")){
                    pcactivo="";
                }

                //obteniendo de la lista marcas
                Spinner spinnerMarcas =findViewById(R.id.marca_teclado);
                String marca=spinnerMarcas.getSelectedItem().toString();
                if (marca.equals("Marca:")){
                    marca="";
                }


                //obteniendo de la lista idioma
                Spinner spinnerIdioma =findViewById(R.id.idioma_teclado);
                String idioma=spinnerIdioma.getSelectedItem().toString();
                if (idioma.equals("Idioma:")){
                    idioma="";
                }

                //obteniendo texto ingresado a??o
                EditText editTextAnio = findViewById(R.id.anio_teclado);
                String anio = editTextAnio.getText().toString();


                //obteniendo texto ingresado modelo
                EditText editTextModelo = findViewById(R.id.modelo_teclado);
                String modelo = editTextModelo.getText().toString();

                //se a??ade a la lista dinamica

                Teclado pruebatecl = new Teclado(textoStringActivo,pcactivo,marca,anio,idioma,modelo);
                ListaTeclados.agregarTeclado(pruebatecl);


                Intent intent = new Intent(this,TecladoActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check_teclado,menu);
        return true;
    }

}
