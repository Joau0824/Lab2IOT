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

public class ActualizarTecladoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado_agregar);


        //obtengo el teclado que quiero actualizar
        Teclado teclado_actualiz=(Teclado) getIntent().getSerializableExtra("tecladoActualizar");


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

        spinnerMarcas.setAdapter(adapterMarcas);

        //spinner Idioma
        String [] idiomas={"Idioma:","Español Latam","Ingles","Frances","Italiano","Chino","Japones","Coreano"};
        ArrayAdapter<String> adapterIdioma= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,idiomas);
        Spinner spinnerIdioma =findViewById(R.id.idioma_teclado);

        spinnerIdioma.setAdapter(adapterIdioma);


        //Seleccion para PC activo

        for (int i=0; i<valuesSpinner.size(); i++){
            if(valuesSpinner.get(i).equals(teclado_actualiz.getActivo())){
                spinnerMarcas.setSelection(i);
            }
        }


        //Seleccion para marcas
        for (int i=0; i<marcas.length; i++){
            if(marcas[i].equals(teclado_actualiz.getMarca())){
                spinnerMarcas.setSelection(i);
            }
        }

        //Seleccion para idioma
        for (int i=0; i<idiomas.length; i++){
            if(idiomas[i].equals(teclado_actualiz.getIdioma())){
                spinnerIdioma.setSelection(i);
            }
        }

        EditText anio_tecl = findViewById(R.id.anio_teclado);
        anio_tecl.setText(teclado_actualiz.getAnio());
        EditText modelo_tecl = findViewById(R.id.modelo_teclado);
        modelo_tecl.setText(teclado_actualiz.getModelo());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actualizar_teclado,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Integer position = Integer.parseInt(getIntent().getStringExtra("posicion"));
        switch (item.getItemId()) {
            case R.id.btn_guar_actualiz_teclado:

                //Log.d("msg", "botón alert presionado");

                //guardar la data del formulario(crear)
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

                //se actualiza en el objeto de la lista dinamica

                Teclado tecl= ListaTeclados.getListTeclados().get(position);
                tecl.setAnio(anio);
                tecl.setActivo(textoStringActivo);
                tecl.setActivoPC(pcactivo);
                tecl.setIdioma(idioma);
                tecl.setMarca(marca);
                tecl.setModelo(modelo);

                Intent intent = new Intent(this,TecladoActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_borrar_teclado:
                ListaTeclados.eliminarTeclado(ListaTeclados.getListTeclados().get(position));
                Intent intent2 = new Intent(this,TecladoActivity.class);
                startActivity(intent2);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
