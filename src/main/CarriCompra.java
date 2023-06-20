package main;

public class CarriCompra {

    String nombre;
    int cant;
    String marca;
    String info;
    float precio;
    CarriCompra sig;

    public CarriCompra(String nombre, int cant, String marca, String info, float precio) {
        this.nombre = nombre;
        this.cant = cant;
        this.marca = marca;
        this.info = info;
        this.precio = precio;
        sig = null;
    }

}
