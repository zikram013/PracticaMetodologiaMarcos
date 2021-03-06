package com.company.Users;

import com.company.Observer.Observador;

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



    public void crearUsuario(Usuario usuario){
        if(this.getListaDeUsuarios().contains(usuario.getCorreo()) || this.getListaDeUsuarios().contains(usuario.getNick())) {
        }else{

            listaDeUsuarios.add(usuario);
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
            if(usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(password)){
                return usuario;
            }
        }
        return null;
    }

    public boolean usuarioTrasCarga(String correo,String password){
        for(Usuario usuario:listaDeUsuarios){
            if(usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void iniciarSesion(String correo,String password){
        boolean encontrado=false;
        for(Usuario usuario:listaDeUsuarios) {
            if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(password)) {
                if(!usuario.isConectado() && !usuario.isSancion()) {
                    encontrado=true;
                    usuario.setConectado(true);
                    System.out.println("Bienvenido: " + usuario.getNombre() + " " + usuario.getApellido());
                    for (String forosUpdate : foroActualizado) {
                        System.out.println("el foro " + forosUpdate + " tiene nuevas entradas");
                    }
                } else {
                    usuario.setConectado(false);
                    System.out.println("este usuario esta desconectado");
                }
            }
        }
        if(encontrado==false){
            System.out.println("No existe");
            
        }
    }

    public void desconectar(Usuario usuario){
        if(usuario.isConectado()) {
            System.out.println("Adios: "+usuario.getNombre()+" "+usuario.getApellido());
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
            HashSet<Usuario> guardarUsuario = new HashSet<>(listaDeUsuarios);
            oos.writeObject(guardarUsuario);
            oos.close();
            fos.close();
            return true;
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
            return false;
        }
    }

    public static HashSet<Usuario> leerInfoUsuarios(){
        HashSet<Usuario>usu=new HashSet<>();
        try {
            FileInputStream file =new FileInputStream("BaseDeDatosUsuarios.obj");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            usu = (HashSet<Usuario>) inputFile.readObject();

            inputFile.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return usu;
    }

    public Usuario encontradoRolAdministrador() {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getRol().equals("admin")) {
                return usuario;
            }
        }
        return null;
    }
}
