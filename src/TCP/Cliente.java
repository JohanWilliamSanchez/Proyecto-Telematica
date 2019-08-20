/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

/**
 *
 * @author Johan
 */
public class Cliente {

    public static void main(String[] args) {

        final String host = "127.0.0.1";
        final int puerto = 5000;
        DataInputStream in;
        DataOutputStream out;

        try {
            Socket sc = new Socket(host, puerto);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("Hola mundo desde el Cliente");

            String mensaje = in.readUTF();

            System.out.println("nebsahe " + mensaje);

            sc.close();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
