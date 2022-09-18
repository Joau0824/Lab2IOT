package pe.edu.pucp.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MonitorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
    }
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu){
        getMenuInflater().inflate(R.menu.menumonitor,menu);
        return true;
    }




    public void btnMenu_monitor(MenuItem menuItem){
        Log.d("msg","tres puntos v");
        View view = findViewById(R.id.popmon);
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.getMenuInflater().inflate(R.menu.popupmon,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(menuItem1 -> {
            switch (menuItem.getItemId()){
                case R.id.pop_buscar_mon:
                    Log.d("msg","Buscar");
                    return true;
                case R.id.pop_todo_mon:
                    Log.d("msg","Todo");
                    return true;
                default:
                    return false;

            }

        });
        popupMenu.show();

    }
}
