package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Entrada {

    private SubForo subForo;
    private String tituloEntrada;
    private ArrayList<Comentarios>comentar;
    private int valoracionPositiva;
    private int valoracionNegativa;
    private String textoEntrada;
    private ArrayList<Usuario>usuarioHaVotado;
    private Usuario creador;

    public Entrada(String tituloEntrada,String textoEntrada,SubForo subForo,Usuario creador) {
        this.tituloEntrada = tituloEntrada;
        this.comentar = new ArrayList<Comentarios>();
        this.usuarioHaVotado=new ArrayList<Usuario>();
        this.valoracionPositiva = 0;
        this.valoracionNegativa = 0;
        this.textoEntrada= textoEntrada;
        this.subForo=subForo;
        this.creador=creador;
    }


    public Entrada() {

    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public String getTextoEntrada() {
        return textoEntrada;
    }

    public void setTextoEntrada(String textoEntrada) {
        this.textoEntrada = textoEntrada;
    }

    public String getTituloEntrada() {
        return tituloEntrada;
    }

    public void setTituloEntrada(String tituloEntrada) {
        this.tituloEntrada = tituloEntrada;
    }

    public ArrayList<Comentarios> getComentar() {
        return comentar;
    }

    public void setComentar(ArrayList<Comentarios> comentar) {
        this.comentar = comentar;
    }

    public int getValoracionPositiva() {
        return valoracionPositiva;
    }

    public void setValoracionPositiva(int valoracionPositiva) {
        this.valoracionPositiva = valoracionPositiva;
    }

    public int getValoracionNegativa() {
        return valoracionNegativa;
    }

    public void setValoracionNegativa(int valoracionNegativa) {
        this.valoracionNegativa = valoracionNegativa;
    }

    public ArrayList<Usuario> getUsuarioHaVotado() {
        return usuarioHaVotado;
    }

    public void setUsuarioHaVotado(ArrayList<Usuario> usuarioHaVotado) {
        this.usuarioHaVotado = usuarioHaVotado;
    }

    public boolean crearComentario(Comentarios coment){
       if(!(subForo.getEntry().isEmpty())){
           for(Entrada entrada:subForo.getEntry()){
               if(entrada.getTituloEntrada().equals(getTituloEntrada())){
                   //for(Comentarios comentarios:getComentar()){
                       System.out.println("Crea el comentario");
                       getComentar().add(coment);
                       return true;
                  // }
               }
           }
       }
        return false;
    }

    public void mostrarComentarios(String nombreEntrada){
        for(Entrada entrada:subForo.getEntry()){
            if (entrada.getTituloEntrada().equals(nombreEntrada)){
                for(Comentarios comentarios:comentar){
                    if(!(comentar.isEmpty())){
                        System.out.println("\n" + comentarios.getComentario());
                    }else{
                        System.out.println("no tiene comentarios");
                    }
                }
            }
        }

    }

}
