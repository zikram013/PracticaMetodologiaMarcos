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
    @Test
    public void verificacion() {
        Verificar verificar=new Verificar(managerUsuario,managerSubForos);
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        Usuario usuarioAdmin=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        SubForo subForo=new SubForo("Testing",managerSubForos);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),subForo,usuario,"Ejercicio Testing"));
       entradaReal.setValidacion(true);
       usuario.setSancion(false);
        assertEquals("aprobado",true,entradaReal.isValidacion());
        assertEquals("sin sancion",false,usuario.isSancion());

    }
}