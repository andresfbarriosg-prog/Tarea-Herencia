package co.edu.uniquindio.poo.model;

public class EnvioInternacional extends Envio {
    private static final double COSTO_FIJO = 15000.0;
    private static final double PRECIO_POR_KILO = 9000.0;
    private static final double VALOR_SEGURO = 20000.0;

    private final String paisDestino;
    private final boolean necesitaSeguro;

    public EnvioInternacional(String codigo, String destinatario, double peso, String paisDestino, boolean necesitaSeguro) {
        super(codigo, destinatario, peso);
        this.paisDestino = paisDestino;
        this.necesitaSeguro = necesitaSeguro;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public boolean isNecesitaSeguro() {
        return necesitaSeguro;
    }

    @Override
    public double calcularCosto() {
        double costoTotal = calcularCostoBase(COSTO_FIJO, PRECIO_POR_KILO);
        if (necesitaSeguro) {
            costoTotal += VALOR_SEGURO;
        }
        return costoTotal;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + "\n" +
                "destinatario=" + destinatario + "\n" +
                "peso=" + peso + "\n" +
                "paisDestino=" + paisDestino + "\n" +
                "necesitaSeguro=" + necesitaSeguro;
    }
}
