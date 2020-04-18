package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class ManagerSubForos implements Observador, Serializable {
    private static final long serialVersionUID = 1L;
    private SubForo subForo=new SubForo();
    private Usuario usuario=new Usuario();
    private HashSet<String> foro;
    private HashSet<SubForo>listadoDeForos;
    private HashSet<EntradaAbstracta> entradaAbstractas;
    private static ArrayList<Usuario>usuarios;
    private ManagerUsuario managerUsuario;

    public ManagerSubForos(ManagerUsuario managerUsuario){
        this.listadoDeForos=new HashSet<SubForo>();
        this.usuarios=new ArrayList<Usuario>();
        this.entradaAbstractas =new HashSet<EntradaAbstracta>();
        this.managerUsuario=managerUsuario;
    }
    public ManagerSubForos(){

    }

    public HashSet<EntradaAbstracta> getEntradaAbstractas() {
        return entradaAbstractas;
    }

    public void setEntradaAbstractas(HashSet<EntradaAbstracta> entradaAbstractas) {
        this.entradaAbstractas = entradaAbstractas;
    }

    public HashSet<SubForo> getListadoDeForos() {
        return listadoDeForos;
    }

    public void setListadoDeForos(HashSet<SubForo> listadoDeForos) {
        this.listadoDeForos = listadoDeForos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public  void mostrarSubForo() {
        if(!listadoDeForos.isEmpty()){
            for (SubForo listadoDeForo : this.listadoDeForos) {
                System.out.println("\n" + listadoDeForo.getTituloSubForo());
            }
        }else{
            System.out.println("no hay foros para mostrar");
        }
    }

    public boolean crearSubforos(SubForo subforo,Usuario usuario){
        if(managerUsuario.encontradoRolProfesor(usuario)){
            if(!(this.getListadoDeForos()==null)){
                if(this.getListadoDeForos().contains(subforo)) {
                    return false;
                }else{
                    System.out.println("sub foro creado");
                    subforo.addObserver(managerUsuario);
                    listadoDeForos.add(subforo);
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    public boolean encontrarSubforos(String nombreDelSubForo){
        System.out.println("Buscando titulo");
        for (SubForo subForo:listadoDeForos){
            if(subForo.getTituloSubForo().equals(nombreDelSubForo)){
                System.out.println("titulo encontrado");
                return true;
            }
        }
        return false;
    }

    public SubForo getSubforoEncontrado(String nombreDelSubForo){
        System.out.println("Buscando el subforo");
        for (SubForo subForo:listadoDeForos){
            if(subForo.getTituloSubForo().equals(nombreDelSubForo)){
                System.out.println("Subforo encontrado");
                return subForo;
            }
        }
        return null;
    }


    public void mostrarLasSucripciones(SubForo subForo){
        for (SubForo foro:listadoDeForos){
            if(foro.getTituloSubForo().equals(subForo.getTituloSubForo())){
                for(Usuario suscrito: foro.getUsuariosSuscritos()){
                    System.out.println(suscrito.getNick());
                }

            }
        }
    }

    public boolean inscripcion(SubForo subForo,Usuario usuario){
        if(subForo.getUsuariosSuscritos().isEmpty()){
            subForo.getUsuariosSuscritos().add(usuario);
            System.out.println("Usted se ha inscrito en este foro "+subForo.getTituloSubForo());
            return true;
        }else{
            for(SubForo foro:listadoDeForos){
                if(foro.getTituloSubForo().equals(subForo.getTituloSubForo())){
                    if(foro.getUsuariosSuscritos().contains(usuario)){
                        System.out.println("Ya esta añadido");
                        return false;
                    }else{
                        System.out.println("Se añade");
                        subForo.getUsuariosSuscritos().add(usuario);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void update(String s) {
      for(Usuario user:subForo.getUsuariosSuscritos()){
          if(this.listadoDeForos.contains(user)){
              System.out.println("Tiene suscripciones");
          }
      }
    }

    public String toString(){
        StringBuilder infoForos= new StringBuilder();
        for(SubForo foro:listadoDeForos){
            infoForos.append("El foro: ").append(foro.toString()).append("\n");
            for(EntradaReal entradaReal:subForo.getEntry()){
                infoForos.append("\t").append(entradaReal.toString());
                for(Comentarios comentarios:entradaReal.getComentar()){
                    infoForos.append("\t").append(comentarios.toString());
                }
            }
        }
        return infoForos.toString();
    }

    public boolean guardarInfoForos(){
        try{
            FileOutputStream fos=new FileOutputStream("BaseDeDatosForos.obj");
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

    public static ManagerSubForos leerInfoForos(){
        ManagerSubForos su = null;
        try {
            FileInputStream file =new FileInputStream("BaseDeDatosForos.obj");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            su = (ManagerSubForos) inputFile.readObject();

            inputFile.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return su;
    }

}
