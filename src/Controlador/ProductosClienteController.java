package Controlador;

import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.ListaProducto;
import Modelo.ListasClientes;
import Modelo.Producto;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ProductosClienteController {

    @FXML
    private Button btnsesion;

    @FXML
    private Button btncarrito;

    @FXML
    private Button btnmostrar;

    @FXML
    private Button btnbuscar;

    @FXML
    private TextField busqueda;

    @FXML
    private GridPane gridProductos;

    Cliente clienteActual;
    ListasClientes lc = new ListasClientes();
    Administrador admin = new Administrador();
    ListaProducto productos = new ListaProducto();

    @FXML
    private void carrito(ActionEvent event) {

        try {

            Node source = (Node) event.getSource();
            Stage Old = (Stage) source.getScene().getWindow();
            Old.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Carrito.fxml"));
            Parent root = loader.load();

            CarritoController controlador = loader.getController();
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

    @FXML
    private void cerrarSesion(ActionEvent event) {

        try {

            Node source = (Node) event.getSource();
            Stage Old = (Stage) source.getScene().getWindow();
            Old.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Login.fxml"));
            Parent root = loader.load();

            LoginController controlador = loader.getController();
            controlador.lc = this.lc;
            controlador.Admin = this.admin;

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
    private void buscar(ActionEvent event) throws IOException {

        Producto p = productos.buscarNombre(this.busqueda.getText());
        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Producto");
            alert.setContentText("Producto no registrado");
            alert.showAndWait();
        } else {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/vista/ProductoBase.fxml"));
            VBox anchorPane = fxmlLoader.load();

            ProductoBaseController controlador = fxmlLoader.getController();
            controlador.setDatos(p.getImgURL(), p.getNombre(), String.valueOf(p.getPrecio()));
            controlador.producto = p;
            controlador.cliente = null;
            controlador.lc = this.lc;
            controlador.admin = this.admin;
            controlador.productos = this.productos;

            gridProductos.add(anchorPane, 0, 0);

        }

    }

    public void mostrar() {

        try {

            Producto p = productos.getTope();
            int columna = 0;
            int fila = 0;

            for (int i = 0; i < this.productos.getlog(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/vista/ProductoBase.fxml"));
                VBox anchorPane = fxmlLoader.load();

                ProductoBaseController controlador = fxmlLoader.getController();
                controlador.setDatos(p.getImgURL(), p.getNombre(), String.valueOf(p.getPrecio()));
                controlador.producto = p;
                controlador.cliente = this.clienteActual;
                controlador.lc = this.lc;
                controlador.admin = this.admin;
                controlador.productos = this.productos;
                p = p.getSig();

                if (columna == 3) {
                    columna = 0;
                    fila++;
                }

                gridProductos.add(anchorPane, columna++, fila);

                //set grid width
                gridProductos.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridProductos.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridProductos.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridProductos.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridProductos.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridProductos.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new javafx.geometry.Insets(18));

            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
