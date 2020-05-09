package com.company.Verificar;

import com.company.Entradas.Ejercicios;
import com.company.Entradas.EntradaReal;
import com.company.SubForos.ManagerSubForos;
import com.company.SubForos.SubForo;
import com.company.Users.ManagerUsuario;
import com.company.Users.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerificarTest {
    ManagerUsuario managerUsuario=new ManagerUsuario();
    ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);
    Verificar verificar=new Verificar(managerUsuario,managerSubForos);


    @Test
    public void verificacion() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        Usuario usuarioAdmin=new Usuario("admin","admin","admin","admin","admin","admin");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.crearUsuario(usuarioAdmin);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerSubForos.crearSubforos(subForo,usuario);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),subForo,usuario,"Ejercicio Testing"));
        verificar.entradasParaValidar(entradaReal);
        managerUsuario.desconectar(usuario);
        managerUsuario.iniciarSesion(usuarioAdmin.getCorreo(),usuarioAdmin.getContrasena());
        verificar.verificacion("A",entradaReal,usuarioAdmin);
        assertEquals("Entrada verificada",true,entradaReal.isValidacion());
        assertEquals("Usuario no sancionado",false,usuario.isSancion());

        assertEquals("Entrada no encontrada",entradaReal,subForo.getEntradaEncontrada(entradaReal.getTituloEntrada()));
    }

    @Test
    public void entradasParaValidar() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerSubForos.crearSubforos(subForo,usuario);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),subForo,usuario,"Ejercicio Testing"));
        assertTrue(verificar.entradasParaValidar(entradaReal));

    }
}