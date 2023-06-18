
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ProductosController implements Initializable {

   
    @FXML
    private Button btnsesion;
    
    @FXML
    private Button btncarrito;
    
    @FXML
    private Button btnbuscar;
    
    @FXML
    private TextField busqueda;
    
    
            
            
    @FXML
    private void carrito(ActionEvent event) {
        
    }        
            
     @FXML
    private void cerrarSesion(ActionEvent event) {
        
         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
             Parent root=loader.load();
             
             LoginController controlador=loader.getController();
             
             Scene scene =new Scene(root);
             Stage stage=new Stage();
             stage.initModality(Modality.APPLICATION_MODAL);
             stage.setScene(scene);
             stage.showAndWait();
             
             
             
         } catch (IOException ex) {
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
     @FXML
    private void buscar(ActionEvent event) {
        
        String bus=this.busqueda.getText();
         
        
        
    }        
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
}
