package com.company;

import java.io.Serializable;

public class Ejercicios extends EntradaAbstracta implements Serializable {

    private String preguntasEjercicios;

    public Ejercicios(String tituloEntrada, SubForo subForo, Usuario creador, String preguntasEjercicios) {
        super(tituloEntrada, subForo, creador);
        this.preguntasEjercicios = preguntasEjercicios;
    }

    public String getPreguntasEjercicios() {
        return preguntasEjercicios;
    }

    public void setPreguntasEjercicios(String preguntasEjercicios) {
        this.preguntasEjercicios = preguntasEjercicios;
    }

    @Override
    public String toString() {
        return super.toString()+" "+preguntasEjercicios;
    }

    @Override
    public void agregar(EntradaAbstracta ea) {
        System.out.println("No se puede agregar la entrada");
    }

    @Override
    public void eliminar(EntradaAbstracta ea) {
        System.out.println("No se puede quitar la entrada");
    }

    @Override
    public void mostrar(int profundidad) {
        System.out.println("- "+tituloEntrada+" "+preguntasEjercicios);
    }
}
