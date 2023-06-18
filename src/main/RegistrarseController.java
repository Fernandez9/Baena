
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegistrarseController implements Initializable {

    @FXML
    private TextField txtNombre;
    
    @FXML
    private TextField txtCorreo;
    
    @FXML
    private TextField txtContra;
    
    @FXML
    private TextField txtConfirContra;
    @FXML
    private TextField txtCel;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    
    
     @FXML
    private void btnConfimar (ActionEvent event){
        
        String nombre=this.txtNombre.getText();
        String correo=this.txtCorreo.getText();
        String contra=this.txtContra.getText();
        float cel=Integer.parseInt(this.txtCel.getText());
        String confirContra=this.txtConfirContra.getText();
        
        if(contra.equals(confirContra)){
            ListasClientes ls=new ListasClientes();
        
        ls.registrar(nombre, correo, contra, cel);
        
        
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
    
        else{
              Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("las Contraseñas no son iguales");
                alert.showAndWait();
        }
    
    }
    
    
    @FXML
    private void Volverbtn(ActionEvent event) {

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        
    }    
    
}
