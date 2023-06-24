package Modelo;

public class CarriCompra {

   public String nombre;
   public int cant;
   public String marca;
   public String info;
   public float precio;
   public CarriCompra sig;

    public CarriCompra(String nombre, int cant, String marca, String info, float precio) {
        this.nombre = nombre;
        this.cant = cant;
        this.marca = marca;
        this.info = info;
        this.precio = precio;
        sig = null;
    }

}
