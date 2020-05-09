package com.company.SubForos;

import com.company.Entradas.Ejercicios;
import com.company.Entradas.EntradaReal;
import com.company.Users.ManagerUsuario;
import com.company.Users.Usuario;
import com.company.Verificar.Verificar;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubForoTest {
    ManagerUsuario managerUsuario=new ManagerUsuario();
    ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);
    Verificar verificar=new Verificar(managerUsuario,managerSubForos);

    @Test
    public void crearEntrada() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerSubForos.crearSubforos(subForo,usuario);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),subForo,usuario,"Ejercicio Testing"));
        assertTrue(subForo.crearEntrada(entradaReal));
    }

    @Test
    public void votarEntradaPositiva() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerSubForos.crearSubforos(subForo,usuario);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),subForo,usuario,"Ejercicio Testing"));
        subForo.crearEntrada(entradaReal);
       subForo.votarEntrada(usuario,entradaReal.getTituloEntrada(),subForo.getTituloSubForo(),"P");
        assertEquals("Voto positivo",1,entradaReal.getValoracionPositiva());
    }

    @Test
    public void VotarEntradaNegativa(){
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerSubForos.crearSubforos(subForo,usuario);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),subForo,usuario,"Ejercicio Testing"));
        subForo.crearEntrada(entradaReal);
        subForo.votarEntrada(usuario,entradaReal.getTituloEntrada(),subForo.getTituloSubForo(),"N");
        assertEquals("Voto Negativo",1,entradaReal.getValoracionNegativa());

    }
}