package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class cliente {
    //declaramos los sockets y los streams
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    //constructor del cliente que recibe direccion IP y Puerto
    public cliente(String addr, int port){
        try{
            //Creamos el socket que se conecta al seridor
            s = new Socket(addr, port);
            System.out.println("Conectado al servidor");

            //Entrada de datos por terminal
            in = new DataInputStream(System.in);

            //Salidad de datos hacia el servidor
            out = new OutputStream(s.getOutputStream());
        }catch (UnknownHostException u){
            System.out.println("Error de Host: "+ u);
            return;
        }catch (IOException i){
            System.out.println("Error de E/S "+i);
            return;
        }

        String mensaje="";
    }
}
