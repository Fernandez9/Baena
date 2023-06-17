
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


public class LoginController implements Initializable {

    
     @FXML
    private TextField txtemail;

    @FXML
    private TextField txtcontra;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btnRegistro;

    @FXML
    private void loginadminbtn(ActionEvent event) {

    }

    @FXML
    private void loginclientebtn(ActionEvent event) {
          ListasClientes ls=new ListasClientes();
          
          ls.login(txtemail.getText(),txtcontra.getText());
    }

    @FXML
    private void registrasebtn(ActionEvent event) {

         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("Registrarse.fxml"));
             Parent root=loader.load();
             
             RegistrarseController controlador=loader.getController();
             
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
