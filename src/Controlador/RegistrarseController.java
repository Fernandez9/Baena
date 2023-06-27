package Controlador;

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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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

    ListasClientes lc = new ListasClientes();
    ListaAdmin la = new ListaAdmin();

    @FXML
    private void btnConfimar(ActionEvent event) {

        String opcion = JOptionPane.showInputDialog("¿como Admin o cliente?.");

        String nombre = this.txtNombre.getText();
        String correo = this.txtCorreo.getText();
        String contra = this.txtContra.getText();
        float cel = Integer.parseInt(this.txtCel.getText());
        String confirContra = this.txtConfirContra.getText();

        if (opcion.equals("Cliente")) {

            if (contra.equals(confirContra)) {

                lc.registrar(nombre, correo, contra, cel);

                try {

                    Node source = (Node) event.getSource();
                    Stage stageOld = (Stage) source.getScene().getWindow();
                    stageOld.close();

                    //Se carga el archivo FXML.
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/registroexitoso.fxml"));
                    Parent root = loader.load();

                    RegistroexitosoController controlador = loader.getController();
                    controlador.la = this.la;
                    controlador.lc = this.lc;

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
                alert.setContentText("las Contraseñas no son iguales");
                alert.show();

            }

        } else if (opcion.equals("Admin")) {

            if (contra.equals(confirContra)) {

                la.registrar(nombre, correo, contra, cel);

                try {

                    Node source = (Node) event.getSource();
                    Stage stageOld = (Stage) source.getScene().getWindow();
                    stageOld.close();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/registroexitoso.fxml"));
                    Parent root = loader.load();

                    RegistroexitosoController controlador = loader.getController();

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
                alert.setContentText("las Contraseñas no son iguales");
                alert.show();

            }

        } else {
            JOptionPane.showConfirmDialog(null, "Ingrese una opción correcta");
        }

    }

    @FXML
    private void Volverbtn(ActionEvent event) {

        try {

            Node source = (Node) event.getSource();
            Stage stageOld = (Stage) source.getScene().getWindow();
            stageOld.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
            Parent root = loader.load();

            LoginController controlador = loader.getController();

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
