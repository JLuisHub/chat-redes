package cliente.udp;

public class PruebaClienteUDP{
    public static void main(String args[]) throws Exception{
        ClienteUDP clienteUDP =new ClienteUDP("192.168.0.1",50000);
        
        clienteUDP.inicia();
    }
}
