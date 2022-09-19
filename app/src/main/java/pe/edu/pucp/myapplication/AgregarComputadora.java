package pe.edu.pucp.myapplication;

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

    EditText activo;
    Spinner marca;
    EditText anio;
    EditText CPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_computadora);

        //spinner computadoras
        List<String> spinner = new ArrayList<>();
        spinner.add(0,"Computadora Activo");

        for(Computadora computadora: listaComputadoras.getListaComputadoras()){
            spinner.add(computadora.getActivo());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,spinner);
        Spinner spinner1;

    }

    //VINCULAMOS EL MENU CON EL ACTIVITY
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check_computadora,menu);
        return true;
    }

    //Guardar new computer
    public void saveComputer(MenuItem menuItem){
        activo= findViewById(R.id.activo_computadora);
        marca=findViewById(R.id.marca_computadora);
        anio=findViewById(R.id.anio_computadora);
        CPU=findViewById(R.id.cpu_computadora);

        String activoStr=activo.getText().toString();
        String marcaStr= marca.getSelectedItem().toString();
        String anhoStr=anio.getText().toString();
        String cpuStr=CPU.getText().toString();

        boolean saveAble = false;

        if(activoStr.isEmpty()){
            activo.setError("Ingrese activo");
            saveAble=false;
        }else if(anhoStr.isEmpty()){
            anio.setError("Ingrese año");
            saveAble=false;
        }else if(cpuStr.isEmpty()){
            saveAble=false;
            CPU.setError("Ingrese CPU");
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            saveAble=true;
        }

        if(saveAble){
            Computadora computadora=new Computadora(activoStr,marca.getSelectedItemPosition(),Integer.parseInt(anhoStr),cpuStr);
            listaComputadoras.agregarComputadora(computadora);

            Intent intent=new Intent(this,ComputadoraActivity.class);
            startActivity(intent);
        }


    }


}