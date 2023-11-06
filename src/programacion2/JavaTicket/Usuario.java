
package programacion2.JavaTicket;

public class Usuario {
    
    private String username;
    private String password;
    
    public enum TipoUsuario{
        ADMINISTRADOR, CONTENIDOS, LIMITADO
    }
    
    private TipoUsuario tipoUsuario;
    
    public Usuario(String username, String password, TipoUsuario tipoUsuario){
        this.username=username;
        this.password=password;
        this.tipoUsuario = tipoUsuario;
    }
    
    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario(){
        return tipoUsuario;
    }
    
}
