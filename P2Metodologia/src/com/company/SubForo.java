package com.company;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class SubForo {

    private ManagerSubForos managerSubForos;
    private String tituloSubForo;
    private HashSet<Texto> textito;
    private HashSet<Entrada>entry;
    private Texto text;
    private static final SubForo INSTANCIASUBFORO=new SubForo();
    private Escaner escaner;


    //constructor getters and setters
    public SubForo(String tituloSubForo,ManagerSubForos managerSubForos) {
        this.tituloSubForo = tituloSubForo;
        this.textito = new HashSet<Texto>();
        this.managerSubForos=managerSubForos;
        this.entry=new HashSet<Entrada>();
        this.escaner=new Escaner();
    }


    public SubForo() {

    }

    public static SubForo getInstanciaSubForo() {
        return INSTANCIASUBFORO;
    }


    public String getTituloSubForo() {
        return tituloSubForo;
    }

    public void setTituloSubForo(String tituloSubForo) {
        this.tituloSubForo = tituloSubForo;
    }


    public HashSet<Entrada> getEntry() {
        return entry;
    }

    public void setEntry(HashSet<Entrada> entry) {
        this.entry = entry;
    }

    public boolean crearEntrada(Entrada ent) {
            if(!(managerSubForos.getListadoDeForos().isEmpty())){
                for (SubForo subForo : managerSubForos.getListadoDeForos()) {
                    if (subForo.getTituloSubForo().equals(getTituloSubForo())) {
                        System.out.println("Buscando entradas con nombre similar en el subforo "+ subForo.getTituloSubForo());
                        for (Entrada entrada : getEntry()) {
                            System.out.println("leyendo entradas");
                            if (!(entrada.equals(ent))) {
                                System.out.println("crea entrada");
                                getEntry().add(ent);
                                return true;
                            }
                        }
                        if(getEntry().isEmpty()){
                            getEntry().add(ent);
                            return true;
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
                for (Entrada entrada : entry) {
                    if (!(entry.isEmpty())){
                        System.out.println("\n" + entrada.getTituloEntrada() +" "+ entrada.getTextoEntrada()+ " " +"Positivo "+ entrada.getValoracionPositiva()+" "+ "Negativo " +entrada.getValoracionNegativa()+" Escrito por: "+entrada.getCreador().getNick());
                    }else{
                        System.out.println("No tiene entradas");
                    }

                }
            }
        }
    }

    public Entrada getEntradaEncontrada(String tituloDeLaEntrada){
       // System.out.println("Buscando el subforo");
        for (Entrada entrada:entry){
            if(entrada.getTituloEntrada().equals(tituloDeLaEntrada)){
               // System.out.println("Subforo encontrado");
                return entrada;
            }
        }
        return null;
    }

    public void votarEntrada(Usuario user,String tituloDeLaEntrada,String tituloSubForo){
        String letra;
        for(SubForo subForo: managerSubForos.getListadoDeForos()){
            if(subForo.getTituloSubForo().equals(tituloSubForo)) {
                System.out.println("listado de entradas");
                for (Entrada entrada : entry) {
                    if (!(entry.isEmpty())) {
                        System.out.println("\n" + entrada.getTituloEntrada() + " " + entrada.getTextoEntrada() + " " + "Positivo " + entrada.getValoracionPositiva() + " " + "Negativo " + entrada.getValoracionNegativa()+" Escrito por: "+entrada.getCreador().getNick());
                        if (entrada.getTituloEntrada().equals(tituloDeLaEntrada)) {
                            if((entrada.getUsuarioHaVotado().isEmpty()) || (!(entrada.getUsuarioHaVotado().contains(user)))) {
                                System.out.println("Valorar P-positivo N-Negativo");
                                try {
                                    do {
                                        letra = escaner.escanerString();
                                        switch (letra) {
                                            case "P":
                                                entrada.getUsuarioHaVotado().add(user);
                                                int contadorPositivo;
                                                contadorPositivo = entrada.getValoracionPositiva();
                                                contadorPositivo++;
                                                entrada.setValoracionPositiva(contadorPositivo);
                                                System.out.println("\n" + entrada.getTituloEntrada() + " " + entrada.getTextoEntrada() + " " + "Positivo " + entrada.getValoracionPositiva() + " " + "Negativo " + entrada.getValoracionNegativa()+" Escrito por: "+entrada.getCreador().getNick());
                                                break;
                                            case "N":
                                                entrada.getUsuarioHaVotado().add(user);
                                                int contadorNegativo;
                                                contadorNegativo = entrada.getValoracionNegativa();
                                                contadorNegativo++;
                                                entrada.setValoracionNegativa(contadorNegativo);
                                                System.out.println("\n" + entrada.getTituloEntrada() + " " + entrada.getTextoEntrada() + " " + "Positivo " + entrada.getValoracionPositiva() + " " + "Negativo " + entrada.getValoracionNegativa()+" Escrito por: "+entrada.getCreador().getNick());
                                                break;
                                        }
                                    } while (letra.equals("S"));
                                } catch (IOException ioe) {
                                    ioe.printStackTrace();
                                }
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
    }
}
