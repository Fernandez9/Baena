
package main;


public class Producto {
    
    int id;
    String nombre;
    float precio;
    String info;
    int cant;
    Producto sig;

    public Producto(int id, String nombre, float precio, String info, int cant) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.info = info;
        this.cant = cant;
        sig=null;
    }
    
    
    
    
    
    
}
