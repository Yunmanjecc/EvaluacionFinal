package juan.clemente.primerainterfaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Pantalla principal que derivará al usuario a las distintas pantallas
    Button detectar, conectar, definir, asignar, ubicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detectar = findViewById(R.id.bttnDetectar);
        conectar = findViewById(R.id.bttnConectar);
        definir = findViewById(R.id.bttnDefinir);
        asignar = findViewById(R.id.bttnAsignar);
        ubicacion = findViewById(R.id.bttnMapa);

        detectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), juan.clemente.primerainterfaz.detectar.class
                );
                startActivity(intent);
            }
        });

        conectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), juan.clemente.primerainterfaz.conectar.class
                );
                startActivity(intent);
            }
        });

        definir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), juan.clemente.primerainterfaz.definir.class
                );
                startActivity(intent);
            }
        });

        asignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), juan.clemente.primerainterfaz.asignar.class
                );
                startActivity(intent);
            }
        });

        ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), juan.clemente.primerainterfaz.ubicacion.class
                );
                startActivity(intent);
            }
        });
    }
}