package pe.edu.pucp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pe.edu.pucp.myapplication.entity.Computadora;
import pe.edu.pucp.myapplication.entity.listaComputadoras;
import pe.edu.pucp.myapplication.entity.ListaTeclados;
import pe.edu.pucp.myapplication.entity.Teclado;

import android.os.Bundle;

public class TecladoActualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado_actualizar);
        this.setTitle(R.string.titulo_actualizar_teclado);

        Teclado teclado_update=(Teclado) getIntent().getSerializableExtra("tecladoActualizar");


        List<String> valuesSelect = new ArrayList<>();
        valuesSelect.add(0,"PC Activo:");


        for (Computadora comp: listaComputadoras.getListaComputadoras()){
            valuesSelect.add(comp.getActivo());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,valuesSelect);
        Spinner spinner = findViewById(R.id.spinner_activo_actualizar_teclado);
        spinner.setAdapter(arrayAdapter);


        //select Marcas
        String [] marcas={"Marca:","Asus","Lenovo","Msi","Razer","Microsoft","Logitech","VSG"};
        ArrayAdapter<String> adapterMarcas= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,marcas);
        Spinner selectMarcas =findViewById(R.id.spinner_marca_actualizar_teclado);

        selectMarcas.setAdapter(adapterMarcas);

        //select Idioma
        String [] idiomas={"Idioma:","Español Latam","Ingles","Frances","Italiano","Chino","Japones","Coreano"};
        ArrayAdapter<String> adapterIdioma= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,idiomas);
        Spinner selectIdioma =findViewById(R.id.spinner_idioma_actualizar_teclado);

        selectIdioma.setAdapter(adapterIdioma);


        for (int i=0; i<valuesSelect.size(); i++){
            if(valuesSelect.get(i).equals(teclado_update.getActivo())){
                selectMarcas.setSelection(i);
            }
        }


        //Seleccion para marcas
        for (int i=0; i<marcas.length; i++){
            if(marcas[i].equals(teclado_update.getMarca())){
                selectMarcas.setSelection(i);
            }
        }

        //Seleccion para idioma
        for (int i=0; i<idiomas.length; i++){
            if(idiomas[i].equals(teclado_update.getIdioma())){
                selectIdioma.setSelection(i);
            }
        }

        EditText activo_tecl = findViewById(R.id.editText_activo_teclado);
        activo_tecl.setText(teclado_update.getActivo());
        EditText anio_tecl = findViewById(R.id.editText_anho_actualizar_teclado);
        anio_tecl.setText(teclado_update.getAnio());
        EditText modelo_tecl = findViewById(R.id.editText_modelo_actualizar_teclado);
        modelo_tecl.setText(teclado_update.getModelo());
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
            case R.id.check_actualizar_teclado:

                EditText text_activo_teclado = findViewById(R.id.editText_activo_teclado);
                String textoStringActivo = text_activo_teclado.getText().toString();

                Spinner select_activoPC =findViewById(R.id.spinner_activo_actualizar_teclado);
                String activoPC=select_activoPC.getSelectedItem().toString();
                if (activoPC.equals("PC Activo:")){
                    activoPC="";
                }

                //obteniendo de la lista marcas
                Spinner selectMarcas =findViewById(R.id.spinner_marca_actualizar_teclado);
                String marca=selectMarcas.getSelectedItem().toString();
                if (marca.equals("Marca:")){
                    marca="";
                }


                //obteniendo de la lista idioma
                Spinner selectIdioma =findViewById(R.id.spinner_idioma_actualizar_teclado);
                String idioma=selectIdioma.getSelectedItem().toString();
                if (idioma.equals("Idioma:")){
                    idioma="";
                }

                //obteniendo texto ingresado año
                EditText editTextAnio = findViewById(R.id.editText_anho_actualizar_teclado);
                String anio = editTextAnio.getText().toString();


                //obteniendo texto ingresado modelo
                EditText editTextModelo = findViewById(R.id.editText_modelo_actualizar_teclado);
                String modelo = editTextModelo.getText().toString();

                //se actualiza en el objeto de la lista dinamica

                Teclado tecl=ListaTeclados.getListTeclados().get(position);
                tecl.setAnio(anio);
                tecl.setActivo(textoStringActivo);
                tecl.setActivo(activoPC);
                tecl.setIdioma(idioma);
                tecl.setMarca(marca);
                tecl.setModelo(modelo);

                Intent intent = new Intent(this,TecladoActivity.class);
                startActivity(intent);
                break;
            case R.id.delete_teclado:
                ListaTeclados.eliminarTeclado(ListaTeclados.getListTeclados().get(position));
                Intent intent2 = new Intent(this,TecladoActivity.class);
                startActivity(intent2);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
