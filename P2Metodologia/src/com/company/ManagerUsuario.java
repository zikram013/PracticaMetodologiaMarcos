package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class ManagerUsuario implements Observador, Serializable {
    private static final long serialVersionUID = 1L;
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
        if(!listaDeUsuarios.isEmpty()){
            for (Usuario listaDeUsuario : this.listaDeUsuarios) {
                System.out.println("\n" + listaDeUsuario.toString());

            }
        }else{
            System.out.println("No hay usuarios");
        }

    }

    public  boolean encontradoRolProfesor(Usuario buscarUsuario){
        for(Usuario usuario:listaDeUsuarios){
            if(usuario.getRol().equals("profesor")) {
                if(usuario.equals(buscarUsuario))
                    return true;
            }
        }
        return false;
    }

    public boolean encontradoRolAdmin(Usuario buscarUsuario){
        for(Usuario usuario:listaDeUsuarios){
               if(usuario.getRol().equals("admin")) {
                   if(usuario.equals(buscarUsuario))
                    return true;
                }
        }
        return false;
    }

    public boolean encontradoRolAlumno(Usuario buscarUsuario){
        for(Usuario usuario:listaDeUsuarios){
            if(usuario.getRol().equals("alumno")) {
                if(usuario.equals(buscarUsuario))
                    return true;
            }
        }
        return false;
    }

    public boolean usuarioRegistrado(Usuario usuarioExiste){
        System.out.println("Comprobando que existe en el sistema");
        for(Usuario usuario :listaDeUsuarios){
            if(usuario.equals(usuarioExiste)){
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
        if(!usuario.isConectado() && !usuario.isSancion()){
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


    @Override
    public String toString() {
        StringBuilder infoUsuarios= new StringBuilder("Los usuarios registrados son: \n");
        for(Usuario usuario:listaDeUsuarios){
           infoUsuarios.append("\t").append(usuario.toString()).append("\n");
        }
        return infoUsuarios.toString();
    }

    public boolean guardarInfoUsuarios(){
        try{
            FileOutputStream fos=new FileOutputStream("BaseDeDatosUsuarios.obj");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
            return true;
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
            return false;
        }
    }

    public static ManagerUsuario leerInfoUsuarios(){
        ManagerUsuario u = null;
        try {
            FileInputStream file =new FileInputStream("BaseDeDatosUsuarios.obj");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            u = (ManagerUsuario) inputFile.readObject();

            inputFile.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return u;
    }
}
