package juan.clemente.primerainterfaz;

//Utilizar proyecto futuro de arduino

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class detectar extends AppCompatActivity {
    // Cargar la imagen
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.my_image);

    // Crear una instancia de Palette
    Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
        @Override
        public void onGenerated(@NonNull Palette palette) {
            // Obtener el color dominante
            int dominantColor = palette.getDominantColor(0x000000);

            // Convertir el color a formato hexadecimal
            String hexColor = String.format("#%06X", (0xFFFFFF & dominantColor));

            // Guardar el color en una variable
            String myColor = hexColor;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detectar);
    }
}