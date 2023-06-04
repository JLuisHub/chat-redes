import ventana.Panel;
import ventana.Ventana;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Ventana ventana_principal = new Ventana("Mensajeria",300,500,3);
        ventana_principal.colocarTexto("Mi mensaje:\n");
        ventana_principal.colocarCajaTexto(3, 40);
        ventana_principal.colocarBoton("Enviar archivo");
        ventana_principal.colocarBoton("Realizar videollamada");
        ventana_principal.colocarBoton("Enviar mensaje");
        ventana_principal.colocarTexto("Mensaje recibido:\n");

        ventana_principal.setVisible(true);

    }
}