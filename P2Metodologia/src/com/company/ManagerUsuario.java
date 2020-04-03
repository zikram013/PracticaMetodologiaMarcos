package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ManagerUsuario {

    private HashSet<Usuario> listaDeUsuarios;

    public ManagerUsuario(){
        this.listaDeUsuarios=new HashSet<Usuario>();
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
            System.out.println("entro");
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

    public void mostrarLasSucripciones(String correo,String password){
        for (Usuario usuario:listaDeUsuarios){
            if(usuario.getCorreo().equals(correo)&& usuario.getContraseña().equals(password)){
                for(SubForo suscripcion: usuario.getSuscripcionForos()){
                    System.out.println(suscripcion.getTituloSubForo());
                }

            }
        }
    }

    public boolean inscripcion(SubForo subForo,Usuario usuario){
        if(usuario.getSuscripcionForos().isEmpty()){
            usuario.getSuscripcionForos().add(subForo);
            System.out.println("Usted se ha inscrito en este foro "+subForo.getTituloSubForo());
            return true;
        }else{
            for(SubForo suscripcion:usuario.getSuscripcionForos()){
                if(suscripcion.getTituloSubForo().equals(subForo.getTituloSubForo())){
                    System.out.println("Ya esta añadido");
                    return false;
                }else{
                    System.out.println("Se añade");
                    usuario.getSuscripcionForos().add(subForo);
                    return true;
                }
            }
        }
        return false;
    }
       /* if(usuario.getSuscripcionForos().isEmpty()){
            usuario.getSuscripcionForos().add(subForo);
            System.out.println("Subforo añadido");
            return true;
        }else if(usuario.getSuscripcionForos().equals(subForo.getTituloSubForo())){
            System.out.println("SubForo ya añadido");
            return false;
        }else if(!(usuario.getSuscripcionForos().contains(subForo))){
            usuario.getSuscripcionForos().add(subForo);
            System.out.println("Subforo añadido");
            return true;
        }else{
            return false;
        }
    }*/
}
