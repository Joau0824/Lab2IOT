package pe.edu.pucp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReporteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);

        Intent intent = getIntent();
        ArrayList<String> computadorasTotal = (ArrayList<String>) intent.getSerializableExtra("computadorasTotal");
        Log.d("msg", String.valueOf(computadorasTotal));

        String textoTotalComputadoras = "";
        for(String computadorasTotales : computadorasTotal)
        {
            textoTotalComputadoras += computadorasTotales+"\n";
        }

        TextView textCompTotal = findViewById(R.id.text_number1);
        textCompTotal.setText(textoTotalComputadoras);


    }



}
