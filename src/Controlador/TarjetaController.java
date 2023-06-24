package Controlador;

import Controlador.CompraexitoController;
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

public class TarjetaController implements Initializable {

    @FXML
    private TextField txtnombre;

    @FXML
    private TextField txtnumero;
    @FXML
    private TextField txtfecha;
    @FXML
    private TextField txtcvv;

    @FXML
    private Button btvolver;
    @FXML
    private Button btconfirmar;

    @FXML
    private void volver(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MetodoPago.fxml"));
            Parent root = loader.load();

            MetodoPagoController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Stage st = (Stage) this.btvolver.getScene().getWindow();
            st.close();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void confirmar(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("compraexito.fxml"));
            Parent root = loader.load();

            CompraexitoController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            Stage st = (Stage) this.btconfirmar.getScene().getWindow();
            st.close();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
