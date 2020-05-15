package com.company.Entradas;

import com.company.Comentarios.Comentarios;
import com.company.EntradaAbstracta;
import com.company.SubForos.SubForo;
import com.company.Users.Usuario;

import java.util.ArrayList;

public class EntradaReal extends EntradaAbstracta {

    private ArrayList<EntradaAbstracta>entradaAbstracta;

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
    public void editar(String edit) {

    }

    @Override
    public String toString() {
        return ""+ entradaAbstracta;
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
        for (EntradaAbstracta abstracta : entradaAbstracta) {
            abstracta.mostrar(profundidad + 1);
        }
    }



}
