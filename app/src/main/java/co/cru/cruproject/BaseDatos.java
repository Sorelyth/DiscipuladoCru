package co.cru.cruproject;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BaseDatos {
    private static String nombredb = "AppDiscipulado";
    private static DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Usuario> users = new ArrayList<>();
    private static String id;

    public static void guardar(Usuario u){
        users.add(u);
        //db.child(nombredb).child(u.getCorreo()).setValue(u);
    }

    public static ArrayList<Usuario> obtener(){
        return users;
    }

    public static String getId(){
        return db.push().getKey();
    }

    public static void setId(String correo) {
        BaseDatos.id = correo;
    }

    public static void setUsers(ArrayList<Usuario> users) {
        BaseDatos.users = users;
    }

    public static void eliminar(Usuario u){
        users.remove(u);
        //db.child(nombredb).child(u.getCorreo()).removeValue();
    }

    public static void editar(Usuario u){ //CREAR METODO

    }

    public static boolean login(String correo, String contra){
        return true;
    }
}
