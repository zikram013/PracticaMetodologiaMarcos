package com.company.SubForos;

import com.company.Entradas.EntradaReal;
import com.company.Users.ManagerUsuario;
import com.company.Users.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubForoTest {
    ManagerUsuario managerUsuario=new ManagerUsuario();
    ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);

    @Test
    public void crearEntrada() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        assertTrue(subForo.getEntry().add(entradaReal));
    }

    @Test
    public void votarEntradaPositiva() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.setValoracionPositiva(1);
        assertEquals("Voto positivo",1,entradaReal.getValoracionPositiva());
    }

    @Test
    public void VotarEntradaNegativa(){
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.setValoracionNegativa(1);
        assertEquals("Voto positivo",1,entradaReal.getValoracionNegativa());

    }
}