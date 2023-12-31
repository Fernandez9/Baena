package Modelo;

public class Cliente {

    private String nombre;
    private String correo;
    private String contra;
    private String cel;
    
    private ListaProducto carrito;

    private Cliente sig;
    private Cliente ant;

    public Cliente(String nombre, String correo, String contra, String cel) {

        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.cel = cel;

        this.sig = null;
        this.ant = null;
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

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public Cliente getSig() {
        return sig;
    }

    public void setSig(Cliente sig) {
        this.sig = sig;
    }

    public Cliente getAnt() {
        return ant;
    }

    public void setAnt(Cliente ant) {
        this.ant = ant;
    }
    
    

}
