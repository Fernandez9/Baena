package Modelo;

public class Cliente {

    public String nombre;
    public String correo;
    public String contra;
    public float cel;

    public Cliente sig;
    public Cliente ant;

    public Cliente(String nombre, String correo, String contra, float cel) {

        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.cel = cel;

        sig = null;
        ant = null;
    }

}
