package sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    private Socket s = null;
    private ServerSocket ss = null;
    private DataInputStream in = null;

    //constructor que recibe el puerto a escuchar
    public server(int port){
        try {
            //se inicia el servidor en el puerto dato
            ss = new ServerSocket(port);
            System.out.println("Servidor iniciado");
            System.out.println("Esperando al cliente");

            //aceptamos la conexion del cliente
            s = ss.accept();
            System.out.println("Cliente esta conectado");

            //Nos preparamos para recobor los datos del cliente
            in = new DataInputStream(s.getInputStream());
            String mensaje ="";

            //seguimos leyendo hasta que el cliente nos envie un over
            while (!mensaje.equals("over")){
                try {
                    mensaje = in.readUTF(); //recibre losd datos
                    System.out.println(mensaje);
                }catch (IOException i){
                    System.out.println(i);
                }
            }
            System.out.println("Cerrando la conexion");

            //cierre de conexion
            s.close();
            in.close();
        }catch (IOException i){
            System.out.println(i);

        }
    }
    public  static void main(String[] args){
        new server(5000);
    }
}
