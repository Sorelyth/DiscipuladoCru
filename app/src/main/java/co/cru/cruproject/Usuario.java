package co.cru.cruproject;

public class Usuario {
    private String nombre, correo, pais, ciudad, cargo, comp, fase, nal, cdad, estado;
    private double edad, ced;

    public Usuario(String nombre, String correo, double edad, double ced, String pais, String ciudad, String cargo, String comp, String fase,
                   String nal, String cdad, String estado) {
        this.nombre = nombre;
        this.correo = correo;
        this.pais = pais;
        this.ciudad = ciudad;
        this.cargo = cargo;
        this.comp = comp;
        this.fase = fase;
        this.edad = edad;
        this.ced = ced;
        this.nal = nal;
        this.cdad = cdad;
        this.estado = estado;
    }

    public Usuario(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public double getCed() {
        return ced;
    }

    public void setCed(double ced) {
        this.ced = ced;
    }

    public String getNal() {
        return nal;
    }

    public void setNal(String nal) {
        this.nal = nal;
    }

    public String getCdad() {
        return cdad;
    }

    public void setCdad(String cdad) {
        this.cdad = cdad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void guardarUsuario(){
        BaseDatos.guardar(this);
    }

    public void eliminarUsuario(){
        BaseDatos.eliminar(this);
    }

    public void editarUsuario(){
        BaseDatos.editar(this);
    }
}
