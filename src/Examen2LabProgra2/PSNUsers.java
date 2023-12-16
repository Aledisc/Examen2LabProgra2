package Examen2LabProgra2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class PSNUsers {

    RandomAccessFile usuariosPSN;
    HashTable users;

    public PSNUsers() throws FileNotFoundException, IOException {
        usuariosPSN = new RandomAccessFile("usuarios.bin", "rw");
        reloadHashTable();
    }

    //FORMATO: LONG pos, STRING user, INT puntos, INT trofeos, BOOLEAN activo
    private void reloadHashTable() throws IOException {
        users = new HashTable();

        usuariosPSN.seek(0);
        while (usuariosPSN.getFilePointer() < usuariosPSN.length()) {
            long pos = usuariosPSN.getFilePointer();
            String username = usuariosPSN.readUTF();
            usuariosPSN.readInt();
            usuariosPSN.readInt();
            usuariosPSN.readBoolean();
            users.add(username, pos);
            //System.out.println(username+pos);
            
            System.out.println("HashTable recargado");
        }

    }

    //FORMATO: STRING user, INT puntos, INT trofeos, BOOLEAN activo
    public void addUser(String username) throws IOException {
        long pos = 0;
        usuariosPSN.seek(usuariosPSN.length());
        pos = usuariosPSN.getFilePointer();

        if (users.Search(username) == -1) {
            usuariosPSN.writeUTF(username);
            usuariosPSN.writeInt(0);
            usuariosPSN.writeInt(0);
            usuariosPSN.writeBoolean(true);
            users.add(username, pos);
            System.out.println("Usuario creado exitosamente");
            JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al crear un usuario");
            System.out.println("Ha ocurrido un error al crear usuario");
        }
    }

    public void deactivateUser(String username) throws IOException {
        if (users.Search(username) != -1) {
            usuariosPSN.seek(users.Search(username));
            usuariosPSN.readUTF();
            usuariosPSN.readInt();
            usuariosPSN.readInt();
            long prov = usuariosPSN.getFilePointer();
            if (usuariosPSN.readBoolean()) {
                usuariosPSN.seek(prov);
                usuariosPSN.writeBoolean(false);
                users.remove(username);
                System.out.println("Usuario desactivado");
                JOptionPane.showMessageDialog(null, "Usuario desactivado exitosamente");
            } else {
                System.out.println("Esta cuenta ya esta desactivada");
                JOptionPane.showMessageDialog(null, "Esta cuenta ya esta desactivada");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado un usuario");
            System.out.println("No se ha encontrado un usuario");
        }
    }

    public boolean isDeactivated(String username) throws IOException {
        usuariosPSN.seek(users.Search(username));
        usuariosPSN.readUTF();
        usuariosPSN.readInt();
        usuariosPSN.readInt();
        if (usuariosPSN.readBoolean()) {
            return false;
        }
        return true;
    }

    //FORMATO: String username, String juego, String nombreTrofeo
    public void addTrophyTo(String username, String trophyGame, String trophyName, Trophy type) throws FileNotFoundException, IOException {
        RandomAccessFile trofeos = new RandomAccessFile("psn.bin", "rw");

        trofeos.seek(trofeos.length());
        usuariosPSN.seek(users.Search(username));
        usuariosPSN.readUTF();
        long posProv = usuariosPSN.getFilePointer();
        int puntos = usuariosPSN.readInt();
        usuariosPSN.seek(posProv);
        usuariosPSN.writeInt(puntos + type.points);
        posProv = usuariosPSN.getFilePointer();
        int cantTrofeos = usuariosPSN.readInt();
        usuariosPSN.seek(posProv);
        usuariosPSN.writeInt(cantTrofeos + 1);
        trofeos.writeUTF(username);
        trofeos.writeUTF(type.name());
        trofeos.writeUTF(trophyGame);
        trofeos.writeUTF(trophyName);
        trofeos.writeLong(Calendar.getInstance().getTimeInMillis());

        JOptionPane.showMessageDialog(null, "Se ha agregado un trofeo exitosamente");

    }

    public String playerInfo(String username) throws FileNotFoundException, IOException {
        if (users.Search(username) != -1) {
            RandomAccessFile trofeos = new RandomAccessFile("psn.bin", "rw");
            String todo = "";
            String desactivado = "";
            if (isDeactivated(username)) {
                desactivado = " (cuenta desactivada)";
            }

            usuariosPSN.seek(users.Search(username));

            todo += "Username: " + usuariosPSN.readUTF() + desactivado + "\n";
            todo += "Points: " + usuariosPSN.readInt() + "\n";
            todo += "Cantidad de trofeos: " + usuariosPSN.readInt() + "\n\n";
            todo += "Trofeos: \nFECHA\t\t- TIPO\t- JUEGO\t- DESCRIPCION\n";
            trofeos.seek(0);
            while (trofeos.getFilePointer() < trofeos.length()) {
                String user = trofeos.readUTF();
                String type = trofeos.readUTF();
                String game = trofeos.readUTF();
                String desc = trofeos.readUTF();
                long fecha = trofeos.readLong();

                Date date = new Date(fecha);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
                String fechaFormato = sdf.format(date);

                if (user.equals(username)) {
                    todo += fechaFormato + "\t" + type + "\t" + game + "\t" + desc + "\n";
                }
            }
            return todo;
        }
        JOptionPane.showMessageDialog(null, "No se ha encontrado un usuario");
        System.out.println("No se ha encontrado usuario");
        return "";
    }

}
