package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class ManagerUsuario implements Observador {

    private HashSet<Usuario> listaDeUsuarios;
   private ArrayList<String>foroActualizado;


    public ManagerUsuario(){
        this.listaDeUsuarios=new HashSet<Usuario>();
        this.foroActualizado=new ArrayList<String>();
    }

    public HashSet<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }


    public void setListaDeUsuarios(HashSet<Usuario> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }



    public boolean crearUsuario(Usuario usuario){
        if(this.getListaDeUsuarios().contains(usuario.getCorreo()) || this.getListaDeUsuarios().contains(usuario.getNick())) {
            return false;
        }else{

            listaDeUsuarios.add(usuario);
            return true;
        }
    }


    public void listarUsuarios() {
        for (Usuario listaDeUsuario : this.listaDeUsuarios) {
            System.out.println("\n" + listaDeUsuario.toString());
        }
    }

    public  boolean encontradoRolProfesor(String correo,String password){
        System.out.println("realizo la busqueda");
        for(Usuario usuario: listaDeUsuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(password)) {
                System.out.println("El nombre del usuario es"+usuario.getNombre()+"El rol del usuario es"+usuario.getRol());
                return true;
            }
        }
        return false;
    }

    public boolean encontradoRolAdmin(Usuario buscarUsuario){
        for(Usuario usuario:listaDeUsuarios){
            if(usuario.equals(buscarUsuario)){
                return true;
            }
        }
        return false;
    }
/*
    public boolean encontradoRolAlumno(String correo,String password){
        System.out.println("Realizando busqueda");
        for(Usuario usuario:listaDeUsuarios){
            if(usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(password)){
                System.out.println("El nombre del usuario es"+usuario.getNombre()+"El rol del usuario es"+usuario.getRol());
                return true;
            }
        }
        return false;
    }*/

    public boolean usuarioRegistrado(String correo,String password){
        System.out.println("Comprobando que existe en el sistema");
        for(Usuario usuario :listaDeUsuarios){
            if(usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(password)){
                System.out.println("El usuario exixte");
                return true;
            }
        }
        return false;
    }

    public Usuario usuarioExisteSistema(String correo,String password){
        for(Usuario usuario:listaDeUsuarios){
            if(usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(password)){
                return usuario;
            }
        }
        return null;
    }

    public void iniciarSesion(Usuario usuario){
        if(!usuario.isConectado()){
            usuario.setConectado(true);
            for(String forosUpdate: foroActualizado){
                System.out.println("el foro "+forosUpdate+" tiene nuevas entradas");
            }
        }else{
            usuario.setConectado(false);
            System.out.println("este usuario esta desconectado");
        }
       // System.out.println(usuario.isConectado());
    }

    public void desconectar(Usuario usuario){
        if(usuario.isConectado()) {
            usuario.setConectado(false);
        }
    }



    @Override
    public void update(String s) {

        foroActualizado.add(s);
    }

}
