package Modelo;

public class Clientes {

    public String nombre;
    public String correo;
    public String contra;
    public float cel;

    public Clientes sig;
    public Clientes ant;

    public Clientes() {

    }

    public Clientes(String nombre, String correo, String contra, float cel) {

        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.cel = cel;

        sig = null;
        ant = null;
    }


   
    
    
}
