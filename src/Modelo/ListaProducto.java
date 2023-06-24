package Modelo;

import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class ListaProducto {

    Producto tope;
//    Carrito 

    public ListaProducto() {
        tope = null;
    }

    int getlog() {
        int cont = 0;
        if (tope == null) {
            return 0;
        } else {
            Producto p = tope;
            do {
                cont++;
                p = p.sig;
            } while (p != tope);
            return cont;
        }
    }

    Producto buscarMarca(String marca) {
        if (tope == null) {
            return null;
        } else {
            Producto p = tope;
            do {
                if (p.marca.equals(marca)) {
                    return p;
                }
                p = p.sig;
            } while (p != tope);
            return null;
        }
    }

    Producto buscarNombre(String nombr) {
        if (tope == null) {
            return null;
        } else {
            Producto p = tope;
            do {
                if (p.nombre.equals(nombr)) {
                    return p;
                }
                p = p.sig;
            } while (p != tope);
            return null;
        }
    }

    Producto CrearNodo(String name, int stock, String marc, String cost, float precio) {

        try {
            Producto d = buscarMarca(marc);
            Producto p = buscarNombre(name);

            if (p != null || d != null) {

                if (p != null && d != null) {

                    JOptionPane.showMessageDialog(null, "marca y nombre del producto"
                            + " ya se encuentran registrados. Intente cambiar nombre o marca");
                    return null;

                } else {
                    Producto q = new Producto(name, stock, marc, cost, precio);
                    return q;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }
        return null;
    }

    void setPush(String name, int stock, String marc, String cost, float precio) {
        Producto q = CrearNodo(name, stock, marc, cost, precio);
        if (q != null) {
            if (tope == null) {
                tope = q;
                tope.sig = tope;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exitosamente");
                alert.setContentText("Cuenta creada exitosamente");
                alert.showAndWait();
            } else {
                Producto p = tope;
                do {
                    p = p.sig;
                } while (p.sig != tope);
                q.sig = tope;
                p.sig = q;
                tope = q;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exitosamente");
                alert.setContentText("Cuenta creada exitosamente");
                alert.showAndWait();
            }
        }
    }
    
     
    
    public void carrito(String name, int stock, String marc, String cost, float precio){
        
        ListaCarrito ls=new ListaCarrito();
        
        ls.registrar(name, stock, marc, cost, precio);
        
    }
    

}
