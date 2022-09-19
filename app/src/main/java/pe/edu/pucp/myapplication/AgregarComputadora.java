package pe.edu.pucp.myapplication;
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

        onResume();
    }

    EditText activo;
    Spinner marca;
    EditText anho;
    EditText CPU;

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check_computadora,menu);
        return true;
    }

    public void agregarComputadora(MenuItem menuItem){
        activo= findViewById(R.id.activo_computadora);
        marca=findViewById(R.id.marca_computadora);
        anho=findViewById(R.id.anio_computadora);
        CPU=findViewById(R.id.cpu_computadora);

        String Stractivo=activo.getText().toString();
        String Strmarca= marca.getSelectedItem().toString();
        String Stranho=anho.getText().toString();
        String Strcpu=CPU.getText().toString();

        boolean bandera = false;

        if(Stractivo.isEmpty()){
            activo.setError("Ingrese activo");
            bandera=false;
        }else if(Strmarca.equals("Marca:")){
            Toast.makeText(this, "Tiene que llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
        else if(Stranho.isEmpty()){
            anho.setError("Ingrese año");
            bandera=false;
        }else if(Integer.parseInt(Stranho)>2022 ||Integer.parseInt(Stranho)<1960 ){
            anho.setError("Año no valido");
            bandera=false;
        }
        else if(Strcpu.isEmpty()){
            bandera=false;
            CPU.setError("Ingrese CPU");
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }else{
            bandera=true;
        }

        if(bandera){
            Computadora computadora=new Computadora(Stractivo,(marca.getSelectedItemPosition()-1),Integer.parseInt(Stranho),Strcpu);
            listaComputadoras.anadirComputadora(computadora);
            finish();
        }


    }

    protected void onResume() {
        String marcas[] = new String[]{
                "MAC","LG", "SAMSUNG", "ASUS", "DELL","REDMI","ZETA", "HP", "Otro"
        };
        super.onResume();
    }

}