package juan.clemente.primerainterfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class nuevoColor extends AppCompatActivity {
    EditText color;
    TextView cabecera;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_color);

        color = findViewById(R.id.txtNuevoColor);
        cabecera = findViewById(R.id.txtView);
        agregar = findViewById(R.id.bttnAgregarColor);

        //Rellenar con función para mandar el color a la base de datos.
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cabecera.setText("¡Color agregado!");
            }
        });

    }
}