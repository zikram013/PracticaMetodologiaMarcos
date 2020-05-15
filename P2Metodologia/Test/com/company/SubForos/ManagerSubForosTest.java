package com.company.SubForos;

import com.company.Users.ManagerUsuario;
import com.company.Users.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerSubForosTest {
    ManagerUsuario managerUsuario=new ManagerUsuario();
    ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);

    @Test
    public void crearSubforos() {
        SubForo subForo=new SubForo("Testing",managerSubForos);
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        assertTrue(managerSubForos.crearSubforos(subForo,usuario));
    }

    @Test
    public void notCrearSubforos(){
        SubForo subForo=new SubForo("Testing",managerSubForos);
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        assertEquals("No se puede crear",false,managerSubForos.crearSubforos(subForo,usuario));
    }

    @Test
    public void encontrarSubforos() {
        SubForo subForo=new SubForo("Testing",managerSubForos);
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        managerSubForos.crearSubforos(subForo,usuario);
        assertTrue(managerSubForos.encontrarSubforos(subForo.getTituloSubForo()));
    }


    @Test
    public void inscripcion() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        managerSubForos.crearSubforos(subForo,usuario);
       assertTrue(managerSubForos.inscripcion(subForo,usuario));
    }

    @Test
    public void notInscripcion(){
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        managerSubForos.crearSubforos(subForo,usuario);
        managerUsuario.desconectar(usuario);
        assertEquals("No se puede inscribir",false,managerSubForos.inscripcion(subForo,usuario));
    }

    @Test
    public void inscrito(){
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        managerSubForos.crearSubforos(subForo,usuario);
        managerSubForos.inscripcion(subForo,usuario);
        assertEquals("Ya esta inscrito",false,managerSubForos.inscripcion(subForo,usuario));

    }

    @Test
    public void guardarInformacionForos(){
        SubForo subForo=new SubForo("Testing",managerSubForos);
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        managerSubForos.crearSubforos(subForo,usuario);
        assertTrue(managerSubForos.guardarInfoForos());
    }

    @Test
    public void cargarInformacionForos(){
        managerSubForos.setListadoDeForos(ManagerSubForos.leerInfoForos());
        assertEquals("test busqueda tras carga",true,managerSubForos.encontrarSubforos("Testing"));
    }

}