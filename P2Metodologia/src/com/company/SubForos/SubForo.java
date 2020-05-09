package com.company.SubForos;

import com.company.*;
import com.company.Entradas.EntradaReal;
import com.company.Entradas.Texto;
import com.company.Observer.Observador;
import com.company.Observer.SujetoObservable;
import com.company.Users.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class SubForo implements SujetoObservable, Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Observador>chivatos;
    private ManagerSubForos managerSubForos;
    private String tituloSubForo;
    private HashSet<Texto> textito;
    private HashSet<EntradaReal>entry;
    private Texto text;
    private static final SubForo INSTANCIASUBFORO=new SubForo();
    private HashSet<Usuario>usuariosSuscritos;



    //constructor getters and setters
    public SubForo(String tituloSubForo,ManagerSubForos managerSubForos) {
        this.tituloSubForo = tituloSubForo;
        this.textito = new HashSet<Texto>();
        this.managerSubForos=managerSubForos;
        this.entry=new HashSet<EntradaReal>();
        this.usuariosSuscritos=new HashSet<Usuario>();
        this.chivatos=new ArrayList<>();
    }


    public SubForo(){

    }

    public static SubForo getInstanciaSubForo() {
        return INSTANCIASUBFORO;
    }


    public HashSet<Usuario> getUsuariosSuscritos() {
        return usuariosSuscritos;
    }

    public void setUsuariosSuscritos(HashSet<Usuario> usuariosSuscritos) {
        this.usuariosSuscritos = usuariosSuscritos;
    }

    public String getTituloSubForo() {
        return tituloSubForo;
    }

    public void setTituloSubForo(String tituloSubForo) {
        this.tituloSubForo = tituloSubForo;
    }


    public HashSet<EntradaReal> getEntry() {
        return entry;
    }

    public void setEntry(HashSet<EntradaReal> entry) {
        this.entry = entry;
    }

    public boolean crearEntrada(EntradaAbstracta ent) {
            if(!(managerSubForos.getListadoDeForos().isEmpty())){
                for (SubForo subForo : managerSubForos.getListadoDeForos()) {
                    if (subForo.getTituloSubForo().equals(getTituloSubForo())) {
                        System.out.println("Buscando entradas con nombre similar en el subforo "+ subForo.getTituloSubForo());
                        if(getEntry().isEmpty()){
                            getEntry().add((EntradaReal) ent);
                            System.out.println("crea entrada");
                            notificar();
                            return true;
                        }else{
                            for (EntradaReal entradaReal : getEntry()) {
                                System.out.println("leyendo entradas");
                                if (!(entradaReal.equals(ent))) {
                                    System.out.println("crea entrada");
                                    getEntry().add((EntradaReal) ent);
                                    notificar();
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
    }


    public void listarEntrada(String subForos) {
        for(SubForo subForo: managerSubForos.getListadoDeForos()){
            if(subForo.getTituloSubForo().equals(subForos)){
                System.out.println("listado de entradas");
                for (EntradaReal entradaReal : entry) {
                    if (!(entry.isEmpty())){
                        System.out.println("\n" + entradaReal.getTituloEntrada() +" " +" "+"Positivo "+ entradaReal.getValoracionPositiva()+" "+ "Negativo " + entradaReal.getValoracionNegativa()+" Escrito por: "+ entradaReal.getCreador().getNick()+"el contenido es: ");
                       System.out.println(entradaReal.toString());
                        entradaReal.mostrarComentarios(entradaReal.getTituloEntrada());
                      //  System.out.println("\n" + entradaReal.getTituloEntrada() + " " + "Positivo " + entradaReal.getValoracionPositiva() + " " + "Negativo " + entradaReal.getValoracionNegativa()+" Escrito por: "+ entradaReal.getCreador().getNick());

                    }else{
                        System.out.println("No tiene entradas");
                    }

                }
            }
        }
    }

    public EntradaReal getEntradaEncontrada(String tituloDeLaEntrada){
       // System.out.println("Buscando el subforo");
        for (EntradaReal entradaReal :entry){
            if(entradaReal.getTituloEntrada().equals(tituloDeLaEntrada)){
               // System.out.println("Subforo encontrado");
                return entradaReal;
            }
        }
        return null;
    }

    public EntradaReal getEntradaEncontrada1(EntradaReal entradaReal){
        // System.out.println("Buscando el subforo");
        for (EntradaReal entradaReal1 :entry){
            if(entry.contains(entradaReal)){
                // System.out.println("Subforo encontrado");
                return entradaReal1;
            }
        }
        return null;
    }

    public void votarEntrada(Usuario user,String tituloDeLaEntrada,String tituloSubForo,String voto){
        String letra=voto;
        if(user.isConectado()){
            for(SubForo subForo: managerSubForos.getListadoDeForos()){
                if(subForo.getTituloSubForo().equals(tituloSubForo)) {
                    System.out.println("listado de entradas");
                    for (EntradaReal entradaReal : entry) {
                        if (!(entry.isEmpty())) {
                            System.out.println("\n" + entradaReal.getTituloEntrada() + " " + "Positivo " + entradaReal.getValoracionPositiva() + " " + "Negativo " + entradaReal.getValoracionNegativa()+" Escrito por: "+ entradaReal.getCreador().getNick());
                            if (entradaReal.getTituloEntrada().equals(tituloDeLaEntrada)) {
                                if((entradaReal.getUsuarioHaVotado().isEmpty()) || (!(entradaReal.getUsuarioHaVotado().contains(user)))) {
                                    System.out.println("Valorar P-positivo N-Negativo");
                                    do {
                                        switch (letra) {
                                            case "P":
                                                entradaReal.getUsuarioHaVotado().add(user);
                                                int contadorPositivo;
                                                contadorPositivo = entradaReal.getValoracionPositiva();
                                                contadorPositivo++;
                                                entradaReal.setValoracionPositiva(contadorPositivo);
                                              //  System.out.println("\n" + entradaReal.getTituloEntrada() +  " " + "Positivo " + entradaReal.getValoracionPositiva() + " " + "Negativo " + entradaReal.getValoracionNegativa()+" Escrito por: "+ entradaReal.getCreador().getNick());
                                                //System.out.println(entradaReal.toString());
                                                System.out.println("\n" + entradaReal.getTituloEntrada() + " " + "Positivo " + entradaReal.getValoracionPositiva() + " " + "Negativo " + entradaReal.getValoracionNegativa()+" Escrito por: "+ entradaReal.getCreador().getNick());

                                                break;
                                            case "N":
                                                entradaReal.getUsuarioHaVotado().add(user);
                                                int contadorNegativo;
                                                contadorNegativo = entradaReal.getValoracionNegativa();
                                                contadorNegativo++;
                                                entradaReal.setValoracionNegativa(contadorNegativo);
                                                System.out.println("\n" + entradaReal.getTituloEntrada() + " " + "Positivo " + entradaReal.getValoracionPositiva() + " " + "Negativo " + entradaReal.getValoracionNegativa()+" Escrito por: "+ entradaReal.getCreador().getNick());
                                                break;
                                        }
                                    } while (letra.equals("S"));
                                }else {
                                    System.out.println("no puede votar o ya ha votado");
                                }
                            } else {
                                System.out.println("No tiene entradas");
                            }
                        }
                    }

                }
            }
        }else{
            System.out.println("no puede votar");
        }

    }


    @Override
    public void notificar() {
        for(Observador chivato:chivatos){
           chivato.update(tituloSubForo);
        }
    }

    @Override
    public void addObserver(Observador observador) {
        chivatos.add(observador);
    }

    @Override
    public void deleteObserver(Observador observador) {
        chivatos.remove(observador);

    }

    @Override
    public String toString() {
        return "SubForo{" +
                "tituloSubForo='" + tituloSubForo + '\'' +
                ", entry=" + entry +
                ", usuariosSuscritos=" + usuariosSuscritos +
                '}';
    }
}
