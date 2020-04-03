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
        Entrada entrada=new Entrada("Hi all", "Como esta ustedes",foro,usuario);
        Comentarios comentarios1=new Comentarios("me gusta");
        managerSubForos.crearSubforos(foro);
        managerUsuario.crearUsuario(usuario);
        managerUsuario.crearUsuario(usuario1);
        managerSubForos.crearSubforos(foro2);
        foro.crearEntrada(entrada);
        entrada.getComentar().add(comentarios1);


        //SubForo foro3=new SubForo("Foro");
        //managerSubForos.crearSubforos(foro3);
        InterfazUsuario iu=new InterfazUsuario(managerSubForos,managerUsuario);
        iu.inicializarMenu(Usuario.getInstanciausuario());


    }
}
