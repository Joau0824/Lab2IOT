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

import pe.edu.pucp.myapplication.entity.ListaTeclados;

public class TecladoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado);
        this.setTitle(R.string.titulo_teclado);

        //Listamos los teclados
        if(!ListaTeclados.getListTeclados().isEmpty()){
            ((TextView) findViewById(R.id.msg_teclado)).setText("");
            ((TextView) findViewById(R.id.msg_teclado)).setTextSize(0);

            ListView listviewtecl = findViewById(R.id.lista_teclado);
            ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaTeclados.descripTeclados());
            listviewtecl.setAdapter(array);
            //refresh
            listviewtecl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(TecladoActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(TecladoActivity.this,ActualizarTecladoActivity.class);
                    intent.putExtra("tecladoActualizar",ListaTeclados.getListTeclados().get(position));
                    intent.putExtra("posicion",Integer.toString(position));
                    startActivity(intent);
                }
            });

        }else{
            ((TextView) findViewById(R.id.msg_teclado)).setText("No hay teclados ingresados");
            ((TextView) findViewById(R.id.msg_teclado)).setTextSize(27);
        }

        //Agregamos una nueva componente
        FloatingActionButton floatingActionButton=findViewById(R.id.plus_teclado);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this,AgregarTecladoActivity.class);
            startActivity(intent);
        });







    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.menuteclado,menu);
        return true;
    }




    public void btnMenu_teclado(MenuItem menuItem){
        Log.d("msg","tres puntos v");
        View view = findViewById(R.id.poptecla);
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.getMenuInflater().inflate(R.menu.poptecla,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem.getItemId()){
                case R.id.pop_buscar_tecla:
                    Log.d("msg","Buscar");
                    //Pasamos a buscar un teclado
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Teclado");

                    final EditText input = new EditText(this);
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                    input.setHint("Activo");
                    alertDialog.setView(input);


                    alertDialog.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String teclado_buscado = input.getText().toString();
                            ArrayList<String> resultado_busqueda = ListaTeclados.searchTeclado(teclado_buscado);
                            ListView list = findViewById(R.id.lista_teclado);
                            ArrayAdapter<String> array = new ArrayAdapter<String>(TecladoActivity.this, android.R.layout.simple_list_item_1,resultado_busqueda);
                            list.setAdapter(array);

                            if(!resultado_busqueda.isEmpty()){
                                ((TextView) findViewById(R.id.msg_teclado)).setText("");
                                ((TextView) findViewById(R.id.msg_teclado)).setTextSize(0);

                                Integer posic=ListaTeclados.obtenerActivo(teclado_buscado);
                                if(posic!=null){
                                    //Actualizado con click
                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            Toast.makeText(TecladoActivity.this, Integer.toString(posic), Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(TecladoActivity.this,ActualizarTecladoActivity.class);
                                            intent.putExtra("tecladoActualizar",ListaTeclados.getListTeclados().get(posic));
                                            intent.putExtra("posicion",Integer.toString(posic));
                                            startActivity(intent);
                                        }
                                    });
                                }




                            }else{
                                ((TextView) findViewById(R.id.msg_teclado)).setText("No existe el equipo con activo: "+teclado_buscado);
                                ((TextView) findViewById(R.id.msg_teclado)).setTextSize(27);
                            }
                        }
                    });
                    alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    alertDialog.show();
                    return true;
                case R.id.pop_todo_tecla:
                    Log.d("msg","Todo");
                    //Mostramos todas las opciones que tenemos disponibles
                    if(!ListaTeclados.getListTeclados().isEmpty()){
                        ((TextView) findViewById(R.id.msg_teclado)).setText("");
                        ((TextView) findViewById(R.id.msg_teclado)).setTextSize(0);

                        ListView listviewtecl = findViewById(R.id.lista_teclado);
                        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ListaTeclados.descripTeclados());
                        listviewtecl.setAdapter(array);

                        //actualizar al hacer click
                        listviewtecl.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Toast.makeText(TecladoActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(TecladoActivity.this,ActualizarTecladoActivity.class);
                                intent.putExtra("tecladoActualizar",ListaTeclados.getListTeclados().get(position));
                                intent.putExtra("posicion",Integer.toString(position));
                                startActivity(intent);
                            }
                        });

                    }else{
                        ((TextView) findViewById(R.id.msg_teclado)).setText("No hay teclados registrados");
                        ((TextView) findViewById(R.id.msg_teclado)).setTextSize(27);
                    }
                    return true;
                default:
                    return false;

            }

        });
        popupMenu.show();

    }




}
