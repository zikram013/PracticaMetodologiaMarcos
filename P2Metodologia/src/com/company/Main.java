package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ManagerUsuario managerUsuario=ManagerUsuario.leerInfoUsuarios();
        ManagerSubForos managerSubForos=ManagerSubForos.leerInfoForos();

        ArrayList<Usuario>listado=new ArrayList<>(managerUsuario.getListaDeUsuarios());
        ArrayList<SubForo>listaDeForos=new ArrayList<>(managerSubForos.getListadoDeForos());

        if(listado.size() <= 0){
            System.out.println("no hay usuarios");
        }else{
            System.out.println("El numero de usuarios registrados es: "+listado.size());
            managerUsuario.listarUsuarios();
        }
        System.out.println("El administrador es" +listado.get(3).toString());

        if(listaDeForos.size()<=0){
            System.out.println("no hay foros");
        }else{
            System.out.println("el numero de foros es: "+listaDeForos.size());
            managerSubForos.mostrarSubForo();
        }
        managerSubForos.mostrarLasSucripciones(listaDeForos.get(0));
        listaDeForos.get(0).listarEntrada(listaDeForos.get(0).getTituloSubForo());


















        //SubForo subForo=new SubForo("Dejame pasar",managerSubForos);
        Verificar verificar=new Verificar(managerUsuario,managerSubForos);
/*

        System.out.println("Se crean los usuarios");
        Usuario usuario=new Usuario("marcos","sanchez","zikram","hola","pass","profesor");
        Usuario usuario1=new Usuario("miguel","ruiz","yoshiki","yoshiki","verboten","alumno");
        Usuario admin=new Usuario("admin","admin","admin","admin","admin","admin");
        Usuario usuario2=new Usuario("Camila","Costanzo","cami","cami","cami","alumno");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.crearUsuario(usuario1);
        managerUsuario.crearUsuario(usuario2);
        managerUsuario.crearUsuario(admin);
        managerUsuario.guardarInfoUsuarios();

        managerUsuario.iniciarSesion(usuario);

        SubForo foro=new SubForo("Prueba",managerSubForos);
        SubForo foro2=new SubForo("Prueba2",managerSubForos);
        managerSubForos.crearSubforos(foro,usuario);

        managerSubForos.inscripcion(foro,usuario);
        managerSubForos.mostrarLasSucripciones(foro);

        EntradaReal entradaReal=new EntradaReal("Hola",foro,usuario);
        entradaReal.agregar(new Encuesta(entradaReal.getTituloEntrada(),foro,usuario,"pfff"));
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),foro,usuario,"suspenspo"));
        verificar.entradasParaValidar(entradaReal);
        managerUsuario.desconectar(usuario);


        managerUsuario.iniciarSesion(admin);
        verificar.mostrarEntradasParaVerificar(admin);
        verificar.verificacion("A",entradaReal,admin);
        verificar.eliminar(entradaReal);
        managerUsuario.desconectar(admin);

        System.out.println("el usuario "+usuario.getRol()+" esta sancionado " +usuario.isSancion());

        managerUsuario.iniciarSesion(usuario1);
        EntradaReal entradaReal1=new EntradaReal("SegundaPrueba",foro2,usuario1);
        entradaReal1.agregar(new Texto(entradaReal1.tituloEntrada,foro,usuario1,"hola hola"));
       managerUsuario.desconectar(usuario1);

        managerUsuario.iniciarSesion(admin);
        verificar.mostrarEntradasParaVerificar(admin);
        verificar.verificacion("A",entradaReal1,admin);
        verificar.eliminar(entradaReal1);
        managerUsuario.desconectar(admin);



        managerUsuario.iniciarSesion(usuario);

        Comentarios comentario=new Comentarios("Ha funcionado el patron");
        entradaReal.crearComentario(comentario);
        entradaReal.mostrarComentarios(entradaReal.getTituloEntrada());

        Comentarios comentario1=new Comentarios("mas pruebas");
        entradaReal1.crearComentario(comentario1);
        entradaReal1.mostrarComentarios(entradaReal1.getTituloEntrada());
        managerUsuario.desconectar(usuario);

        managerUsuario.iniciarSesion(usuario2);
        foro.votarEntrada(usuario2,entradaReal.getTituloEntrada(),foro.getTituloSubForo(),"P");
        foro.listarEntrada(foro.getTituloSubForo());
        managerUsuario.desconectar(usuario2);

        managerSubForos.guardarInfoForos();
*/


    }

}
