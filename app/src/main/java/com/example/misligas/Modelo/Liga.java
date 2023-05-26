package com.example.misligas.Modelo;

import com.google.gson.annotations.SerializedName;

public class Liga {
    @SerializedName("ID_liga")
    int ID_Liga;
    @SerializedName("Nombre_Liga")
    String Nombre_Liga;
    @SerializedName("Fecha_Inicio")
    String Fecha_Inicio;
    @SerializedName("Fecha_Fin")
    String Fecha_Fin;

    public Liga(int ID_Liga, String nombre_Liga, String fecha_Inicio, String fecha_Fin) {
        this.ID_Liga = ID_Liga;
        Nombre_Liga = nombre_Liga;
        Fecha_Inicio = fecha_Inicio;
        Fecha_Fin = fecha_Fin;
    }

    public int getID_Liga() {
        return ID_Liga;
    }

    public void setID_Liga(int ID_Liga) {
        this.ID_Liga = ID_Liga;
    }

    public String getNombre_Liga() {
        return Nombre_Liga;
    }

    public void setNombre_Liga(String nombre_Liga) {
        Nombre_Liga = nombre_Liga;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String fecha_Inicio) {
        Fecha_Inicio = fecha_Inicio;
    }

    public String getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(String fecha_Fin) {
        Fecha_Fin = fecha_Fin;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "ID_Liga=" + ID_Liga +
                ", Nombre_Liga='" + Nombre_Liga + '\'' +
                ", Fecha_Inicio='" + Fecha_Inicio + '\'' +
                ", Fecha_Fin='" + Fecha_Fin + '\'' +
                '}';
    }
}
