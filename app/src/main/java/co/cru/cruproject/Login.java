package co.cru.cruproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Login extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {
    private EditText Correo, Contraseña;
    private TextView Recuperar;
    private Button Ingresar;
    private RequestQueue rq;
    private JsonRequest jrq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Correo = findViewById(R.id.txtCorreo);
        Contraseña = findViewById(R.id.txtContraseña);
        Recuperar = findViewById(R.id.txtRecuperar);
        Ingresar = findViewById(R.id.btnLogin);

        rq = Volley.newRequestQueue(getApplicationContext());


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

        String correo,contra, url;
        url = "http://5.135.246.237/DBCru/login.php?correo="+Correo.getText().toString()+"&contraseña="+Contraseña.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);

        /*correo = Correo.getText().toString();
        contra = Contraseña.getText().toString();
        if (validarDatos()) {
            if ((correo.equals("carlos.c@cru.org")) && (contra.equals("1234567890"))) {
                startActivity(new Intent(Login.this, NavigationDrawer.class));
            } else {
                Toast.makeText(getApplicationContext(), R.string.usuario_incorrecto, Toast.LENGTH_LONG).show();
            }
        }*/
    }

    public void recuperar_contraseña(View v){
        startActivity(new Intent(Login.this, Contrasena.class));
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(), R.string.usuario_incorrecto, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(), R.string.usuario_correcto, Toast.LENGTH_LONG).show();
    }
}
