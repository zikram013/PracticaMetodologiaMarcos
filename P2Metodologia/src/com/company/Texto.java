package com.company;

import java.io.Serializable;

public class Texto extends EntradaAbstracta implements Serializable {

    private String texto;

    public Texto(String tituloEntrada, SubForo subForo, Usuario creador, String texto) {
        super(tituloEntrada, subForo, creador);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return super.toString()+" "+texto;
    }

    @Override
    public void agregar(EntradaAbstracta ea) {
        System.out.println("No se puede quitar el texto");
    }

    @Override
    public void eliminar(EntradaAbstracta ea) {
        System.out.println("No se puede quitar el texto");
    }

    @Override
    public void mostrar(int profundidad) {
        System.out.println("- "+tituloEntrada+" "+texto);
    }

}
