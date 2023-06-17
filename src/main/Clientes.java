package main;

public class Clientes {

    String nombre;
    String correo;
    String contra;
    float cel;

    Clientes sig;
    Clientes ant;

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
