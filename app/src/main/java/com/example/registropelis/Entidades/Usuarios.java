package com.example.registropelis.Entidades;

public class Usuarios {

    private Integer ID;

    private String Correo;
    private String Contrasena;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }
}
