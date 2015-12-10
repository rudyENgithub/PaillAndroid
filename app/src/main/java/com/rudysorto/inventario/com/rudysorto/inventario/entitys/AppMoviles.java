package com.rudysorto.inventario.com.rudysorto.inventario.entitys;

/**
 * Created by rsorto on 10/12/2015.
 */
public class AppMoviles {

    private int idAppMovil;
    private String nombre;
    private String descripcion;
    private byte[] logo;

    public AppMoviles(Integer idAppMovil, String nombre, String descripcion) {
        this.idAppMovil = idAppMovil;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdAppMovil() {
        return idAppMovil;
    }

    public void setIdAppMovil(int idAppMovil) {
        this.idAppMovil = idAppMovil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
