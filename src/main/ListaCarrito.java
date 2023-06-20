package main;

import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class ListaCarrito {

   public CarriCompra tope;

    public ListaCarrito() {
        tope = null;
    }

   public CarriCompra buscarMarca(String marca) {
        if (tope == null) {
            return null;
        } else {
            CarriCompra p = tope;
            do {
                if (p.marca.equals(marca)) {
                    return p;
                }
                p = p.sig;
            } while (p != tope);
            return null;
        }
    }

  public  CarriCompra buscarNombre(String nombr) {
        if (tope == null) {
            return null;
        } else {
            CarriCompra p = tope;
            do {
                if (p.nombre.equals(nombr)) {
                    return p;
                }
                p = p.sig;
            } while (p != tope);
            return null;
        }
    }

    public CarriCompra CrearNodo(String name, int stock, String marc, String cost, float precio) {

        try {
            CarriCompra d = buscarMarca(marc);
            CarriCompra p = buscarNombre(name);

            if (p != null || d != null) {

                if (p != null && d != null) {

                    p.cant = p.cant + stock;

                    return p;

                } else {
                    CarriCompra q = new CarriCompra(name, stock, marc, cost, precio);
                    return q;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }
        return null;
    }

  public  void registrar(String name, int stock, String marc, String cost, float precio) {
        CarriCompra q = CrearNodo(name, stock, marc, cost, precio);
        if (q != null) {
            if (tope == null) {
                tope = q;
                tope.sig = tope;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exitosamente");
                alert.setContentText("Enviado al carrito correctamente");
                alert.showAndWait();
            } else {
                CarriCompra p = tope;
                do {
                    p = p.sig;
                } while (p.sig != tope);
                q.sig = tope;
                p.sig = q;
                tope = q;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exitosamente");
                alert.setContentText("Enviado al carrito correctamente");
                alert.showAndWait();
            }
        }
    }
    
   public void comprar(){
       
       
       
       
   }
    
    

}
