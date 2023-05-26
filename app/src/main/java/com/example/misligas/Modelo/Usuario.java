package com.example.misligas.Modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable{
    @SerializedName("Nombre_Usuario")
    private String usuario;
    @SerializedName("Nombre")
    private String nombre;
    @SerializedName("Apellidos")
    private String apellido;
    @SerializedName("Email")
    private String email;
    @SerializedName("password")
    private String contraseña;
    @SerializedName("Telefono")
    private String telefono;
    @SerializedName("Genero")
    private String genero;
    @SerializedName("Ciudad")
    private String ciudad;
    @SerializedName("Pais")
    private String pais;
    @SerializedName("Fecha_Registro")
    private String fechaNacimiento;
    @SerializedName("ID_LIGA")
    private int idLiga;
    @SerializedName("admin")
    private int admin;


    public Usuario(String usuario, String nombre, String apellido, String email, String contraseña, String telefono, String genero, String ciudad, String pais, String fechaNacimiento, int idLiga, int admin) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.genero = genero;
        this.ciudad = ciudad;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.idLiga = idLiga;
        this.admin = admin;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public int isAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", telefono='" + telefono + '\'' +
                ", genero='" + genero + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", idLiga=" + idLiga +
                ", admin=" + admin +
                '}';
    }

}
