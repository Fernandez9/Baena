
package vista;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException  {
       
               Parent root=  FXMLLoader.load(getClass().getResource("Login.fxml"));
                  
            // Cargo el scene
            Scene scene = new Scene(root);
            
            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
            
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
