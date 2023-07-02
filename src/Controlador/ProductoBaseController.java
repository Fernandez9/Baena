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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jheison morelo
 */
public class ProductoBaseController {

    @FXML
    private ImageView ivimagen;

    @FXML
    private Label lblnombre;

    @FXML
    private Label lblprecio;

    @FXML
    private Button btnver;

    public Producto producto;
    public Cliente cliente;
    ListasClientes lc;
    Administrador admin;
    ListaProducto productos;
    @FXML
    private VBox vboxElementos;

    public void setDatos(String img, String nombre, String precio) {

        Image imagen = new Image(img);
        ivimagen.setImage(imagen);
        lblnombre.setText(nombre);
        lblprecio.setText(precio);

    }

    @FXML
    public void ver(ActionEvent event) {

        if (cliente != null) {

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InfoProducto.fxml"));
                Parent root = loader.load();

                InfoProductoController controlador = loader.getController();

                controlador.setIvimagen(ivimagen);
                controlador.getTxtinfo().setText(producto.getInfo());
                controlador.getTxtnombre().setText(producto.getNombre());
                controlador.getTxtprecio().setText(String.valueOf(producto.getPrecio()));

                controlador.producto = this.producto;
                controlador.cliente = this.cliente;
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

        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Acción");
            alert.setContentText("Acción inhabilitada");
            alert.show();

        }

    }

}
