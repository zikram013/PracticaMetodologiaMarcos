package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class EntradaAbstracta implements Serializable {

    private SubForo subForo;
    protected String tituloEntrada;
    private ArrayList<Comentarios>comentar;
    private int valoracionPositiva;
    private int valoracionNegativa;
    private ArrayList<Usuario>usuarioHaVotado;
    private Usuario creador;
    private boolean validacion;
    private static final long serialVersionUID = 1L;
    public EntradaAbstracta(String tituloEntrada, SubForo subForo, Usuario creador) {
        this.tituloEntrada = tituloEntrada;
        this.comentar = new ArrayList<Comentarios>();
        this.usuarioHaVotado=new ArrayList<Usuario>();
        this.valoracionPositiva = 0;
        this.valoracionNegativa = 0;
        this.subForo=subForo;
        this.creador=creador;
        this.validacion=false;
    }

    public boolean isValidacion() {
        return validacion;
    }

    public void setValidacion(boolean validacion) {
        this.validacion = validacion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
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

    public SubForo getSubForo() {
        return subForo;
    }

    public void setSubForo(SubForo subForo) {
        this.subForo = subForo;
    }

    @Override
    public String toString() {
        return "EntradaAbstracta{" +
                "tituloEntrada='" + tituloEntrada + '\'' +
                ", valoracionPositiva=" + valoracionPositiva +
                ", valoracionNegativa=" + valoracionNegativa +
                ", creador=" + creador.getNick() +
                '}';
    }

    abstract public void agregar(EntradaAbstracta ea);
    abstract public void eliminar(EntradaAbstracta ea);
    abstract public void mostrar(int profundidad);



    public boolean crearComentario(Comentarios coment){
        if(!(subForo.getEntry().isEmpty())){
            for(EntradaAbstracta entradaAbstracta :subForo.getEntry()){
                if(entradaAbstracta.getTituloEntrada().equals(getTituloEntrada())){
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
        for(EntradaAbstracta entradaAbstracta :subForo.getEntry()){
            if (entradaAbstracta.getTituloEntrada().equals(nombreEntrada)){
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
