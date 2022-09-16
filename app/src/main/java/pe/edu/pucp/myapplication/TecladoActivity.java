package pe.edu.pucp.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class TecladoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        case R.id.poptecla:
            Log.d("msg","tres puntos v");
            View menuItemVIew = findViewById(R.id.poptecla);
            PopupMenu popupMenu = new PopupMenu(this,menuItemVIew);
            popupMenu.getMenuInflater().inflate(R.menu.poptecla,popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                @Override
                public boolean onMenuItemClick(MenuItem item){
                    switch (item.getItemId()){

                        case R.id.pop1:
                            Log.d("msg","Buscar");
                            return true;

                        case R.id.pop2:
                            Log.d("msg","Todo");
                            return true;
                        default:
                            return false;
                    }

                }

            });
            popupMenu.show();








    }




}
