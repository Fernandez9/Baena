package Modelo;

public class Producto {

    private String nombre;
    private int cant;
    private String marca;
    private String info;
    private float precio;
    private String imgURL;

    private Producto sig;
    private Producto ant;

    public Producto(String nombre, int cant, String marca, String info, float precio, String imgURL) {
        this.nombre = nombre;
        this.cant = cant;
        this.marca = marca;
        this.info = info;
        this.precio = precio;
        this.imgURL = imgURL;

        this.ant = null;
        this.sig = null;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Producto getSig() {
        return sig;
    }

    public void setSig(Producto sig) {
        this.sig = sig;
    }

    public Producto getAnt() {
        return ant;
    }

    public void setAnt(Producto ant) {
        this.ant = ant;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}
