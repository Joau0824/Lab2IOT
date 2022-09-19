package pe.edu.pucp.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
import pe.edu.pucp.myapplication.entity.ListaTeclados;
import pe.edu.pucp.myapplication.entity.Teclado;
import pe.edu.pucp.myapplication.entity.listaComputadoras;

public class ActualizarComputadoraActivity extends AppCompatActivity {


    EditText activo;
    Spinner marca;
    EditText anho;
    EditText CPU;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computadora_actualizar);

        activo= findViewById(R.id.editText_activo_computadora);
        marca=findViewById(R.id.spinner_marca_actualizar_computadora);
        anho=findViewById(R.id.editText_anho_actualizar_computadora);
        CPU=findViewById(R.id.editText_cpu_actualizar_computadora);
        activo.setEnabled(false);

        Intent intent=getIntent();
        position = Integer.parseInt(intent.getStringExtra("position"));

        Computadora computadora= listaComputadoras.getListaComputadoras().get(position);
        activo.setText(computadora.getActivo());
        marca.setSelection(computadora.getMarca()+1);
        anho.setText(String.valueOf(computadora.getAnho()));
        CPU.setText(computadora.getCPU());

    }


    public void ActualizarComputadora(MenuItem menuItem){
        String Stractivo=activo.getText().toString();
        String Stranho=anho.getText().toString();
        String Strcpu=CPU.getText().toString();
        String Strmarca= marca.getSelectedItem().toString();

        if(Stractivo.isEmpty()  || Stranho.isEmpty() || Strcpu.isEmpty() || Strmarca.equals("Marca:")){
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        } else if(Integer.parseInt(Stranho)>2022 ||Integer.parseInt(Stranho)<200 ){
            anho.setError("Año no valido");
        }
        else {

            Computadora computadoraNueva = new Computadora(Stractivo, (marca.getSelectedItemPosition() - 1), Integer.parseInt(Stranho), Strcpu);
            listaComputadoras.ActualizarComputadora(position, computadoraNueva);
            finish();
        }
    }

    public void borrarComputadora(MenuItem menuItem) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Esta seguro de eliminar?");
        alertDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listaComputadoras.borrarComputadora(listaComputadoras.getListaComputadoras().get(position));
                Toast.makeText(ActualizarComputadoraActivity.this, "Eliminado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actualizar_computadora,menu);
        return true;
    }



}