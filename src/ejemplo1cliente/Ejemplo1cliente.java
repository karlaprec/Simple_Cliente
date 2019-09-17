package ejemplo1cliente;
import java.io.*;
import java.net.*;
public class Ejemplo1cliente {

    static String direccionIP, sms;  /* */ 
    static int nsocket;
    
    public static void main(String[] args){
        try{
            direccionIP= args[0];   /* INGRESAR IP DEL SERVIDOR */
        }
           catch (Exception e){System.out.println("Escriba una ip valida");
           System.exit(0);}
        
        try {
                nsocket= Integer.parseInt(args[1]);  /* INGRESAR SOCKET DEL SERVIDOR */
         } 
            catch (Exception e) {System.out.println("Escriba un socket valido");
            System.exit(1);}  
        
        try{
            sms= args[2];  /* INGRESAR MENSAJE */
        }
            catch (Exception e){System.out.println("Escriba un mensaje valido");
            System.exit(3);}
        
            try (Socket socket = new Socket(direccionIP, nsocket)) {
                PrintWriter escritor= new PrintWriter(socket.getOutputStream(), true); /* SE CREO EL SOCKET Y ENVIA EL MENSAJE */
                if(!sms.isEmpty()){
                    escritor.println(sms);
                }   
            }
            catch(IOException e){System.out.println("Error reintentar"); System.exit(4);}
    }  
}

    
        

