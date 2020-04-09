package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ManagerUsuario managerUsuario=new ManagerUsuario();
        ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);

        Verificar verificar=new Verificar(managerUsuario,managerSubForos);

        //Se crean los usuarios
        System.out.println("Se crean los usuarios");
        Usuario usuario=new Usuario("marcos","sanchez","zikram","hola","pass","profesor");
        Usuario usuario1=new Usuario("miguel","ruiz","yoshiki","yoshiki","verboten","alumno");
        Usuario admin=new Usuario("admin","admin","admin","admin","admin","admin");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.crearUsuario(usuario1);
        //iniciamos sesion
        managerUsuario.iniciarSesion(usuario);
        //Creamos subforos
        SubForo foro=new SubForo("Prueba",managerSubForos);
        SubForo foro2=new SubForo("Prueba2",managerSubForos);
        managerSubForos.crearSubforos(foro,usuario);
        //managerSubForos.crearSubforos(foro2,usuario);
        managerSubForos.inscripcion(foro,usuario);
        managerSubForos.mostrarLasSucripciones(foro);
        //Creamos entrada uno
        EntradaReal entradaReal=new EntradaReal("Hola",foro,usuario);
        entradaReal.agregar(new Encuesta(entradaReal.tituloEntrada,foro,usuario,"pfff"));
        entradaReal.agregar(new Ejercicios(entradaReal.tituloEntrada,foro,usuario,"suspenspo"));
        verificar.entradasParaValidar(entradaReal);
       // foro.crearEntrada(entradaReal);

        managerUsuario.desconectar(usuario);

        managerUsuario.iniciarSesion(admin);
        verificar.mostrarEntradasParaVerificar(admin);
        verificar.verificacion("D",entradaReal,admin);
        verificar.eliminar(entradaReal);
        verificar.eliminar(entradaReal);
        managerUsuario.desconectar(admin);

        System.out.println("el usuario "+usuario.getRol()+" esta sancionado " +usuario.isSancion());

      //  EntradaReal entradaReal1=new EntradaReal("SegundaPrueba",foro2,usuario1);
      //  entradaReal1.agregar(new Texto(entradaReal1.tituloEntrada,foro,usuario1,"hola hola"));
       // foro2.crearEntrada(entradaReal1);


       // managerUsuario.iniciarSesion(usuario);



        //foro.listarEntrada(foro.getTituloSubForo());




        //desconecto
        //managerUsuario.iniciarSesion(usuario);

      //  System.out.println("Los listamos");
        //managerSubForos.mostrarSubForo();




      //  foro.listarEntrada(foro.getTituloSubForo());
      //  foro2.listarEntrada(foro2.getTituloSubForo());


       // System.out.println("Vamos a suscribir");
        //conecto
      //  managerUsuario.iniciarSesion(usuario);
     //   managerSubForos.inscripcion(foro,usuario);
     //   //desconectar
     //  managerUsuario.desconectar(usuario);

      /*  managerSubForos.inscripcion(foro,usuario1);
        managerSubForos.inscripcion(foro2,usuario1);
        System.out.println("Vamos a ver esas suscripciones");
        managerSubForos.mostrarLasSucripciones(foro);
        managerSubForos.mostrarLasSucripciones(foro2);

        //conecto
        managerUsuario.iniciarSesion(usuario);
        System.out.println("Es true inicia sesion");

        System.out.println("Momento dificil: Comprobar si funciona el patron composite");

        System.out.println("Vamos a añadir un comentario a esa entrada");
        Comentarios comentario=new Comentarios("Ha funcionado el patron");
        entradaReal.crearComentario(comentario);
        entradaReal.mostrarComentarios(entradaReal.getTituloEntrada());

        Comentarios comentario1=new Comentarios("mas pruebas");
        entradaReal1.crearComentario(comentario1);
        entradaReal1.mostrarComentarios(entradaReal1.getTituloEntrada());


        managerUsuario.desconectar(usuario);
        System.out.println("cierra sesion");

       //conecto
        managerUsuario.iniciarSesion(usuario);


*/
    }
}
