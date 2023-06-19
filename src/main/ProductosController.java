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
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;

    @FXML
    private TextField busqueda;

    @FXML
    private void carrito(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Carrito.fxml"));
            Parent root = loader.load();

            CarritoController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            LoginController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
             Stage st=(Stage) this.btnsesion.getScene().getWindow();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
           
            st.close();
            

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void buscar(ActionEvent event) {

        String bus = this.busqueda.getText();

    }

    @FXML
    private void ver(ActionEvent event) {

        Object evt = event.getSource();

        if (evt.equals(btn1)) {

        } else if (evt.equals(btn2)) {

        } else if (evt.equals(btn3))  {

        } else if (evt.equals(btn4)) {

        } else if (evt.equals(btn5)) {

        } else if (evt.equals(btn6)) {

        } else if (evt.equals(btn7)) {

        } else if (evt.equals(btn8)) {

        } else if (evt.equals(btn9)) {

        } else if (evt.equals(btn10)) {

        } else if (evt.equals(btn11)) {

        } else if (evt.equals(btn12)) {

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
