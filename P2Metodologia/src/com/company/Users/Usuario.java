package com.company.Users;

import java.io.Serializable;

public class Usuario implements Serializable {

    //Declaracion de variables
    private ManagerUsuario managerUsuario;
    private String nombre;
    private String apellido;
    private String nick;
    private String correo;
    private String contrasena;
    private String rol;
    private boolean conectado;
    private boolean sancion;
    //private HashSet<SubForo>suscripcionForos;
    private static final Usuario INSTANCIAUSUARIO=new Usuario();
    private static final long serialVersionUID = 1L;
    //Constructor,getters and setters

    public Usuario(String nombre, String apellido, String nick, String correo, String contrasena, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol=rol;
        this.conectado=false;
        this.sancion=false;
       // this.suscripcionForos= new HashSet<SubForo>();
    }

    public Usuario() {

    }
/*
    public HashSet<SubForo> getSuscripcionForos() {
        return suscripcionForos;
    }

    public void setSuscripcionForos(HashSet<SubForo> suscripcionForos) {
        this.suscripcionForos = suscripcionForos;
    }*/

    public boolean isSancion() {
        return sancion;
    }

    public void setSancion(boolean sancion) {
        this.sancion = sancion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public static Usuario getInstanciausuario(){
        return INSTANCIAUSUARIO;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                " apellido='" + apellido + '\'' +
                " nick='" + nick + '\'' +
                " correo='" + correo + '\'' +
                " contraseña='" + contrasena + '\'' +
                " rol='" + rol + '\'' +
                " conectado=" + conectado +
                " sancion=" + sancion +
                '}';
    }
}
