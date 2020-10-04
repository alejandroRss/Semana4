package com.farussif.semana3.pojo;

public class Contacto {

    private String nombre;
    private int huesoRaitingBlanco;
    private int huesoYellow;
    private String cantidadRaiting;
    private int foto;

    public Contacto(int foto, String cantidadRaiting, int huesoRaitingBlanco, int
            huesoYellow) {
        this.foto = foto;
        this.cantidadRaiting = cantidadRaiting;
        this.huesoRaitingBlanco = huesoRaitingBlanco;
        this.huesoYellow = huesoYellow;
    }

    public Contacto(int foto, String nombre, String cantidadRaiting, int huesoRaitingBlanco, int
                    huesoYellow) {
        this.foto = foto;
        this.nombre = nombre;
        this.cantidadRaiting = cantidadRaiting;
        this.huesoRaitingBlanco = huesoRaitingBlanco;
        this.huesoYellow = huesoYellow;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHuesoRaitingBlanco() {
        return huesoRaitingBlanco;
    }

    public void setHuesoRaitingBlanco(int huesoRaitingBlanco) {
        this.huesoRaitingBlanco = huesoRaitingBlanco;
    }

    public int getHuesoYellow() {
        return huesoYellow;
    }

    public void setHuesoYellow(int huesoYellow) {
        this.huesoYellow = huesoYellow;
    }

    public String getCantidadRaiting() {
        return cantidadRaiting;
    }

    public void setCantidadRaiting(String cantidadRaiting) {
        this.cantidadRaiting = cantidadRaiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
