package co.cru.cruproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    private EditText Correo, Contraseña;
    private TextView Recuperar;
    private Button Ingresar;
    private String nombredb = "AppDiscipulado";
    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Correo = (EditText) findViewById(R.id.txtCorreo);
        Contraseña = (EditText) findViewById(R.id.txtContraseña);
        Recuperar = (TextView) findViewById(R.id.txtRecuperar);
        Ingresar = (Button) findViewById(R.id.btnLogin);

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
        /*db.child(nombredb).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String correo,contra;
                correo= Correo.getText().toString();
                contra= Contraseña.getText().toString();
                if (validarDatos()){
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Usuario u = snapshot.getValue(Usuario.class);
                        if(u.getCorreo().equals(correo) && String.valueOf(u.getCed()).equals(contra)){
                            BaseDatos.setId(u.getCorreo());
                            startActivity(new Intent(Login.this, Menu.class));
                            finish();
                            return;
                        }
                    }
                }
                Toast.makeText(getApplicationContext(),R.string.usuario_incorrecto,Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });*/


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
