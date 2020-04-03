package com.company;

public class Verificar {

    private boolean aceptado;
    private Entrada entrada=new Entrada();

    public Verificar(boolean aceptado, Entrada entrada) {
        this.aceptado = aceptado;
        this.entrada = entrada;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }
}
