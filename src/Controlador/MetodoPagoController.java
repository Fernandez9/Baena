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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MetodoPagoController implements Initializable {

    @FXML
    private Button bttarjeta;

    @FXML
    private Button btvolver;

    @FXML
    private TextField txttotalpagar;

    @FXML
    private Button btefectivo;

    Cliente clienteActual;
    ListasClientes lc = new ListasClientes();
    Administrador admin = new Administrador();
    ListaProducto productos = new ListaProducto();

    @FXML
    private void tarjeta(ActionEvent event) {

        try {
            Node source = (Node) event.getSource();
            Stage Old = (Stage) source.getScene().getWindow();
            Old.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Tarjeta.fxml"));
            Parent root = loader.load();

            TarjetaController controlador = loader.getController();
            controlador.admin = this.admin;
            controlador.clienteActual = this.clienteActual;
            controlador.lc = this.lc;
            controlador.productos = this.productos;

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void efectivo(ActionEvent event) {

        try {

            Node source = (Node) event.getSource();
            Stage Old = (Stage) source.getScene().getWindow();
            Old.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/compraexito.fxml"));
            Parent root = loader.load();

            CompraexitoController controlador = loader.getController();
            controlador.admin = this.admin;
            controlador.clienteActual = this.clienteActual;
            controlador.lc = this.lc;
            controlador.productos = this.productos;

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void volver(ActionEvent event) {

        try {

            Node source = (Node) event.getSource();
            Stage Old = (Stage) source.getScene().getWindow();
            Old.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Carrito.fxml"));
            Parent root = loader.load();

            CarritoController controlador = loader.getController();
            controlador.admin = this.admin;
            controlador.clienteActual = this.clienteActual;
            controlador.lc = this.lc;

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
