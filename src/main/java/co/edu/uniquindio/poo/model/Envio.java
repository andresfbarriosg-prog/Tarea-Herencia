package co.edu.uniquindio.poo.model;

public abstract class Envio {
    protected final String codigo;
    protected String destinatario;
    protected double peso;

    public Envio(String codigo, String destinatario, double peso) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
    }

    public double calcularCostoBase(double costoFijo, double precioPorKilo) {
        return costoFijo + (precioPorKilo * peso);
    }

    public abstract double calcularCosto();

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + "\n" +
                "destinatario=" + destinatario + "\n" +
                "peso=" + peso;
    }
}