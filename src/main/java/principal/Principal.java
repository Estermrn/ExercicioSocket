package principal;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Digite o endereço: ");
    String endereco = sc.next();
    System.out.println("Digite a porta: ");
    int porta = sc.nextInt();
    
    try {
        Socket sock = new Socket(endereco, porta);
        PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
     String linha="";
     out.println("GET / HTTP/1.0\n");
     while ((linha = in.readLine()) != null) {
        System.out.println("echo: " + linha);
     }
     } catch ( IOException e ) {
        System.err.println( "Problemas de IO" );
        
        }
    }
}
