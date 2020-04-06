package com.company;

import java.util.ArrayList;

public class EntradaReal extends EntradaAbstracta {

    private ArrayList<EntradaAbstracta>entradaAbstracta= new ArrayList<EntradaAbstracta>();

    public EntradaReal(String tituloEntrada, SubForo subForo, Usuario creador) {
        super(tituloEntrada, subForo, creador);
        this.entradaAbstracta =new ArrayList<>();
    }

    public ArrayList<EntradaAbstracta> getEntradaAbstracta() {
        return entradaAbstracta;
    }

    public void setEntradaAbstracta(ArrayList<EntradaAbstracta> entradaAbstracta) {
        this.entradaAbstracta = entradaAbstracta;
    }

    @Override
    public String toString() {
        return "EntradaReal{" +
                "entradaAbstracta=" + entradaAbstracta +
                '}';
    }

    @Override
    public void agregar(EntradaAbstracta ea) {
        entradaAbstracta.add(ea);
    }

    @Override
    public void eliminar(EntradaAbstracta ea) {
        entradaAbstracta.remove(ea);
    }

    @Override
    public void mostrar(int profundidad) {
        System.out.println(tituloEntrada+" nivel: " +profundidad);
        for(int i=0;i<entradaAbstracta.size();i++){
            entradaAbstracta.get(i).mostrar(profundidad+1);
        }
    }
}
