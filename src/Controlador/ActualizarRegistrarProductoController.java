/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Administrador;
import Modelo.ListaProducto;
import Modelo.ListasClientes;
import java.io.File;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author jheison morelo
 */
public class ActualizarRegistrarProductoController {

    @FXML
    private Button btnagregar;

    @FXML
    private Button btnURL;

    @FXML
    private TextField lblstock;

    @FXML
    private TextField lblnombre;

    @FXML
    private TextField lblprecio;

    @FXML
    private TextField lblmarca;

    @FXML
    private TextField lblurlImagen;

    @FXML
    private TextArea lblinformacion;

    @FXML
    private Button btnactualizar;

    @FXML
    private Button btnvolver;

    @FXML
    private GridPane gridProductos;

    ListasClientes lc = new ListasClientes();
    Administrador admin = new Administrador();
    ListaProducto productos = new ListaProducto();

    public ActualizarRegistrarProductoController() {
        this.gridProductos = new GridPane();
    }

    public void refresh() {
        lblnombre.setText("");
        lblstock.setText("");
        lblmarca.setText("");
        lblinformacion.setText("");
        lblprecio.setText("");
    }

    @FXML
    public void agregar(ActionEvent event) {

        String nombre = this.lblnombre.getText();
        String marca = this.lblmarca.getText();
        String stock = this.lblstock.getText();
        String precio = this.lblprecio.getText();
        String info = this.lblinformacion.getText();
        String URL = this.lblurlImagen.getText();

        if (!nombre.equals(" ") && !marca.equals(" ") && !stock.equals(" ") && !precio.equals(" ") && !info.equals(" ") && !URL.equals("")) {

            try {

                productos.setPush(nombre, Integer.parseInt(stock), marca, info, Float.parseFloat(precio), URL);
                refresh();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Hay campos sin llenar.");
            alert.show();
        }

    }

    @FXML
    public void actualizar(ActionEvent event) {

        String nombre = this.lblnombre.getText();
        String marca = this.lblmarca.getText();
        String stock = this.lblstock.getText();
        String precio = this.lblprecio.getText();
        String info = this.lblinformacion.getText();
        String URL = this.lblurlImagen.getText();

        if (!nombre.equals(" ") && !marca.equals(" ") && !stock.equals(" ") && !precio.equals(" ") && !info.equals(" ")) {

            try {

                productos.setActualizar(nombre, Integer.parseInt(stock), marca, info, Float.parseFloat(precio), URL);
                refresh();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Hay campos sin llenar.");
            alert.show();
        }

    }

    @FXML
    public void volver(ActionEvent event) {

        try {

            Node source = (Node) event.getSource();
            Stage Old = (Stage) source.getScene().getWindow();
            Old.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductosAdministrador.fxml"));
            Parent root = loader.load();

            ProductosAdministradorController controlador = loader.getController();
            controlador.lc = this.lc;
            controlador.admin = this.admin;
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
    public void seleccionarImagen(ActionEvent e) {

        String URLimagen = "";
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imagen");

        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Archivos de Imagen", "*.png", "*.jpg", "*.gif");
        fileChooser.getExtensionFilters().add(imageFilter);

        Node source = (Node) e.getSource();
        Stage actualVentana = (Stage) source.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(actualVentana);

        if (selectedFile != null) {
            URLimagen = selectedFile.toURI().toString();
        }

        this.lblurlImagen.setText(URLimagen);

    }

}
