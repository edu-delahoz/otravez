package com.example.appfinalunisinu;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.TextView;




public class inicio_sesion extends AppCompatActivity {
    private EditText etNombreUsuario;
    private EditText etCodigo;
    private Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_sesion);

        etNombreUsuario = findViewById(R.id.nombre_usuario);
        etCodigo = findViewById(R.id.editTextNumberPassword);
        btnIniciarSesion = findViewById(R.id.boton_iniciosesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUsuario = etNombreUsuario.getText().toString();
                String codigo = etCodigo.getText().toString();

                // Realiza la lógica de inicio de sesión aquí
                // Puedes utilizar los valores de "nombreUsuario" y "codigo" para realizar las validaciones necesarias

                // Ejemplo:
                if (nombreUsuario.equals("") && codigo.equals("")) {
                    Intent intent = new Intent(inicio_sesion.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Credenciales inválidas
                    // Muestra un mensaje de error o realiza alguna acción de manejo de error
                }
            }
        });
    }
}

