package com.example.misligas.Modelo;

public class modeloLigaUsuario {
    private int puntos;
    private String nombreEquipo;

    public modeloLigaUsuario(int puntos, String nombreEquipo) {
        this.puntos = puntos;
        this.nombreEquipo = nombreEquipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}
