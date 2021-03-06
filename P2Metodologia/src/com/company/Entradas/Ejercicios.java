package com.company.Entradas;

import com.company.EntradaAbstracta;
import com.company.SubForos.SubForo;
import com.company.Users.Usuario;

import java.io.Serializable;

public class Ejercicios extends EntradaAbstracta implements Serializable {
    private static final long serialVersionUID = 1L;
    private String preguntasEjercicios;

    public Ejercicios(String tituloEntrada, SubForo subForo, Usuario creador, String preguntasEjercicios) {
        super(tituloEntrada, subForo, creador);
        this.preguntasEjercicios = preguntasEjercicios;
    }

    public Ejercicios(String tituloEntrada, SubForo subForo, Usuario creador) {
        super(tituloEntrada, subForo, creador);
    }

    public String getPreguntasEjercicios() {
        return preguntasEjercicios;
    }

    public void setPreguntasEjercicios(String preguntasEjercicios) {
        this.preguntasEjercicios = preguntasEjercicios;
    }

    @Override
    public String toString() {
        return preguntasEjercicios;
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

    @Override
    public void editar(String edit) {
        setPreguntasEjercicios(edit);
    }
}
