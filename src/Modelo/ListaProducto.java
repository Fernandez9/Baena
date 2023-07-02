package Modelo;

import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class ListaProducto {

    private Producto tope;

    public ListaProducto() {
        tope = null;
    }

    public Producto getTope() {
        return tope;
    }

    public void setTope(Producto tope) {
        this.tope = tope;
    }

    public int getlog() {
        int cont = 0;
        if (tope == null) {
            return 0;
        } else {
            Producto p = tope;
            while (p != null) {
                cont++;
                p = p.getSig();
            }
            return cont;
        }
    }

    public Producto buscarNombre(String nombre) {
        if (tope == null) {
            return null;
        } else {
            Producto p = tope;
            do {
                if (p.getNombre().equals(nombre)) {
                    return p;
                }
                p = p.getSig();
            } while (p != null);
            return null;
        }
    }

    public Producto CrearNodo(String name, int stock, String marc, String info, float precio, String imgURL) {

        try {
            Producto p = buscarNombre(name);

            if (p != null) {

                JOptionPane.showMessageDialog(null, "Nombre del producto"
                        + " ya se encuentran registrados.");

            } else {
                Producto q = new Producto(name, stock, marc, info, precio, imgURL);
                return q;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
        }
        return null;
    }

    public void setPush(String name, int stock, String marc, String info, float precio, String imgURL) {

        Producto q = CrearNodo(name, stock, marc, info, precio, imgURL);

        if (q != null) {

            if (tope == null) {
                tope = q;
            } else {
                q.setSig(tope);
                tope.setAnt(q);
                tope = q;
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Producto");
            alert.setContentText("Nuevo producto agregado");
            alert.showAndWait();
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Producto");
            alert.setContentText("Nombre de producto ya registrado");
            alert.showAndWait();

        }
    }

    public void setActualizar(String name, int stock, String marc, String info, float precio, String imgURL) {

        if (buscarNombre(name) == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Producto");
            alert.setContentText("Producto no registrado, no se puede actualizar");
            alert.showAndWait();
        } else {

            Producto p = tope;

            while (p != null) {

                if (p.getNombre().equals(name)) {
                    p.setNombre(name);
                    p.setMarca(marc);
                    p.setPrecio(precio);
                    p.setInfo(info);
                    p.setCant(stock);
                    p.setImgURL(imgURL);
                    break;
                } else {
                    p = p.getSig();
                }

            }

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Producto");
            alert.setContentText("Producto actualizado");
            alert.showAndWait();

        }

    }

    public void eliminar() {

        int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al producto " + tope.getNombre() + "?", "Eliminar", JOptionPane.OK_CANCEL_OPTION);

        if (op == JOptionPane.OK_OPTION) {

            Producto p = tope.getSig();
            tope.getSig().setAnt(p);

            tope.setSig(null);
            tope = null;

            tope = p;

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Elimidado");
            alert.setContentText("Producto inicial (cabecera) eliminado");
            alert.showAndWait();

        }

    }

}
