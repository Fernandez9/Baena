package Modelo;

import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

public class ListasClientes {

    Cliente cab;

    public ListasClientes() {
        cab = null;
    }

    //dentro del boton login, validamos, si es true, cambia de ventana 
    //y oculta la de login, si es false, se mantiene la ventana
    public Cliente login(String corre, String contras) {

        Cliente aux = buscarCorreo(corre);

        if (aux == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se encuentra registrado");
            alert.show();
        } else {

            if ((aux.getContra()).equals(contras)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Bienvenido");
                alert.setContentText("Bienvenido");
                alert.showAndWait();
                alert.close();
                return aux;

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Contraseña incorrecta");
                alert.showAndWait();
                alert.close();

            }

        }

        return null;

    }

    public Cliente buscarCorreo(String emai) {

        if (cab == null) {
            return null;
        } else {

            Cliente p = cab;

            while (p != null) {

                if (p.getCorreo().equals(emai)) {
                    return p;
                } else {
                    p = p.getSig();
                }

            }
            return null;
        }

    }

    public Cliente buscarContrasenia(String contra) {

        if (cab == null) {
            return null;
        } else {

            Cliente p = cab;

            while (p != null) {

                if (p.getContra().equals(contra)) {
                    return p;
                } else {
                    p = p.getSig();
                }

            }
            return null;
        }

    }

    public Cliente CrearNodo(String name, String email, String password, String cellph) {

        Cliente buscar;

        try {
            buscar = buscarCorreo(email);

            if (buscar != null) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Error: Este ´correo´ "
                        + "ya se encuentra en uso.  Reemplazarlo!");
                alert.show();

                return null;
            } else {

                Cliente info = new Cliente(name, email,
                        password, cellph);
                return info;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }

    }

    public Cliente getUltimo() {
        if (cab == null) {
            return null;
        } else {
            Cliente p = cab;
            while (p.getSig() != null) {
                p = p.getSig();
            }
            return p;
        }
    }

    public void registrar(String name, String email, String password, String cellph) {

        Cliente info = CrearNodo(name, email, password, cellph);

        if (info != null) {
            if (cab == null) {
                cab = info;

            } else {
                Cliente ultimo = getUltimo();
                ultimo.setSig(info);
                info.setAnt(ultimo);

            }
        } else {
        }

    }

    public void registraCompra() {

    }

    // Cliente crearNodoCompra(){
    // }
}
