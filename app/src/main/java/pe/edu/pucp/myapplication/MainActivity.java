package pe.edu.pucp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void irTeclado(View view){
        Intent intent = new Intent(this, TecladoActivity.class);
        startActivity(intent);
    }

    /*public void irMouse(View view){
        Intent intent = new Intent(this, MouseActivity.class);
        startActivity( intent );
    }*/

    public void irMonitor(View view){
        Intent intent = new Intent(this, MonitorActivity.class);
        startActivity(intent);
    }
    public void irComputadora(View view){
        Intent intent = new Intent(this, MonitorActivity.class);
        startActivity(intent);
    }

    public void irReporte(View view){
        Intent intent = new Intent(this, ReporteActivity.class);
        startActivity(intent);
    }
}