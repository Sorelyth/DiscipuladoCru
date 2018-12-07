package co.cru.cruproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleUsuario extends AppCompatActivity {
    private TextView lblnombre, lblcorreo, lbledad, lblcedula, lblpais, lblciudad, lblcargo, lblcomponente, lblfase,
            lblLiNal, lblLiCdad;
    private String nombre, correo, edad, cedula, pais, ciudad, cargo, componente, fase, liNal, liCdad;
    private Intent i;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//REVISAR METODO
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        lblnombre = findViewById(R.id.txtNombre);
        lblcorreo = findViewById(R.id.txtCorreo);
        lbledad = findViewById(R.id.txtEdad);
        lblcedula = findViewById(R.id.txtCedula);
        lblpais = findViewById(R.id.txtPais);
        lblciudad = findViewById(R.id.txtCiudad);
        lblcargo = findViewById(R.id.txtCargo);
        lblcomponente = findViewById(R.id.txtComponente);
        lblfase = findViewById(R.id.txtFase);
        lblLiNal = findViewById(R.id.txtLiderNal);
        lblLiCdad = findViewById(R.id.txtLiCiudad);

        i= getIntent();
        b = i.getBundleExtra("datos");
        nombre = b.getString("nombre");
        correo = b.getString("correo");
        edad = b.getString("edad");
        cedula = b.getString("cedula");
        pais = b.getString("pais");
        ciudad = b.getString("ciudad");
        cargo = b.getString("cargo");
        componente = b.getString("componente");
        fase = b.getString("fase");
        liNal = b.getString("liNal");
        liCdad = b.getString("liCdad");

        lblnombre.setText(nombre);
        lblcorreo.setText(correo);
        lbledad.setText(edad);
        lblcedula.setText(cedula);
        lblpais.setText(pais);
        lblciudad.setText(ciudad);
        lblcargo.setText(cargo);
        lblcomponente.setText(componente);
        lblfase.setText(fase);
        lblLiNal.setText(liNal);
        lblLiCdad.setText(liCdad);
    }

    public void editarSeleccionado(View v){
        String pos, neg;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.editar));
        builder.setMessage(getResources().getString(R.string.pregunta_editar));
        pos = getResources().getString(R.string.editar_si);
        neg = getResources().getString(R.string.editar_no);

        builder.setPositiveButton(pos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Usuario user = new Usuario(correo);
                user.editarUsuario();//CREAR METODO EDITAR EN BASEDATOS
                onBackPressed();
            }
        });
        builder.setNegativeButton(neg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void eliminarSeleccionado(View v){
        String pos, neg;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminar));
        pos = getResources().getString(R.string.eliminar_si);
        neg = getResources().getString(R.string.eliminar_no);

        builder.setPositiveButton(pos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Usuario user = new Usuario(correo);
                user.eliminarUsuario();
                onBackPressed();
            }
        });
        builder.setNegativeButton(neg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onBackPressed(){
        finish();
        startActivity(new Intent(DetalleUsuario.this,NavigationDrawer.class));
    }
}
