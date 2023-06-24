
package Modelo;

import javafx.scene.control.Alert;
import javax.swing.JOptionPane;


public class ListaAdmin {
    
    admin tope;

    public ListaAdmin() {
        tope=null;
    }
    
     
    int getlogPila(){
        int cont=0;
        if(tope==null)
            return 0;
        else{
            admin p=tope;
            do{
                cont++;
                p=p.sig;
            }while(p!=tope);
            return cont;
        }
    }
    
     public admin login(String corre, String contras) {

        admin aux=buscar(corre);
        
        if (aux == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No se encuentra registrado");
            alert.showAndWait();

            return null;
        } else{
            JOptionPane.showMessageDialog(null, "si hay clientes");
       
                if (( aux.contra).equals(contras)) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Bienvenido");
                alert.setContentText("Bienvenido");
                alert.showAndWait();
                return aux;

            } else  {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Contraseña incorrecta");
                alert.showAndWait();
                return null;

            }
                
        }
         

    }
    
    admin buscar(String corre){
        if(tope==null)
            return null;
        else{
            admin p=tope;
            do{
                if(p.correo.equals(corre))
                    return p;
                p=p.sig;
            }while(p!=tope);
            return null;
        }
    }
  public admin CrearNodo( String name,String corre,  String contrase, double celphone){
      
      
        admin p=buscar(corre);
        if(p==null){
           
            admin q=new admin(corre, corre, contrase, celphone);
            return q;
        }else{
            JOptionPane.showMessageDialog(null, 
            "ese correo ya se encuentra en uso");
            return null;
        }
    }
    
  public  void registrar(String name,String corre,  String contrase, double celphone){
        admin q=CrearNodo(name, corre, contrase, celphone);
        if(q!=null){
            if(tope==null){
                tope=q;
                tope.sig=tope;
              
            }else{
                admin p=tope;
                do{
                    p=p.sig;
                }while(p.sig!=tope);
                q.sig=tope;
                p.sig=q;
                tope=q;
            }
        }
    }

    
}
