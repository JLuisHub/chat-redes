import servidor.udp.ServidorUDP;
import ventana.Ventana;

public class MainServidor {
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

        //Iniciar servidor UDP
        ServidorUDP servidorUDP=new ServidorUDP(50000);

        try {
            servidorUDP.inicia();
        } catch (Exception e) {
            Ventana ventanaError = new Ventana("Error",200,200,3);
            ventanaError.colocarTexto("Error en el programa");
            ventanaError.setVisible(true);
            return;
        }

        ventana_principal.setVisible(true);
    }
}
