package Controlador;

import Modelo.Administrador;
import Modelo.Cliente;
import Modelo.ListaProducto;
import Modelo.ListasClientes;
import Modelo.Producto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InfoProductoController {

    @FXML
    private TextField txtprecio;

    @FXML
    private TextArea txtinfo;

    @FXML
    private ImageView ivimagen;

    @FXML
    private Button btnagregar;

    @FXML
    private TextField txtnombre;

    @FXML
    private Button btncerrar;

    public Producto producto;
    public Cliente cliente;
    ListasClientes lc = new ListasClientes();
    Administrador admin = new Administrador();
    ListaProducto productos = new ListaProducto();

    public TextField getTxtprecio() {
        return txtprecio;
    }

    public TextArea getTxtinfo() {
        return txtinfo;
    }

    public ImageView getIvimagen() {
        return ivimagen;
    }

    public void setIvimagen(ImageView ivimagen) {
        this.ivimagen = ivimagen;
    }

    public TextField getTxtnombre() {
        return txtnombre;
    }

    @FXML
    void agregar(ActionEvent event) {

    }

}
