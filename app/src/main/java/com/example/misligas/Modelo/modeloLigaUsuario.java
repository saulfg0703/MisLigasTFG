package com.example.misligas.Modelo;

import com.google.gson.annotations.SerializedName;

public class modeloLigaUsuario {

    @SerializedName("Puntos")
    private int Puntos;

    @SerializedName("Nombre_Equipo")
    private String Nombre_Equipo;

    public modeloLigaUsuario(int puntos, String nombre_Equipo) {
        Puntos = puntos;
        Nombre_Equipo = nombre_Equipo;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    public String getNombre_Equipo() {
        return Nombre_Equipo;
    }

    public void setNombre_Equipo(String nombre_Equipo) {
        Nombre_Equipo = nombre_Equipo;
    }
}
