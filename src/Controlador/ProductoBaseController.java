/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    
    public void setDatos(String img, String nombre, String precio) {
        
        Image imagen = new Image(img);
        ivimagen.setImage(imagen);
        lblnombre.setText(nombre);
        lblprecio.setText(precio);
    }
    
}
