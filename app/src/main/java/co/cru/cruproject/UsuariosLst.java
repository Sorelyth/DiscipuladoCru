package co.cru.cruproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class UsuariosLst extends AppCompatActivity implements adpUsuario.OnUsuarioClickListener {
    private RecyclerView lstUsers;
    private ArrayList<Usuario> users;
    private adpUsuario adp;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        users = new ArrayList<>();
        users = BaseDatos.obtener();
        lstUsers = findViewById(R.id.lstUsuarios);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adp = new adpUsuario(users, this);
        lstUsers.setLayoutManager(llm);
        lstUsers.setAdapter(adp);
    }

    public void registrarUsuario(View v){//Agregar a NavigationDrawer o a Button
        startActivity(new Intent(UsuariosLst.this, Registro.class));
    }

    @Override
    public void onUsuarioClick(Usuario user) {
        Intent i = new Intent(UsuariosLst.this, DetalleUsuario.class);
        Bundle b = new Bundle();
        //users = BaseDatos.obtener();

        b.putString("Nombre: ", user.getNombre());
        b.putString("Fase: ", user.getFase());

        i.putExtra("Datos ", b);
        startActivity(i);
    }
}
