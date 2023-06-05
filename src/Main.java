import ventana.Ventana;

public class Main {
    public static void main(String[] args) {

        System.out.println("INICIO PROGRAMA");

        //Colocar JObjetos
        Ventana ventana_principal = new Ventana("Mensajeria",300,500,3);
        ventana_principal.colocarTexto("Mi mensaje:\n");
        int idMensaje = ventana_principal.colocarCajaTexto(3, 40);
        ventana_principal.colocarBoton("Enviar archivo");
        ventana_principal.colocarBoton("Realizar videollamada");
        int idBtnEnviar = ventana_principal.colocarBoton("Enviar mensaje");
        ventana_principal.colocarTexto("Mensaje recibido:\n");

        //Establecer acciones
        ventana_principal.asignarAccionEnvio(idBtnEnviar, idMensaje);

        ventana_principal.setVisible(true);

    }
}