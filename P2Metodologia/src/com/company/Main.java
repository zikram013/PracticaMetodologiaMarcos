package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ManagerSubForos managerSubForos=new ManagerSubForos();
        ManagerUsuario managerUsuario=new ManagerUsuario();

        Usuario usuario=new Usuario("marcos","sanchez","zikram","hola","pass","profesor",managerUsuario);
        Usuario usuario1=new Usuario("miguel","ruiz","yoshiki","yoshiki","verboten","alumno",managerUsuario);
        SubForo foro=new SubForo("Prueba",managerSubForos);
        SubForo foro2=new SubForo("Prueba2",managerSubForos);
        System.out.println("Se crean los usuarios");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.crearUsuario(usuario1);
        managerUsuario.listarUsuarios();

        System.out.println("Creamos un foro");
        managerSubForos.crearSubforos(foro,usuario);
        managerSubForos.crearSubforos(foro2,usuario);

        System.out.println("Los listamos");
        managerSubForos.mostrarSubForo();

        System.out.println("Momento dificil: Comprobar si funciona el patron composite");
        EntradaReal entradaReal=new EntradaReal("Hola",foro,usuario);
        EntradaReal entradaReal1=new EntradaReal("SegundaPrueba",foro2,usuario);
        entradaReal.agregar(new Encuesta(entradaReal.tituloEntrada,foro,usuario,"pfff"));
        entradaReal.agregar(new Ejercicios(entradaReal.tituloEntrada,foro,usuario,"suspenspo"));
        entradaReal1.agregar(new Texto(entradaReal1.tituloEntrada,foro,usuario,"hola hola"));
        foro.crearEntrada(entradaReal);
        foro2.crearEntrada(entradaReal1);
        foro.listarEntrada(foro.getTituloSubForo());
        foro2.listarEntrada(foro2.getTituloSubForo());

        System.out.println("Vamos a añadir un comentario a esa entrada");
        Comentarios comentario=new Comentarios("Ha funcionado el patron");
        entradaReal.crearComentario(comentario);
        entradaReal.mostrarComentarios(entradaReal.getTituloEntrada());

        Comentarios comentario1=new Comentarios("mas pruebas");
        entradaReal1.crearComentario(comentario1);
        entradaReal1.mostrarComentarios(entradaReal1.getTituloEntrada());

        System.out.println("Vamos a suscribir");
        managerSubForos.inscripcion(foro,usuario);
        managerSubForos.inscripcion(foro,usuario1);
        managerSubForos.inscripcion(foro2,usuario1);
        System.out.println("Vamos a ver esas suscripciones");
        managerSubForos.mostrarLasSucripciones(foro);
        managerSubForos.mostrarLasSucripciones(foro2);


    }
}
