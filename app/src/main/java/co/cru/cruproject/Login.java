package co.cru.cruproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText Correo, Contraseña;
    private TextView Recuperar;
    private Button Ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Correo = findViewById(R.id.txtCorreo);
        Contraseña = findViewById(R.id.txtContraseña);
        Recuperar = findViewById(R.id.txtRecuperar);
        Ingresar = findViewById(R.id.btnLogin);

    }

    public boolean validarDatos(){
        if (Correo.getText().toString().trim().isEmpty()){
            Correo.requestFocus();
            Correo.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        if (Contraseña.getText().toString().trim().isEmpty()){
            Contraseña.requestFocus();
            Contraseña.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        return true;
    }

    public void Ingreso(View v){

        String correo,contra;
        correo = Correo.getText().toString();
        contra = Contraseña.getText().toString();
        if (validarDatos()) {
            if ((correo.equals("carlos.c@cru.org")) && (contra.equals("1234567890"))) {
                startActivity(new Intent(Login.this, NavigationDrawer.class));
            } else {
                Toast.makeText(getApplicationContext(), R.string.usuario_incorrecto, Toast.LENGTH_LONG).show();
            }
        }
    }

    public void recuperar_contraseña(View v){
        startActivity(new Intent(Login.this, Contrasena.class));
    }

}
