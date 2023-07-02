package Controlador;

import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.ListaProducto;
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
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CarritoController implements Initializable {

    @FXML
    private Button btnhome;

    @FXML
    private Button btnhistorial;

    @FXML
    private Button btnconfirmarCompra;

    Cliente clienteActual;
    ListasClientes lc = new ListasClientes();
    Administrador admin = new Administrador();
    ListaProducto productos = new ListaProducto();

    @FXML
    void historial(ActionEvent event) {

    }

    @FXML
    void home(ActionEvent event) {

        try {
            Node source = (Node) event.getSource();
            Stage stageOld = (Stage) source.getScene().getWindow();
            stageOld.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductosCliente.fxml"));
            Parent root;
            root = loader.load();

            ProductosClienteController controlador = loader.getController();
            controlador.lc = this.lc;
            controlador.admin = this.admin;
            controlador.clienteActual = clienteActual;
            controlador.productos = this.productos;

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(CarritoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void confirmarCompra(ActionEvent event) {

        try {
            Node source = (Node) event.getSource();
            Stage stageOld = (Stage) source.getScene().getWindow();
            stageOld.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MetodoPago.fxml"));
            Parent root;
            root = loader.load();

            MetodoPagoController controlador = loader.getController();
            controlador.lc = this.lc;
            controlador.admin = this.admin;
            controlador.clienteActual = clienteActual;

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(CarritoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
