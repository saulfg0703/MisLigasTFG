package com.example.misligas.Modelo;

import com.google.gson.annotations.SerializedName;

public class Partido {
    @SerializedName("ID_Partido")
    int ID_Partido;
    @SerializedName("Fecha_Encuentro")
    String fechaEncuentro;
    @SerializedName("Lugar_Encuentro")
    String lugarEncuentro;
    @SerializedName("Resultado_Encuentro")
    String resultadoEncuentro;
    @SerializedName("Incidencias")
    String incidencias;
    @SerializedName("ID_Liga")
    int ID_Liga;
    @SerializedName("ID_EquipoLocal")
    int ID_EquipoLocal;
    @SerializedName("ID_EquipoVisitante")
    int ID_EquipoVisitante;

    public Partido(int ID_Partido, String fechaEncuentro, String lugarEncuentro, String resultadoEncuentro, String incidencias, int ID_Liga, int ID_EquipoLocal, int ID_EquipoVisitante) {
        this.ID_Partido = ID_Partido;
        this.fechaEncuentro = fechaEncuentro;
        this.lugarEncuentro = lugarEncuentro;
        this.resultadoEncuentro = resultadoEncuentro;
        this.incidencias = incidencias;
        this.ID_Liga = ID_Liga;
        this.ID_EquipoLocal = ID_EquipoLocal;
        this.ID_EquipoVisitante = ID_EquipoVisitante;
    }

    public int getID_Partido() {
        return ID_Partido;
    }

    public void setID_Partido(int ID_Partido) {
        this.ID_Partido = ID_Partido;
    }

    public String getFechaEncuentro() {
        return fechaEncuentro;
    }

    public void setFechaEncuentro(String fechaEncuentro) {
        this.fechaEncuentro = fechaEncuentro;
    }

    public String getLugarEncuentro() {
        return lugarEncuentro;
    }

    public void setLugarEncuentro(String lugarEncuentro) {
        this.lugarEncuentro = lugarEncuentro;
    }

    public String getResultadoEncuentro() {
        return resultadoEncuentro;
    }

    public void setResultadoEncuentro(String resultadoEncuentro) {
        this.resultadoEncuentro = resultadoEncuentro;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public int getID_Liga() {
        return ID_Liga;
    }

    public void setID_Liga(int ID_Liga) {
        this.ID_Liga = ID_Liga;
    }

    public int getID_EquipoLocal() {
        return ID_EquipoLocal;
    }

    public void setID_EquipoLocal(int ID_EquipoLocal) {
        this.ID_EquipoLocal = ID_EquipoLocal;
    }

    public int getID_EquipoVisitante() {
        return ID_EquipoVisitante;
    }

    public void setID_EquipoVisitante(int ID_EquipoVisitante) {
        this.ID_EquipoVisitante = ID_EquipoVisitante;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "ID_Partido=" + ID_Partido +
                ", fechaEncuentro='" + fechaEncuentro + '\'' +
                ", lugarEncuentro='" + lugarEncuentro + '\'' +
                ", resultadoEncuentro='" + resultadoEncuentro + '\'' +
                ", incidencias='" + incidencias + '\'' +
                ", ID_Liga=" + ID_Liga +
                ", ID_EquipoLocal=" + ID_EquipoLocal +
                ", ID_EquipoVisitante=" + ID_EquipoVisitante +
                '}';
    }
}
