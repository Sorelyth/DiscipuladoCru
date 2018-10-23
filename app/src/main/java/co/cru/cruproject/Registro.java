package co.cru.cruproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText Nombre, Correo, Edad, Cedula, Pais, Ciudad;
    private Spinner Cargo, Componente, Fase, LiNal, LiCdad, Estado;
    private String[] opcCargo, opcComponente, opcFase, opcNal, opcCdad, opcEstado;
    private Button Guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Nombre = (EditText) findViewById(R.id.txtNombre);
        Correo = (EditText) findViewById(R.id.txtCorreo);
        Edad = (EditText) findViewById(R.id.txtEdad);
        Cedula = (EditText) findViewById(R.id.txtCedula);
        Pais = (EditText) findViewById(R.id.txtPais);
        Ciudad = (EditText) findViewById(R.id.txtCiudad);

        Cargo = (Spinner) findViewById(R.id.spnCargo);
        opcCargo = getResources().getStringArray(R.array.opc_cargo);
        ArrayAdapter<String> adp_cargo = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opcCargo);
        Cargo.setAdapter(adp_cargo);

        Componente = (Spinner) findViewById(R.id.spnComponente);
        opcComponente = getResources().getStringArray(R.array.opc_componente);
        ArrayAdapter<String> adp_componente = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opcComponente);
        Componente.setAdapter(adp_componente);

        Fase = (Spinner) findViewById(R.id.spnFaseDisci);
        opcFase = getResources().getStringArray(R.array.opc_fase);
        ArrayAdapter<String> adp_fase = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opcFase);
        Fase.setAdapter(adp_fase);

        LiNal = (Spinner) findViewById(R.id.spnLiNaL);
        opcNal = getResources().getStringArray(R.array.opc_Nal);
        ArrayAdapter<String> adp_nal = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opcNal);
        LiNal.setAdapter(adp_nal);

        LiCdad = (Spinner) findViewById(R.id.spnLiCdad);
        opcCdad = getResources().getStringArray(R.array.opc_Cdad);
        ArrayAdapter<String> adp_cdad = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opcCdad);
        LiCdad.setAdapter(adp_cdad);

        Estado = (Spinner) findViewById(R.id.spnEstado);
        opcEstado = getResources().getStringArray(R.array.opc_Estado);
        ArrayAdapter<String> adp_estado = new ArrayAdapter(this,android.R.layout.simple_spinner_item,opcEstado);
        Estado.setAdapter(adp_estado);
    }

    public boolean validardatos(){
        if (Nombre.getText().toString().trim().isEmpty()){
            Nombre.requestFocus();
            Nombre.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        if (Correo.getText().toString().trim().isEmpty()){
            Correo.requestFocus();
            Correo.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        if (Edad.getText().toString().trim().isEmpty()){
            Edad.requestFocus();
            Edad.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        if (Double.parseDouble(Edad.getText().toString())<=0){
            Edad.requestFocus();
            Edad.setError(getResources().getString(R.string.error_negativo));
            return false;
        }
        if (Cedula.getText().toString().trim().isEmpty()){
            Cedula.requestFocus();
            Cedula.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        if (Double.parseDouble(Cedula.getText().toString())<=0){
            Cedula.requestFocus();
            Cedula.setError(getResources().getString(R.string.error_negativo));
            return false;
        }
        if (Pais.getText().toString().trim().isEmpty()){
            Pais.requestFocus();
            Pais.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        if (Ciudad.getText().toString().trim().isEmpty()){
            Ciudad.requestFocus();
            Ciudad.setError(getResources().getString(R.string.error_vacio));
            return false;
        }
        return true;
    }

    public void limpiar(){
        Nombre.setText("");
        Correo.setText("");
        Pais.setText("");
        Edad.setText("");
        Cedula.setText("");
        Ciudad.setText("");
        Cargo.setSelection(0);
        Componente.setSelection(0);
        Fase.setSelection(0);
        LiNal.setSelection(0);
        LiCdad.setSelection(0);
        Estado.setSelection(0);
    }

    public void GuardarRegistro(View v){
        String nombre, correo, pais, ciudad, cargo, comp, fase, nal, cdad, est;
        double edad, ced;
        if (validardatos()){
            nombre = Nombre.getText().toString();
            correo = Correo.getText().toString();
            pais = Pais.getText().toString();
            ciudad = Ciudad.getText().toString();
            edad = Double.parseDouble(Edad.getText().toString());
            ced = Double.parseDouble(Cedula.getText().toString());
            cargo = Cargo.getSelectedItem().toString();
            comp = Componente.getSelectedItem().toString();
            fase = Fase.getSelectedItem().toString();
            nal = LiNal.getSelectedItem().toString();
            cdad = LiCdad.getSelectedItem().toString();
            est = Estado.getSelectedItem().toString();

            Usuario user = new Usuario(nombre, correo, edad, ced, pais, ciudad, cargo, comp, fase, nal, cdad, est);
            user.guardarUsuario();
            Toast.makeText(this,getResources().getString(R.string.guardado),Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    public void onBackPressed(){
        finish();
        startActivity(new Intent(Registro.this,Menu.class));
    }
}
