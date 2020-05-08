package com.company.Users;

import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerUsuarioTest {
    ManagerUsuario managerUsuario=new ManagerUsuario();

    @Test
    public void crearUsuario() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","alumno");
        managerUsuario.crearUsuario(usuario);
        assertEquals("existe Usuario",usuario,managerUsuario.usuarioExisteSistema(usuario.getCorreo(),usuario.getContrasena()));
    }

    @Test
    public void encontradoRolProfesor() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        assertTrue(usuario.getRol()=="profesor");
    }

    @Test
    public void encontradoRolAdmin() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","admin");
        managerUsuario.crearUsuario(usuario);
        assertTrue(usuario.getRol()=="admin");
    }

    @Test
    public void encontradoRolAlumno() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","alumno");
        managerUsuario.crearUsuario(usuario);
        assertTrue(managerUsuario.encontradoRolAlumno(usuario));
    }

    @Test
    public void usuarioExisteSistema() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        assertEquals("Usuario no encontrado", false, managerUsuario.usuarioRegistrado(usuario));
    }
}