package co.edu.uniquindio.poo.model;

public class EnvioNacional extends Envio {
    private static final double COSTO_FIJO = 6000.0;
    private static final double PRECIO_POR_KILO = 2000.0;
    private static final double VALOR_DOMICILIO = 3000.0;

    protected final String ciudadDestino;
    protected final boolean necesitaDomicilio;

    public EnvioNacional(String codigo, String destinatario, double peso, String ciudadDestino, boolean necesitaDomicilio) {
        super(codigo, destinatario, peso);
        this.ciudadDestino = ciudadDestino;
        this.necesitaDomicilio = necesitaDomicilio;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public boolean isNecesitaDomicilio() {
        return necesitaDomicilio;
    }

    @Override
    public double calcularCosto() {
        double costoTotal = calcularCostoBase(COSTO_FIJO, PRECIO_POR_KILO);
        if (necesitaDomicilio) {
            costoTotal += VALOR_DOMICILIO;
        }
        return costoTotal;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + "\n" +
                "destinatario=" + destinatario + "\n" +
                "peso=" + peso + "\n" +
                "ciudadDestino=" + ciudadDestino + "\n" +
                "necesitaDomicilio=" + necesitaDomicilio;
    }
}