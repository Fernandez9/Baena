package Modelo;

public class Administrador {

    private String nombre;
    private String correo;
    private String contra;
    private String cel;

    public Administrador() {
        this.nombre = "AdminDefault";
        this.correo = "AdminDefault@gmail.com";
        this.contra = "2023";
        this.cel = "3145812761";
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
    
    

}
