package com.company;

public class Main {

    public static void main(String[] args) {

        ManagerUsuario managerUsuario=ManagerUsuario.leerInfo();
        managerUsuario.listarUsuarios();
        ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);

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
