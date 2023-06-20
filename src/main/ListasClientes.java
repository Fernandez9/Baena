
package main;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ListasClientes {

    Clientes cab;

    public ListasClientes() {
        cab = null;
    }

    //dentro del boton login, validamos, si es true, cambia de ventana 
    //y oculta la de login, si es false, se mantiene la ventana
    public Clientes login(String corre, String contras) {

        Clientes aux=buscarCorreo(corre);
        
        if (aux == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se encuentra registrado");
            alert.showAndWait();

            return null;
        } else{
            JOptionPane.showMessageDialog(null, "si hay clientes");
       
                if (( aux.contra).equals(contras)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Bienvenido");
                alert.setContentText("Bienvenido");
                alert.showAndWait();
                return aux;

            } else  {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Contraseña incorrecta");
                alert.showAndWait();
                return null;

            }
                
        }
         

    }
    
    public Clientes buscarCorreo(String emai) {

        if (cab == null) {
            return null;
        } else {

            Clientes p = cab;

            while (p != null) {

                if (p.correo.equals(emai)) {
                    return p;
                } else {
                    p = p.sig;
                }

            }
            return null;
        }

        
    }

    public Clientes CrearNodo( String name, String email,String password, float cellph) {

        Clientes buscar = null;

        try {
            buscar = buscarCorreo(email);

            
            if (buscar != null) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Error: Este ´correo´ "
                        + "ya se encuentra en uso.  Reemplazarlo!");
                alert.showAndWait();

                return null;
            } else {

                Clientes info = new Clientes(name,email, 
                        password,cellph);
                return info;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e);
            return null;
        }

    }
    
    public Clientes getUltimo(){
        if(cab==null)
            return null;
        else{
            Clientes p = cab;
            while (p.sig != null) {
                p = p.sig;
            }
            return p;
        }
    }

    public void registrar(String name, String email,String password, float cellph) {

        Clientes info = CrearNodo(name, email, password, cellph);

        if (info != null) {
            if (cab == null) {
                cab = info;
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exitosamente");
                alert.setContentText("Cuenta creada exitosamente");
                alert.showAndWait();
                
            } else {
               Clientes ultimo=getUltimo();
                ultimo.sig = info;
                info.ant = ultimo;
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exitosamente");
                alert.setContentText("Cuenta creada exitosamente");
                alert.showAndWait();;
            }
        } else {
        }

    }

   public void registraCompra() {

    }
    
   // Clientes crearNodoCompra(){
        
   // }
    
    
}
