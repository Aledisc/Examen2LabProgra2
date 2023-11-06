package programacion2.JavaTicket;

import java.util.ArrayList;
import programacion2.JavaTicket.Usuario.TipoUsuario;

public class Gestion {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Evento> eventos;

    public Gestion() {
        usuarios = new ArrayList<>();
        eventos = new ArrayList<>();

        final Usuario admin = new Usuario("admin", "supersecreto", Usuario.TipoUsuario.ADMINISTRADOR);
        usuarios.add(admin);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

            //version normal
    public Usuario encontrarUsuario(String usuarioIngresado) {
        for (Usuario username : usuarios) {
            if (username.getUsername().equals(usuarioIngresado)) {
                return username; // Se encontró un usuario con el nombre de usuario proporcionado
            }
        }
        return null; // No se encontró ningún usuario con el nombre de usuario proporcionado
    }

    /* version recursiva adaptada
    public Usuario encontrarUsuario(String usuarioIngresado, int indice) {
    if (indice < usuarios.size()) {
        Usuario usuario = usuarios.get(indice);
        if (usuario.getUsername().equals(usuarioIngresado)) {
            return usuario; // Se encontró un usuario con el nombre de usuario proporcionado
        } else {
            return encontrarUsuario(usuarioIngresado, indice + 1); // Llamada recursiva con el siguiente índice
        }
    }
    return null; // No se encontró ningún usuario con el nombre de usuario proporcionado
}
*/


    public boolean tienePermiso(Usuario username, TipoUsuario tipoRequerido) {
        return username.getTipoUsuario() == tipoRequerido;
    }

    public boolean verificarPassword(Usuario username, String passwordIngresada) {
        return username.getPassword().equals(passwordIngresada);
    }

    public boolean iniciarSesion(String nombreUsuario, String contraseña) {
        Usuario usuario = encontrarUsuario(nombreUsuario);

        if (usuario != null && verificarPassword(usuario, contraseña)) {
            SesionUsuario.iniciarSesion(usuario); // Establece el usuario en sesión
            return true; // Inicio de sesión exitoso
        } else {
            return false; // Inicio de sesión fallido
        }
    }

    public boolean verificarUsuarioUnico(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(nombreUsuario)) {
                return false; // El nombre de usuario ya existe, no es único
            }
        }
        return true; // El nombre de usuario es único
    }

    public void crearNuevoUsuario(String usernameIngresar, String passwordIngresar) {
        String nombreUsuario = usernameIngresar;

        if (verificarUsuarioUnico(nombreUsuario)) {
            String password = passwordIngresar;
            Usuario.TipoUsuario tipoUsuario = Usuario.TipoUsuario.LIMITADO;

            // Crear un nuevo usuario
            Usuario nuevoUsuario = new Usuario(nombreUsuario, password, tipoUsuario);

            // Agregar el nuevo usuario al ArrayList de usuarios
            usuarios.add(nuevoUsuario);
        }

    }

    public String obtenerRolUsuarioEnSesion() {
        Usuario usuarioEnSesion = SesionUsuario.getUsuarioEnSesion();

        if (usuarioEnSesion != null) {
            Usuario.TipoUsuario tipoUsuario = usuarioEnSesion.getTipoUsuario();
            return tipoUsuario.toString(); // Convertir el enum a una cadena
        } else {
            return null;
        }
    }

}
