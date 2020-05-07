package com.company.Users;

import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerUsuarioTest {
    ManagerUsuario managerUsuario=new ManagerUsuario();

    @Test
    public void crearUsuario() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","alumno");
        assertTrue(managerUsuario.getListaDeUsuarios().add(usuario));
    }

    @Test
    public void encontradoRolProfesor() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        String rol=usuario.getRol();
        assertTrue(usuario.getRol()=="profesor");
    }

    @Test
    public void encontradoRolAdmin() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","admin");
        String rol=usuario.getRol();
        assertTrue(usuario.getRol()=="admin");
    }

    @Test
    public void encontradoRolAlumno() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","alumno");
        String rol=usuario.getRol();
        assertTrue(usuario.getRol()=="alumno");
    }

    @Test
    public void usuarioExisteSistema() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        assertEquals("Usuario no encontrado", false, managerUsuario.getListaDeUsuarios().contains(usuario));
    }
}