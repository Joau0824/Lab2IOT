package pe.edu.pucp.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.pucp.myapplication.entity.Computadora;
import pe.edu.pucp.myapplication.entity.listaComputadoras;

public class AgregarComputadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computadora_agregar);
        this.setTitle(R.string.titulo_agregar_computadora);

        //spinner Marcas
        String [] marcas={"Marca:","DELL","LG","SAMSUNG","ASUS","MAC","LENOVO","XIAOMI","REDMI","APPLE","IOS","OTRO"};
        ArrayAdapter<String> adapterMarcas= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,marcas);
        Spinner spinnerMarcas =findViewById(R.id.marca_computadora);
        spinnerMarcas.setAdapter(adapterMarcas);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check_computadora,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){
            case R.id.check_computadora:
                //Activo
                EditText textoComputadora = findViewById(R.id.activo_computadora);
                String textoComputadoraString = textoComputadora.getText().toString();
                //Marca
                Spinner spinnerMarcasComputadora =findViewById(R.id.marca_computadora);
                String marca=spinnerMarcasComputadora.getSelectedItem().toString();
                if (marca.equals("Marca:")){
                    marca="";
                }

                //Año
                EditText TextoAnho = findViewById(R.id.anio_computadora);
                String anho = TextoAnho.getText().toString();

                //CPU
                EditText TextoModelo = findViewById(R.id.cpu_computadora);
                String cpu = TextoModelo.getText().toString();

                //LISTA
                Computadora formComputadora = new Computadora(textoComputadoraString,marca,anho,cpu);
                listaComputadoras.agregarComputadora(formComputadora);


                Intent intent = new Intent(this,ComputadoraActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }



}