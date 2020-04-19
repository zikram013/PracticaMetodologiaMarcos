package com.company.Utilidades;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Escaner {

    public Escaner(){

    }

    public int escanerInt()throws IOException, InputMismatchException{
        int entero=0;
        Scanner sc=new Scanner(System.in);
        try{
            entero=sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Debes introducir una opcion correcta");
        }
        return entero;

    }

    public String escanerString()throws IOException{
        Scanner sc = new Scanner(System.in);
        String cadena= sc.nextLine();
        if(cadena==null){
            throw new IOException("La cadena no puede ser nula");
        }
        return  cadena;
    }
}
