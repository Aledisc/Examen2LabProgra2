package programacion2.JavaTicket;

public class SesionUsuario {

    private static Usuario usuarioEnSesion;

    public static void iniciarSesion(Usuario usuario) {
        usuarioEnSesion = usuario;
    }

    public static void cerrarSesion() {
        usuarioEnSesion = null;
    }

    public static Usuario getUsuarioEnSesion() {
        return usuarioEnSesion;
    }
}
