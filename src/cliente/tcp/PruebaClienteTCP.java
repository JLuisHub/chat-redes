package cliente.tcp;

public class PruebaClienteTCP{
    public static void main(String args[])throws Exception{
        ClienteTCP clienteTCP =new ClienteTCP("127.0.0.1",60000);
             
        clienteTCP.inicia();
    }
}
