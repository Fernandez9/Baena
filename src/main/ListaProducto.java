
package main;

import javax.swing.JOptionPane;


public class ListaProducto {
    
    Producto tope;

    public ListaProducto() {
        tope=null;
    }
    /*
     int getlog(){
        int cont=0;
        if(tope==null)
            return 0;
        else{
            Producto p=tope;
            do{
                cont++;
                p=p.sig;
            }while(p!=tope);
            return cont;
        }
    }
    
    Producto getBuscarPeli(int id){
        if(tope==null)
            return null;
        else{
            Producto p=tope;
            do{
                if(id==p.id)
                    return p;
                p=p.sig;
            }while(p!=tope);
            return null;
        }
    }
    
      
    Producto setCrearNodo(){
        int id;
        String nomp;
        id=Integer.parseInt(JOptionPane.showInputDialog(
        "Entre IdPelicula: "));
        Producto p=getBuscarPeli(id);
        if(p==null){
            nomp=JOptionPane.showInputDialog(
            "Entre nombre de pelicula: ");
            Producto q=new Producto(id, nomp);
            return q;
        }else{
            JOptionPane.showMessageDialog(null, 
            "IdPelicula ya se encuentra registrado!");
            return null;
        }
    }
    
    void setPush(){
        Producto q=setCrearNodo();
        if(q!=null){
            if(tope==null){
                tope=q;
                tope.sig=tope;
                JOptionPane.showMessageDialog(null, 
                "Elemento agregado!, Pila estaba vacia...");
            }else{
                Producto p=tope;
                do{
                    p=p.sig;
                }while(p.sig!=tope);
                q.sig=tope;
                p.sig=q;
                tope=q;
                JOptionPane.showMessageDialog(null, "Elemento agregado!");
            }
        }
    }

     void setPoP(){
        if(tope==null)
            JOptionPane.showMessageDialog(null, 
            "La pila no tiene elementos!");
        else{
            Producto p=tope;
            if(tope.sig==tope){
                tope=null;
                JOptionPane.showMessageDialog(null, 
                "Elemento eliminado, Pila vacía!");
            }
            else{    
                do{
                    p=p.sig;
                }while(p.sig!=tope);
                p.sig=tope.sig;
                Producto q=tope;
                tope=tope.sig;
                q.sig=null;
                q=null;
                JOptionPane.showMessageDialog(null, "Desapilado!");
            }
        }
    }

    */
    
}
