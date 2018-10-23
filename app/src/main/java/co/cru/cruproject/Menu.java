package co.cru.cruproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Registro(View v) {
        startActivity(new Intent(Menu.this, Registro.class));
    }

    public void Listado(View v){
        startActivity(new Intent(Menu.this, UsuariosLst.class));
    }
}