package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
            out = new DataOutputStream(s.getOutputStream());
        }catch (UnknownHostException u){
            System.out.println("Error de Host: "+ u);
            return;
        }catch (IOException i){
            System.out.println("Error de E/S "+i);
            return;
        }

        String mensaje="";

        //bucle que seguira enviando datos hasta que el usuario escriba over
        while (!mensaje.equals("over")){
            try{
                mensaje = in.readLine();//lee los datos del teclado
                out.writeUTF(mensaje);// envia añ servidor
            }catch (IOException i){
                System.out.println(i);
            }
        }
        //cierre de conexion
        try {
            in.close();
            out.close();
            s.close();
        }catch (IOException i){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        new cliente("127.0.0.1",5000);
    }
}
