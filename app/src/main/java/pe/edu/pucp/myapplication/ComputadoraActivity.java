package pe.edu.pucp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pe.edu.pucp.myapplication.entity.Computadora;
import pe.edu.pucp.myapplication.entity.listaComputadoras;

public class ComputadoraActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computadora);

        //boton plus computadora

        FloatingActionButton button =findViewById(R.id.plus_computadora);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this,AgregarComputadora.class);
            startActivity(intent);
        });

        //listarComputadoras
        if(!listaComputadoras.getListaComputadoras().isEmpty()){
            ((TextView) findViewById(R.id.msgComputadora)).setText("");
            ((TextView) findViewById(R.id.msgComputadora)).setTextSize(0);

            ListView listView = findViewById(R.id.listaComputadoras);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaComputadoras.componentesComputadora());
            listView.setAdapter(adapter);
        }else{
            ((TextView) findViewById(R.id.msgComputadora)).setText("No hay computadoras ingresadas");
        }



    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.menucomputadora,menu);
        this.setTitle(R.string.titulo_compu);
        return true;
    }


    public void btnMenu_computadora(MenuItem menuItem){
        Log.d("msg","tres puntos v");
        View view = findViewById(R.id.popcompu);
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.getMenuInflater().inflate(R.menu.popupmon,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem.getItemId()){
                case R.id.pop_buscar_compu:
                    Log.d("msg","Buscar");
                    return true;
                case R.id.pop_todo_compu:
                    Log.d("msg","Todo");
                    return true;
                default:
                    return false;

            }

        });
        popupMenu.show();

    }



}
