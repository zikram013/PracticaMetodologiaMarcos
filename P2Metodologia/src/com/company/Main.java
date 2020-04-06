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
        entradaReal.agregar(new Encuesta(entradaReal.tituloEntrada,foro,usuario,"pfff"));
        entradaReal.agregar(new Ejercicios(entradaReal.tituloEntrada,foro,usuario,"suspenspo"));
        foro.crearEntrada(entradaReal);
        foro.listarEntrada(foro.getTituloSubForo());



    }
}
