package pe.edu.pucp.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class TecladoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclado);

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
                    return true;
                case R.id.pop_todo_tecla:
                    Log.d("msg","Todo");
                    return true;
                default:
                    return false;

            }

        });
        popupMenu.show();

    }




}
