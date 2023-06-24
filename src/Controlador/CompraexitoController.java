
package Controlador;

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
import javafx.stage.Modality;
import javafx.stage.Stage;


public class CompraexitoController implements Initializable {

     @FXML
    private Button btnconfirmar;
    
    
      @FXML
    private void confirmar(ActionEvent event) {
        
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Productos.fxml"));
            Parent root = loader.load();

            ProductosController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            Stage st=(Stage) this.btnconfirmar.getScene().getWindow();
             st.close();

        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
        
    }    
    
}
