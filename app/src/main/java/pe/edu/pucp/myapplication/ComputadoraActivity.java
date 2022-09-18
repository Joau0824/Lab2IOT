package pe.edu.pucp.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ComputadoraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computadora);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.menucomputadora,menu);
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
