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
        assertTrue(managerUsuario.encontradoRolProfesor(usuario));
    }

    @Test
    public void encontradoRolAdmin() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","admin");
        managerUsuario.crearUsuario(usuario);
        assertTrue(managerUsuario.encontradoRolAdmin(usuario));
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

    @Test
    public void iniciarSesion() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        assertEquals("Usuario conectado",true,usuario.isConectado());
    }

    @Test
    public void desconectar() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        managerUsuario.desconectar(usuario);
        assertEquals("Desconectado",false,usuario.isConectado());
    }

    @Test
    public void guardarInformacion(){
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        assertTrue(managerUsuario.guardarInfoUsuarios());
    }
}