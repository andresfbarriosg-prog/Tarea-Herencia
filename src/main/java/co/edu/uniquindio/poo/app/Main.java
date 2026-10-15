package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Mensajeria mensajeria = new Mensajeria("chamoExpress", "321910", "323", "carrera 27 calle 19");
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "BIENVENIDO al sistema de gestión de " + mensajeria.getNombre() +
                            "\nPor favor seleccione la opción deseada:" +
                            "\n1. Registrar/Crear envío" +
                            "\n2. Consultar/Buscar envío" +
                            "\n3. Salir"));

            switch (opcion) {
                case 1:
                    crearEnvio(mensajeria);
                    break;
                case 2:
                    consultarEnvio(mensajeria);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        } while (opcion != 3);
    }

    private static void crearEnvio(Mensajeria mensajeria) {
        int tipoEnvio = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Seleccione el tipo de envío:\n1. Nacional\n2. Internacional\n3. Exprés"));

        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código del envío:");
        String destinatario = JOptionPane.showInputDialog(null, "Ingrese el destinatario:");
        double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el peso en kg:"));

        Envio nuevoEnvio = null;

        if (tipoEnvio == 1) {
            String ciudad = JOptionPane.showInputDialog(null, "Ingrese la ciudad de destino:");
            int optDomicilio = JOptionPane.showConfirmDialog(null, "¿Requiere entrega a domicilio?", "Atención", JOptionPane.YES_NO_OPTION);
            boolean necesitaDomicilio = (optDomicilio == JOptionPane.YES_OPTION);
            nuevoEnvio = new EnvioNacional(codigo, destinatario, peso, ciudad, necesitaDomicilio);
        } else if (tipoEnvio == 2) {
            String pais = JOptionPane.showInputDialog(null, "Ingrese el país de destino:");
            int optSeguro = JOptionPane.showConfirmDialog(null, "¿Requiere seguro?", "Atención", JOptionPane.YES_NO_OPTION);
            boolean necesitaSeguro = (optSeguro == JOptionPane.YES_OPTION);
            nuevoEnvio = new EnvioInternacional(codigo, destinatario, peso, pais, necesitaSeguro);
        } else if (tipoEnvio == 3) {
            String ciudad = JOptionPane.showInputDialog(null, "Ingrese la ciudad de destino:");
            int optDomicilio = JOptionPane.showConfirmDialog(null, "¿Requiere entrega a domicilio?", "Atención", JOptionPane.YES_NO_OPTION);
            boolean necesitaDomicilio = (optDomicilio == JOptionPane.YES_OPTION);
            int optUrgente = JOptionPane.showConfirmDialog(null, "¿Es urgente?", "Atención", JOptionPane.YES_NO_OPTION);
            boolean esUrgente = (optUrgente == JOptionPane.YES_OPTION);
            nuevoEnvio = new EnvioExpress(codigo, destinatario, peso, ciudad, necesitaDomicilio, esUrgente);
        }

        if (nuevoEnvio != null) {
            boolean creado = mensajeria.crearEnvio(nuevoEnvio);
            if (creado) {
                JOptionPane.showMessageDialog(null, "Envío registrado exitosamente.\nCosto Total: $" + nuevoEnvio.calcularCosto());
            } else {
                JOptionPane.showMessageDialog(null, "Error: Ya existe un envío registrado con ese código.");
            }
        }
    }

    private static void consultarEnvio(Mensajeria mensajeria) {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código del envío a buscar:");
        Envio envio = mensajeria.consultarEnvio(codigo);

        if (envio != null) {
            JOptionPane.showMessageDialog(null, "Envío encontrado:\n" + envio.toString() + "\nCosto calculado: $" + envio.calcularCosto());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún envío con el código " + codigo);
        }
    }
}