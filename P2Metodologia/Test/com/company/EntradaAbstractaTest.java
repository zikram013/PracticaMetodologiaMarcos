package com.company;

import com.company.Comentarios.Comentarios;
import com.company.Entradas.Ejercicios;
import com.company.Entradas.EntradaReal;
import com.company.SubForos.ManagerSubForos;
import com.company.SubForos.SubForo;
import com.company.Users.ManagerUsuario;
import com.company.Users.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntradaAbstractaTest {
    ManagerUsuario managerUsuario=new ManagerUsuario();
    ManagerSubForos managerSubForos=new ManagerSubForos(managerUsuario);

    @Test
    public void crearComentario() {
        Usuario usuario=new Usuario("prueba","prueba","prueba","prueba","prueba","profesor");
        managerUsuario.crearUsuario(usuario);
        managerUsuario.iniciarSesion(usuario.getCorreo(),usuario.getContrasena());
        SubForo subForo=new SubForo("Testing",managerSubForos);
        managerSubForos.crearSubforos(subForo,usuario);
        EntradaReal entradaReal=new EntradaReal("Testeo Entrada",subForo,usuario);
        entradaReal.agregar(new Ejercicios(entradaReal.getTituloEntrada(),subForo,usuario,"Ejercicio Testing"));
        subForo.crearEntrada(entradaReal);
        Comentarios comentarios=new Comentarios("Haciendo test con junit");
        assertTrue(entradaReal.crearComentario(comentarios));
    }
}