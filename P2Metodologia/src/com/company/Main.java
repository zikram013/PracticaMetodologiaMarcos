package com.company;

import com.company.Comentarios.Comentarios;
import com.company.Entradas.Ejercicios;
import com.company.Entradas.Encuesta;
import com.company.Entradas.EntradaReal;
import com.company.Entradas.Texto;
import com.company.SubForos.ManagerSubForos;
import com.company.SubForos.SubForo;
import com.company.Users.ManagerUsuario;
import com.company.Users.Usuario;
import com.company.Verificar.Verificar;

public class Main {

    public static void main(String[] args) {
/*
        ManagerUsuario managerUsuario=ManagerUsuario.leerInfoUsuarios();
        new ManagerSubForos(managerUsuario);
        ManagerSubForos managerSubForos= ManagerSubForos.leerInfoForos();


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

        managerUsuario.iniciarSesion(listado.get(0));
        SubForo foro=new SubForo("Metodlogia",managerSubForos);
        managerSubForos.crearSubforos(foro,listado.get(0));
        managerUsuario.desconectar(listado.get(0));
        managerSubForos.mostrarSubForo();*/

















        //SubForo subForo=new SubForo("Dejame pasar",managerSubForos);
        ManagerUsuario managerUsuario=new ManagerUsuario();
        ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);
        Verificar verificar=new Verificar(managerUsuario,managerSubForos);


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



    }

}
