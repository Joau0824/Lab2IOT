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

public class AgregarTecladoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado_agregar);


        //spinner PC activos

        List<String> valuesSpinner = new ArrayList<>();
        valuesSpinner.add(0,"PC Activo:");

        for (Computadora comp: listaComputadoras.getListaComputadoras()){
            valuesSpinner.add(comp.getActivo());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,valuesSpinner);
        Spinner spinner = findViewById(R.id.activo_pc_teclado);
        spinner.setAdapter(arrayAdapter);


        //spinner Marcas
        String [] marcas={"Marca:","Asus","Lenovo","Msi","Razer","Microsoft","Logitech","VSG"};
        ArrayAdapter<String> adapterMarcas= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,marcas);
        Spinner spinnerMarcas =findViewById(R.id.marca_teclado);
        //pinnerMarcas.setPrompt("Marca");
        spinnerMarcas.setAdapter(adapterMarcas);

        //spinner Idioma
        String [] idiomas={"Idioma:","Español Latam","Ingles","Frances","Italiano","Chino","Japones","Coreano"};
        ArrayAdapter<String> adapterIdioma= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,idiomas);
        Spinner spinnerIdioma =findViewById(R.id.idioma_teclado);
        spinnerIdioma.setAdapter(adapterIdioma);





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

                //obteniendo texto ingresado año
                EditText editTextAnio = findViewById(R.id.anio_teclado);
                String anio = editTextAnio.getText().toString();


                //obteniendo texto ingresado modelo
                EditText editTextModelo = findViewById(R.id.modelo_teclado);
                String modelo = editTextModelo.getText().toString();

                //se añade a la lista dinamica

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
