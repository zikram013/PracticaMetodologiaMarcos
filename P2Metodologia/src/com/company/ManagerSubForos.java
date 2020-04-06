package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class ManagerSubForos {

    private SubForo subForo=new SubForo();
    private Usuario usuario=new Usuario();
    private HashSet<String> foro;
    private HashSet<SubForo>listadoDeForos;
    private HashSet<EntradaAbstracta> entradaAbstractas;
    private static ArrayList<Usuario>usuarios;

    public ManagerSubForos(){
        this.listadoDeForos=new HashSet<SubForo>();
        this.usuarios=new ArrayList<Usuario>();
        this.entradaAbstractas =new HashSet<EntradaAbstracta>();
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
        //Crear la mostrar
        for (SubForo listadoDeForo : this.listadoDeForos) {
            System.out.println("\n" + listadoDeForo.getTituloSubForo());
        }
    }

    public boolean crearSubforos(SubForo subforo,Usuario usuario){
        if(usuario.getRol().equals("Profesor") || usuario.getRol().equals("profesor")){
            if(!(this.getListadoDeForos()==null)){
                if(this.getListadoDeForos().contains(subforo)) {
                    return false;
                }else{
                    System.out.println("entro");
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



}
