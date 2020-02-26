/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp_carreraatletismo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author irone
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
       
               
                try {
            //Creamos el objeto carrera
            Carrera c = new Carrera("300 metros lisos / Escaneo de web HTTP");
            System.out.println(c.getNom());
            System.out.println("EN SUS MARCAS !!!!");

            // crear els atletes
            Atleta a1 = new Atleta(1, c);
            System.out.println(a1.getName() + " preparado...");
            Atleta a2 = new Atleta(2, c);
            System.out.println(a2.getName() + " preparado...");
            Atleta a3 = new Atleta(3, c);
            System.out.println(a3.getName() + " preparado...");
            Atleta a4 = new Atleta(4, c);
            System.out.println(a4.getName() + " preparado...");
            Atleta a5 = new Atleta(5, c);
            System.out.println(a5.getName() + " preparado...");
            Atleta a6 = new Atleta(6, c);
            System.out.println(a6.getName() + " preparado...");
            Atleta a7 = new Atleta(7, c);
            System.out.println(a7.getName() + " preparado...");
            Atleta a8 = new Atleta(8, c);
            System.out.println(a8.getName() + " preparado...");

            Thread.sleep(20);
            System.out.println("PREPARADOS   !!!!");
            Thread.sleep(1000);
            System.out.println("ESCANEANDO PAGINA...       !!!!");
            Thread.sleep(1000);
            System.out.println("YA           !!!!");

            // comienza la carrera
            a1.start();
            a2.start();
            a3.start();
            a4.start();
            a5.start();
            a6.start();
            a7.start();
            a8.start();
            Thread.sleep(800);

        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Servidor socket seguro SSL
        SSLServerSocketFactory serverFactory
                = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        ServerSocket serverSocket = serverFactory.createServerSocket(444);
        //Cliente socket seguro
        SSLSocketFactory clienteSocket = (SSLSocketFactory) SSLSocketFactory.getDefault();
        Socket client = clienteSocket.createSocket();

        //Creamos el socket con una URL y le decimos el puerto por el que se va a conectar
        Socket sock = new Socket("www.jesusninoc.com", 80); //socket normal
        //Entrada y salida de datos
        InputStream in = sock.getInputStream();
        OutputStream out = sock.getOutputStream();
        //Creamos una variable String
        String sSalida = "\r\n";
        //Mediante el método GET traemos los datos de la URL anterior
        String msg = "GET / HTTP/1.1" + sSalida + "Host: www.jesusninoc.com" + sSalida + sSalida;

        // Envio de respuesta del servidor web HTTP             
        out.write(msg.getBytes());
        

        /*
         * Lectura de todas las lineas de la cabecera del servidor al que nos conectamos
         */
        String line;

        do {
            char c;
            line = "";
            // 
            // Lectura de una linea de cabecera HTTP

            do {
                c = (char) in.read(); // Asignamos byte a byte el encabezado de la web, ya que es código ASCII
                line += c;

            } while (c != '\n');
            Thread.sleep(400);
            System.out.print(line);
        } while (line.trim().length() > 0);
        // Finalizamos cuando la linea leida es de longitud 0, lo que indica el final del encabezado

        //Procesos automatizados mediante Process Builder
        ProcessBuilder pb1 = new ProcessBuilder("NOTEPAD");
        ProcessBuilder pb2 = new ProcessBuilder("EXPLORER");

        try {
            Process process = pb1.start();

            System.out.println("Ejecucion de Notepad");
        } catch (IOException e) {
            System.err.println("Excepcion de E/S");
            System.exit(-1);
        }

        try {
            final Process process = pb2.start();

            System.out.println("Ejecucion de Explorer");
        } catch (IOException e) {
            System.err.println("Excepcion de E/S");
            System.exit(-1);
        }
        
        //Ejecucion cifrado AES
       try {
            CifradoAES cifrado = new CifradoAES();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
