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
        assertTrue(managerSubForos.crearSubforos(subForo,usuario));
    }

    @Test
    public void encontrarSubforos() {
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerSubForos.getListadoDeForos().add(subForo);
        assertTrue(managerSubForos.encontrarSubforos("Testing"));
    }


    @Test
    public void inscripcion() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
       assertTrue(managerSubForos.inscripcion(subForo,usuario));
    }
}