import cliente.udp.ClienteUDP;
import ventana.Ventana;

public class MainCliente {
    public static void main(String[] args) {

        System.out.println("INICIO PROGRAMA");

        //Colocar JObjetos
        Ventana ventana_principal = new Ventana("Mensajeria",300,500,3);
        ventana_principal.colocarTexto("Mi mensaje:\n");
        int idMensaje = ventana_principal.colocarCajaTexto(3, 40);
        ventana_principal.colocarBoton("Enviar archivo");
        ventana_principal.colocarBoton("Realizar videollamada");
        int idBtnEnviar = ventana_principal.colocarBoton("Enviar mensaje");
        int idLblMens = ventana_principal.colocarTexto("Mensaje recibido:\n");

        //Establecer acciones
        ventana_principal.asignarAccionEnvio(idBtnEnviar, idMensaje);
        ventana_principal.asignarMostrarTexto(idLblMens);

        //Iniciar cliente UDP
        ClienteUDP clienteUDP =new ClienteUDP("127.0.0.1",50000);

        try {
            clienteUDP.inicia();
        } catch (Exception e) {
            Ventana ventanaError = new Ventana("Error",200,200,3);
            ventanaError.colocarTexto("Error en el programa");
            ventanaError.setVisible(true);
            System.exit(1);
        }

        ventana_principal.setVisible(true);
    }
}