package com.example.misligas.Modelo;

import com.google.gson.annotations.SerializedName;

public class Estadisticas_Equipo {
    @SerializedName("ID")
    int ID_Estadisticas;
    @SerializedName("Puntos")
    int puntos;
    @SerializedName("Partidos_Jugados")
    int partidosJugados;
    @SerializedName("Partidos_Ganados")
    int partidosGanados;
    @SerializedName("Partidos_Perdidos")
    int partidosPerdidos;
    @SerializedName("Partidos_Empatados")
    int partidosEmpatados;
    @SerializedName("Goles_A_Favor")
    int golesAFavor;
    @SerializedName("Goles_En_Contra")
    int golesEnContra;
    @SerializedName("Diferencia_De_Goles")
    int diferenciaGoles;
    @SerializedName("Tarjetas_Amarillas")
    int tarjetasAmarillas;
    @SerializedName("Tarjetas_Rojas")
    int tarjetasRojas;
    @SerializedName("ID_Equipo")
    int ID_Equipo;

    public Estadisticas_Equipo(int ID_Estadisticas, int puntos, int partidosJugados, int partidosGanados, int partidosPerdidos, int partidosEmpatados, int golesAFavor, int golesEnContra, int diferenciaGoles, int tarjetasAmarillas, int tarjetasRojas, int ID_Equipo) {
        this.ID_Estadisticas = ID_Estadisticas;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.partidosEmpatados = partidosEmpatados;
        this.golesAFavor = golesAFavor;
        this.golesEnContra = golesEnContra;
        this.diferenciaGoles = diferenciaGoles;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
        this.ID_Equipo = ID_Equipo;
    }

    public int getID_Estadisticas() {
        return ID_Estadisticas;
    }

    public void setID_Estadisticas(int ID_Estadisticas) {
        this.ID_Estadisticas = ID_Estadisticas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public int getGolesAFavor() {
        return golesAFavor;
    }

    public void setGolesAFavor(int golesAFavor) {
        this.golesAFavor = golesAFavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public int getDiferenciaGoles() {
        return diferenciaGoles;
    }

    public void setDiferenciaGoles(int diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getID_Equipo() {
        return ID_Equipo;
    }

    public void setID_Equipo(int ID_Equipo) {
        this.ID_Equipo = ID_Equipo;
    }

    @Override
    public String toString() {
        return "Estadisticas_Equipo{" +
                "ID_Estadisticas=" + ID_Estadisticas +
                ", puntos=" + puntos +
                ", partidosJugados=" + partidosJugados +
                ", partidosGanados=" + partidosGanados +
                ", partidosPerdidos=" + partidosPerdidos +
                ", partidosEmpatados=" + partidosEmpatados +
                ", golesAFavor=" + golesAFavor +
                ", golesEnContra=" + golesEnContra +
                ", diferenciaGoles=" + diferenciaGoles +
                ", tarjetasAmarillas=" + tarjetasAmarillas +
                ", tarjetasRojas=" + tarjetasRojas +
                ", ID_Equipo=" + ID_Equipo +
                '}';
    }
}
