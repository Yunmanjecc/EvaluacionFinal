package juan.clemente.primerainterfaz;

//Utilizar proyecto futuro de arduino
//prueba
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class detectar extends AppCompatActivity {
    String myColor;
    private static final int PICK_IMAGE = 100;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    Uri photoUri;
    ImageView vista;
    Button capturar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detectar);

        vista = findViewById(R.id.ivImagen);

        capturar = findViewById(R.id.bttnCapturar);

        // Cargar la imagen
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ivImagen);

        // Crear una instancia de Palette
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@NonNull Palette palette) {
                // Obtener el color dominante
                int dominantColor = palette.getDominantColor(0x000000);

                // Convertir el color a formato hexadecimal
                String hexColor = String.format("#%06X", (0xFFFFFF & dominantColor));

                // Guardar el color en una variable
                myColor = hexColor;
            }
        });

        //LLamada a la cámara
        capturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_IMAGE_CAPTURE){
            try {
                // Obtener un ContentResolver
                ContentResolver resolver = getContentResolver();

                // Usar el ContentResolver para obtener un Bitmap de la imagen
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(resolver, photoUri);

                // Cargar el Bitmap en el ImageView
                vista.setImageBitmap(bitmap);

                // Crear una instancia de Palette
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(@NonNull Palette palette) {
                        // Obtener el color dominante
                        int dominantColor = palette.getDominantColor(0x000000);

                        // Convertir el color a formato hexadecimal
                        String hexColor = String.format("#%06X", (0xFFFFFF & dominantColor));

                        // Guardar el color en una variable
                        myColor = hexColor;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void openCamera(){
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        photoUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        camera.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
        startActivityForResult(camera, REQUEST_IMAGE_CAPTURE);
    }
}