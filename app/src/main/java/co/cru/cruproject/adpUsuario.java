package co.cru.cruproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class adpUsuario extends RecyclerView.Adapter<adpUsuario.UsuarioViewHolder>{
    private ArrayList<Usuario> usuarios;
    private OnUsuarioClickListener clickListener;

    public adpUsuario(ArrayList<Usuario> usuarios, OnUsuarioClickListener clickListener) {
        this.usuarios = usuarios;
        this.clickListener = clickListener;
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, fase;
        private View v;

        public UsuarioViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            nombre = v.findViewById(R.id.lblNombre);
            fase = v.findViewById(R.id.lblFase);
        }
    }

    public interface OnUsuarioClickListener {
        void onUsuarioClick(Usuario user);
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,parent,false);
        return new UsuarioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, int position) {
        final Usuario user = usuarios.get(position);
        holder.nombre.setText(user.getNombre());
        holder.fase.setText(user.getFase());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onUsuarioClick(user);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
