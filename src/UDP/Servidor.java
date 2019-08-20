/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.logging.Logger;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;

/**
 *
 * @author Johan
 */
public class Servidor {

    public static void main(String[] args) {

        final int puerto = 5000;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Iniciando el Servidor UDP");
            DatagramSocket socketUDP = new DatagramSocket(puerto);

            while (true) {

                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                socketUDP.receive(peticion);
                System.out.println("Recibo la informacino del Cliente");
                String mensaje = new String(peticion.getData());
                System.out.println("mensaje: " + mensaje);

                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "Hola mundo desde el srvidor: ";
                buffer = mensaje.getBytes();

                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                System.out.println("Envio la informacino del Cliente");
                socketUDP.send(respuesta);

            }
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
