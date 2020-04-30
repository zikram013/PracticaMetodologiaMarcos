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

import java.net.UnknownServiceException;
import java.util.HashSet;

public class Demostrador {

    public static void main(String[] args) {

        ManagerUsuario managerUsuario=new ManagerUsuario();
        ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);
        Verificar verificar=new Verificar(managerUsuario,managerSubForos);



        System.out.println("Se crean los usuarios");
        Usuario usuario=new Usuario("marcos","sanchez","zikram","hola","pass","profesor");
        Usuario usuario1=new Usuario("miguel","ruiz","yoshiki","yoshiki","verboten","alumno");
        Usuario admin=new Usuario("admin","admin","admin","admin","admin","admin");
        Usuario usuario2=new Usuario("Camila","Costanzo","cami","cami","cami","alumno");
        Usuario usuario3=new Usuario("No","Existe","no","no","no","alumno");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.crearUsuario(usuario1);
        managerUsuario.crearUsuario(usuario2);
        managerUsuario.crearUsuario(admin);
        managerUsuario.guardarInfoUsuarios();

        System.out.println(managerUsuario.encontradoRolAdministrador());

        managerUsuario.iniciarSesion(usuario3.getCorreo(),usuario3.getContraseña());
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContraseña());

        SubForo foro=new SubForo("Prueba",managerSubForos);
        SubForo foro2=new SubForo("Prueba2",managerSubForos);
        managerSubForos.crearSubforos(foro,usuario);
        managerSubForos.crearSubforos(foro2,usuario);
        managerSubForos.inscripcion(foro,usuario);
        managerSubForos.mostrarLasSucripciones(foro);

        EntradaReal entradaReal=new EntradaReal("Hola",foro,usuario);
        entradaReal.agregar(new Encuesta(entradaReal.getTituloEntrada(),foro,usuario,"pfff"));
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),foro,usuario,"suspenspo"));
        verificar.entradasParaValidar(entradaReal);
        managerUsuario.desconectar(usuario);


        managerUsuario.iniciarSesion(admin.getCorreo(),admin.getContraseña());
        verificar.mostrarEntradasParaVerificar(admin);
        verificar.verificacion("A",entradaReal,admin);
        verificar.eliminar(entradaReal);
        managerUsuario.desconectar(admin);

        System.out.println("el usuario "+usuario.getNick()+" esta sancionado " +usuario.isSancion());

        managerUsuario.iniciarSesion(usuario1.getCorreo(),usuario1.getContraseña());
        managerSubForos.inscripcion(foro2,usuario1);
        EntradaReal entradaReal1=new EntradaReal("SegundaPrueba",foro2,usuario1);
        entradaReal1.agregar(new Texto(entradaReal1.tituloEntrada,foro2,usuario1,"hola hola"));
        verificar.entradasParaValidar(entradaReal1);
        managerUsuario.desconectar(usuario1);


        managerUsuario.iniciarSesion(admin.getCorreo(),admin.getContraseña());
        verificar.mostrarEntradasParaVerificar(admin);
        verificar.verificacion("D",entradaReal1,admin);
        verificar.eliminar(entradaReal1);
        managerUsuario.desconectar(admin);

        System.out.println("el usuario "+usuario1.getNick()+" esta sancionado " +usuario1.isSancion());

        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContraseña());

        Comentarios comentario=new Comentarios("Ha funcionado el patron");
        entradaReal.crearComentario(comentario);
        entradaReal.mostrarComentarios(entradaReal.getTituloEntrada());

        Comentarios comentario1=new Comentarios("mas pruebas");
        entradaReal1.crearComentario(comentario1);
        entradaReal1.mostrarComentarios(entradaReal1.getTituloEntrada());
        managerUsuario.desconectar(usuario);

        managerUsuario.iniciarSesion(usuario2.getCorreo(),usuario2.getContraseña());
        foro.votarEntrada(usuario2,entradaReal.getTituloEntrada(),foro.getTituloSubForo(),"P");
        foro.listarEntrada(foro.getTituloSubForo());
        managerUsuario.desconectar(usuario2);


        managerUsuario.iniciarSesion(admin.getCorreo(),admin.getContraseña());
        verificar.mostrarEntradasParaVerificar(admin);
        verificar.verificacion("D",entradaReal1,admin);
        verificar.eliminar(entradaReal1);
        managerUsuario.desconectar(admin);


        managerUsuario.guardarInfoUsuarios();
        managerSubForos.guardarInfoForos();

        managerUsuario.setListaDeUsuarios(ManagerUsuario.leerInfoUsuarios());
        managerUsuario.listarUsuarios();

        managerSubForos.setListadoDeForos(ManagerSubForos.leerInfoForos());
        managerSubForos.mostrarSubForo();
        managerSubForos.mostrarLasSucripciones(managerSubForos.getSubforoEncontrado("Prueba"));
        managerSubForos.mostrarLasSucripciones(managerSubForos.getSubforoEncontrado("Prueba2"));
        managerSubForos.getSubforoEncontrado("Prueba").listarEntrada("Prueba");
        managerSubForos.getSubforoEncontrado("Prueba2").listarEntrada("Prueba2");
        managerSubForos.getSubforoEncontrado("Prueba").getEntradaEncontrada("Hola").mostrarComentarios("Hola");
    }

}