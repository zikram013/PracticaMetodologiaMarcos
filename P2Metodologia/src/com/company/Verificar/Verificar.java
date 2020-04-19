package com.company.Verificar;

import com.company.EntradaAbstracta;
import com.company.Entradas.EntradaReal;
import com.company.SubForos.ManagerSubForos;
import com.company.SubForos.SubForo;
import com.company.Users.ManagerUsuario;
import com.company.Users.Usuario;

import java.util.ArrayList;

public class Verificar {

    private ArrayList<EntradaReal>entradasPendienteDeVerificar;
    private Usuario usuario;
    private SubForo foro;
    private ManagerUsuario managerUsuario;
    private ManagerSubForos managerSubForos;

    public Verificar(ManagerUsuario managerUsuario,ManagerSubForos managerSubForos){
        this.entradasPendienteDeVerificar=new ArrayList<EntradaReal>();
        this.managerUsuario=managerUsuario;
        this.managerSubForos=managerSubForos;
        this.foro=new SubForo();
    }

    public ArrayList<EntradaReal> getEntradasPendienteDeVerificar() {
        return entradasPendienteDeVerificar;
    }

    public void setEntradasPendienteDeVerificar(ArrayList<EntradaReal> entradasPendienteDeVerificar) {
        this.entradasPendienteDeVerificar = entradasPendienteDeVerificar;
    }

    public void entradasParaValidar(EntradaAbstracta entradaAbstracta){
        entradasPendienteDeVerificar.add((EntradaReal)entradaAbstracta);
    }

    public void verificacion(String aprobacion,EntradaAbstracta entradaAbstracta,Usuario usuario){
        if(usuario.isConectado() && managerUsuario.encontradoRolAdmin(usuario)){
            if(!entradasPendienteDeVerificar.isEmpty()){
                for(EntradaReal verified: entradasPendienteDeVerificar){
                    if(verified.equals(entradaAbstracta)){
                        if(aprobacion.equals("A")){
                            verified.setValidacion(true);
                            verified.getSubForo().crearEntrada(verified);
                           //eliminar(verified);
                        }else if(aprobacion.equals("D")){
                            verified.setValidacion(true);
                            verified.getCreador().setSancion(true);

                        }
                        //eliminar(verified);

                    }
                }
            }else{
                System.out.println("No hay entradas para verificar");
            }
        }else{
            System.out.println("no tienes permisos de administrador");
        }
    }

    public void mostrarEntradasParaVerificar(Usuario usuario){
        if(managerUsuario.encontradoRolAdmin(usuario)){
            if(!entradasPendienteDeVerificar.isEmpty()){
                for(EntradaReal verifies:entradasPendienteDeVerificar){
                    System.out.println(verifies);
                }
            }else{
                System.out.println("no hay nada que mostrar");
            }
        }else{
            System.out.println("credenciales invalidas");
        }
    }

    public void eliminar(EntradaAbstracta entradaAbstracta){
        if(!entradasPendienteDeVerificar.isEmpty()) {
            if(entradaAbstracta.isValidacion()){
                entradasPendienteDeVerificar.removeIf(er -> er.equals(entradaAbstracta));
            }
        }else{
            System.out.println("no hay entradas para eliminar");
        }
    }
}
