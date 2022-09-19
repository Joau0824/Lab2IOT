package pe.edu.pucp.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pe.edu.pucp.myapplication.entity.Computadora;
import pe.edu.pucp.myapplication.entity.ListaTeclados;
import pe.edu.pucp.myapplication.entity.Teclado;
import pe.edu.pucp.myapplication.entity.listaComputadoras;

public class ComputadoraActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computadora);

        FloatingActionButton button =findViewById(R.id.plus_computadora);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this,AgregarComputadora.class);
            Log.d("msg","LLEGA HASTA AQUI");
            startActivity(intent);
        });

        onResume();

        ListView listView = findViewById(R.id.listaComputadoras);
        listaComputadoras();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ComputadoraActivity.this, ActualizarComputadoraActivity.class);
                String text = parent.getItemAtPosition(position).toString();
                text = text.substring(text.indexOf(":")+1, text.indexOf("\n"));
                int pos=listaComputadoras.posicionActivo(text.trim());
                intent.putExtra("position",""+pos);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menucomputadora,menu);
        return true;
    }

    public  void listaComputadoras(){
        ListView listView=findViewById(R.id.listaComputadoras);
        ArrayAdapter<String> array= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaComputadoras.ComputadoraVistaPrincipal());
        listView.setAdapter(array);

        if(!listaComputadoras.getListaComputadoras().isEmpty()){
            TextView textView= findViewById(R.id.msgComputadora);
            textView.setText("");
            textView.setTextSize(0);

        }else{
            TextView textView= findViewById(R.id.msgComputadora);
            textView.setText("No hay computadoras ingresadas");
            textView.setTextSize(27);
        }
    }

    public void buscarComputadora(MenuItem menuItem) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Computadora");
        TextView textView= findViewById(R.id.msgComputadora);


        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String computadoraBuscar= input.getText().toString().trim();
                ArrayList<String> result=listaComputadoras.buscarComputadora(computadoraBuscar);
                ListView listView=findViewById(R.id.listaComputadoras);

                if(!result.isEmpty()){

                    textView.setText("Resultados de busqueda");
                    textView.setTextSize(24);


                }else{
                    textView.setText("No se encontraron resultados de busqueda");
                    textView.setTextSize(24);

                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ComputadoraActivity.this, android.R.layout.simple_list_item_1,result);
                listView.setAdapter(arrayAdapter);
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listaComputadoras();
            }
        });


        alertDialog.show();
    }



    public void btnMenu_computadora(MenuItem menuItem){
        View menuItemView= findViewById(R.id.popcompu);
        PopupMenu popupMenu= new PopupMenu(this,menuItemView);
        popupMenu.getMenuInflater().inflate(R.menu.popupcompu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem1) {
                switch (menuItem1.getItemId()){
                    case R.id.pop_buscar_compu:
                        buscarComputadora(menuItem);
                        return true;
                    case R.id.pop_todo_compu:
                        listaComputadoras();
                        Toast.makeText(ComputadoraActivity.this, "Lista de computadoras", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }



    @Override
    protected void onResume() {
        listaComputadoras();
        super.onResume();
    }

}
