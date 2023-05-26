package com.example.misligas.Modelo;

import com.google.gson.annotations.SerializedName;

public class Jugador {
    @SerializedName("ID_Jugador")
    int ID_Jugador;
    @SerializedName("Posicion_Jugador")
    String posicionJugador;
    @SerializedName("Nombre_Jugador")
    String nombreJugador;
    @SerializedName("Apellido_Jugador")
    String apellidoJugador;
    @SerializedName("Lesionado")
    int lesionado;
    @SerializedName("nombre_usuario")
    String nombreUsuario;
    @SerializedName("ID_Equipo")
    int ID_Equipo;

    public Jugador(int ID_Jugador, String posicionJugador, String nombreJugador, String apellidoJugador, int lesionado, String nombreUsuario, int ID_Equipo) {
        this.ID_Jugador = ID_Jugador;
        this.posicionJugador = posicionJugador;
        this.nombreJugador = nombreJugador;
        this.apellidoJugador = apellidoJugador;
        this.lesionado = lesionado;
        this.nombreUsuario = nombreUsuario;
        this.ID_Equipo = ID_Equipo;
    }

    public int getID_Jugador() {
        return ID_Jugador;
    }

    public void setID_Jugador(int ID_Jugador) {
        this.ID_Jugador = ID_Jugador;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public int getLesionado() {
        return lesionado;
    }

    public void setLesionado(int lesionado) {
        this.lesionado = lesionado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getID_Equipo() {
        return ID_Equipo;
    }

    public void setID_Equipo(int ID_Equipo) {
        this.ID_Equipo = ID_Equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "ID_Jugador=" + ID_Jugador +
                ", posicionJugador='" + posicionJugador + '\'' +
                ", nombreJugador='" + nombreJugador + '\'' +
                ", apellidoJugador='" + apellidoJugador + '\'' +
                ", lesionado=" + lesionado +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", ID_Equipo=" + ID_Equipo +
                '}';
    }
}
