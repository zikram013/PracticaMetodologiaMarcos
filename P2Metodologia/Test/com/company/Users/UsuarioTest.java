package com.company.Users;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void isSancion() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","alumno");
        usuario.setSancion(true);
        assertEquals("no sancion",true,usuario.isSancion());
    }


    @Test
    public void isConectado() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","alumno");
        usuario.setConectado(true);
        assertEquals("no conectado",true,usuario.isConectado());
    }
}