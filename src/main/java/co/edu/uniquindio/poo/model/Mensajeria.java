package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Mensajeria {
    private final String nombre;
    private final String nit;
    private final String telefono;
    private final String direccion;
    private ArrayList<Envio> listaEnvios;

    public Mensajeria(String nombre, String nit, String telefono, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.listaEnvios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public Optional<Envio> buscarEnvio(String codigo) {
        return listaEnvios.stream().filter(envio -> envio.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }

    public boolean crearEnvio(Envio envio) {
        Optional<Envio> envioEncontrado = buscarEnvio(envio.getCodigo());
        if (envioEncontrado.isEmpty()) {
            listaEnvios.add(envio);
            return true;
        }
        return false;
    }

    public Envio consultarEnvio(String codigo) {
        return buscarEnvio(codigo).orElse(null);
    }

    @Override
    public String toString() {
        return "Mensajeria{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listaEnvios=" + listaEnvios +
                '}';
    }
}