package co.edu.uniquindio.poo.model;

public class EnvioExpress extends EnvioNacional {
    private final boolean esUrgente;
    private static final double RECARGO = 1.30;
    private static final double RECARGO_URGENCIA = 5000.0;

    public EnvioExpress(String codigo, String destinatario, double peso, String ciudadDestino, boolean necesitaDomicilio, boolean esUrgente) {
        super(codigo, destinatario, peso, ciudadDestino, necesitaDomicilio);
        this.esUrgente = esUrgente;
    }

    public boolean isEsUrgente() {
        return esUrgente;
    }

    @Override
    public double calcularCosto() {
        double costo = super.calcularCosto() * RECARGO;
        if (esUrgente) {
            costo += RECARGO_URGENCIA;
        }
        return costo;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + "\n" +
                "destinatario=" + destinatario + "\n" +
                "peso=" + peso + "\n" +
                "ciudadDestino=" + ciudadDestino + "\n" +
                "necesitaDomicilio=" + necesitaDomicilio + "\n" +
                "esUrgente=" + esUrgente;
    }
}