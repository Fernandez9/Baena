
package main;


public class Clientes {
    
    private String nombre;
    private String correo;
    private String contra;
    private int cel;
    
    Clientes sig;
    Clientes ant;

    public Clientes() {
            
    }

    public Clientes( String nombre, String correo, String contra, int cel) {
       
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.cel = cel;
        
        sig=null;
        ant=null;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public int getCel() {
        return cel;
    }

    public void setCel(int cel) {
        this.cel = cel;
    }

 

   
    
    
}
