package com.company;

public class Encuesta extends EntradaAbstracta {

    private String cuestionario;

    public Encuesta(String tituloEntrada, SubForo subForo, Usuario creador, String cuestionario) {
        super(tituloEntrada, subForo, creador);
        this.cuestionario = cuestionario;
    }

    public String getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(String cuestionario) {
        this.cuestionario = cuestionario;
    }

    @Override
    public String toString() {
        return super.toString()+" "+cuestionario;
    }

    @Override
    public void agregar(EntradaAbstracta ea) {
        System.out.println("No se puede agregar el cuestionario");
    }

    @Override
    public void eliminar(EntradaAbstracta ea) {
        System.out.println("No se puede quitar el cuestionario");
    }

    @Override
    public void mostrar(int profundidad) {
        System.out.println("- "+tituloEntrada+" "+cuestionario);
    }
}
