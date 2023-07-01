package Controlador;

import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.ListasClientes;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    ListasClientes lc = new ListasClientes();
    Administrador Admin = new Administrador();

    @FXML
    private void loginadminbtn(ActionEvent event) {

        String email = this.txtemail.getText();
        String contra = this.txtcontra.getText();

        if (Admin.getCorreo().equals(email) && Admin.getContra().equals(contra)) {

            try {

                Node source = (Node) event.getSource();
                Stage Old = (Stage) source.getScene().getWindow();
                Old.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductosAdministrador.fxml"));
                Parent root = loader.load();

                ProductosAdministradorController controlador = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos");
            alert.show();

        }
    }

    @FXML
    private void loginclientebtn(ActionEvent event) {

        String email = this.txtemail.getText();
        String contra = this.txtcontra.getText();

        Cliente l = lc.login(email, contra);

        if (l != null) {

            try {

                Node source = (Node) event.getSource();
                Stage stageOld = (Stage) source.getScene().getWindow();
                stageOld.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductosCliente.fxml"));
                Parent root = loader.load();

                ProductosClienteController controlador = loader.getController();
                controlador.lc = this.lc;
                controlador.admin = this.Admin;
                controlador.clienteActual = l;

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void registrasebtn(ActionEvent event) {

        try {

            Node source = (Node) event.getSource();
            Stage stageOld = (Stage) source.getScene().getWindow();
            stageOld.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registrarse.fxml"));
            Parent root = loader.load();

            RegistrarseController controlador = loader.getController();
            controlador.lc = this.lc;
            controlador.Admin = this.Admin;

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
