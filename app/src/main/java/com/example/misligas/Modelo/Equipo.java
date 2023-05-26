package com.example.misligas.Modelo;

import com.google.gson.annotations.SerializedName;

public class Equipo {
    @SerializedName("ID_Equipo")
    int IDEquipo;
    @SerializedName("Nombre_Equipo")
    String Nombre_Equipo;
    @SerializedName("Entrenador_Equipo")
    String Entrenador_Equipo;
    @SerializedName("Presidente_Equipo")
    String Presidente_Equipo;
    @SerializedName("Ciudad_Equipo")
    String Ciudad_Equipo;
    @SerializedName("ID_Liga")
    int IDLiga;

    public Equipo(int IDEquipo, String nombre_Equipo, String entrenador_Equipo, String presidente_Equipo, String ciudad_Equipo, int IDLiga) {
        this.IDEquipo = IDEquipo;
        Nombre_Equipo = nombre_Equipo;
        Entrenador_Equipo = entrenador_Equipo;
        Presidente_Equipo = presidente_Equipo;
        Ciudad_Equipo = ciudad_Equipo;
        this.IDLiga = IDLiga;
    }

    public int getIDEquipo() {
        return IDEquipo;
    }

    public void setIDEquipo(int IDEquipo) {
        this.IDEquipo = IDEquipo;
    }

    public String getNombre_Equipo() {
        return Nombre_Equipo;
    }

    public void setNombre_Equipo(String nombre_Equipo) {
        Nombre_Equipo = nombre_Equipo;
    }

    public String getEntrenador_Equipo() {
        return Entrenador_Equipo;
    }

    public void setEntrenador_Equipo(String entrenador_Equipo) {
        Entrenador_Equipo = entrenador_Equipo;
    }

    public String getPresidente_Equipo() {
        return Presidente_Equipo;
    }

    public void setPresidente_Equipo(String presidente_Equipo) {
        Presidente_Equipo = presidente_Equipo;
    }

    public String getCiudad_Equipo() {
        return Ciudad_Equipo;
    }

    public void setCiudad_Equipo(String ciudad_Equipo) {
        Ciudad_Equipo = ciudad_Equipo;
    }

    public int getIDLiga() {
        return IDLiga;
    }

    public void setIDLiga(int IDLiga) {
        this.IDLiga = IDLiga;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "IDEquipo=" + IDEquipo +
                ", Nombre_Equipo='" + Nombre_Equipo + '\'' +
                ", Entrenador_Equipo='" + Entrenador_Equipo + '\'' +
                ", Presidente_Equipo='" + Presidente_Equipo + '\'' +
                ", Ciudad_Equipo='" + Ciudad_Equipo + '\'' +
                ", IDLiga=" + IDLiga +
                '}';
    }
}
