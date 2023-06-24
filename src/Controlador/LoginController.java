package Controlador;

import Modelo.admin;
import Modelo.Clientes;
import Modelo.ListasClientes;
import Modelo.ListaAdmin;
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
    
        ListaAdmin ls = new ListaAdmin();
        
        String email=this.txtemail.getText();
        String contra=this.txtcontra.getText();

        admin l = ls.login(email, contra);

        if (l != null) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Productos.fxml"));
                Parent root = loader.load();

                ProductosController controlador = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
        }
    }

    @FXML
    private void loginclientebtn(ActionEvent event) {
        ListasClientes ls = new ListasClientes();
        
        String email=this.txtemail.getText();
        String contra=this.txtcontra.getText();

        Clientes l = ls.login(email, contra);

        if (l != null) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Productos.fxml"));
                Parent root = loader.load();

                ProductosController controlador = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
        }
    }

    @FXML
    private void registrasebtn(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registrarse.fxml"));
            Parent root = loader.load();

            RegistrarseController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
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
