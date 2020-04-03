package com.company;

import javax.xml.transform.Source;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class InterfazUsuario {

    private ManagerSubForos manager;
    private ManagerUsuario managerUsuario;
    private ArrayList<Usuario>usuario;

    private Escaner escaner;
    private Entrada entrada;

    public InterfazUsuario(ManagerSubForos manager,ManagerUsuario managerUsuario){
        this.manager=manager;
        this.managerUsuario=managerUsuario;
        escaner=new Escaner();
        this.usuario=new ArrayList<>();

        this.entrada=new Entrada();
    }

    public ArrayList<Usuario> getUsuario() {
        return usuario;
    }

    public void inicializarMenu(Usuario usuario){
        try{
            int opcion=1;
            do{
                mostrarMenu();
                opcion=escaner.escanerInt();
                switch (opcion){
                    case 1:
                        mostrarSubforo();
                        break;
                    case 2:
                        crearSubforosInterfaz();
                        break;
                    case 3:
                        crearUsuario();
                        break;
                    case 4:
                            mostrarUsuario();
                            break;
                    case 5:
                        crearEntrada();
                        break;
                    case 6:
                        mostrarEntradas();
                        break;
                    case 7:
                        editarEntrada();
                        break;
                    case 8:
                        agregarComentario();
                        break;
                    case 9:
                        mostrarComentario();
                        break;
                    case 10:
                        votarEntrada();
                        break;
                    case 11:
                        suscripcionesForos();
                        break;
                    case 12:
                        mostrarSuscripciones();
                        break;
                }
            }while(opcion !=0);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }



    public void mostrarMenu(){
        System.out.println("0-Salir");
        System.out.println("1-mostrarSubforos");//hecho
        System.out.println("2-crear subForo");//hecho
        System.out.println("3-Crear Usuario");//hecho
        System.out.println("4-Mostrar usuario");//hecho
        System.out.println("5-Crear Entrada");//falta solo la verificacion
        System.out.println("6-Mostrar entradas del subforo");//hecho
        System.out.println("7-Editar la entrada");//Edita solo el propietario,hecho
        System.out.println("8-Publicar comentario");//publica y muestra,queda valorar comentario
        System.out.println("9-Ver comentarios");//Los muestra,hecho
        System.out.println("10-Votar entrada");//Almacena las votaciones y quien las ha hecho para que no vuelva a votar
        System.out.println("11-Suscripcion a un foro");//Hecho
        System.out.println("12-Mostrar suscripciones");//hecho
    }

    public void mostrarSubforo(){

        System.out.println("Mostrar SubForos");
        manager.mostrarSubForo();
    }

    private void crearSubforosInterfaz() throws IOException {

        String correo=null;
        String password=null;
        String tituloDelForo=null;
        System.out.println("Introduzca el correo");
        correo=escaner.escanerString();
        System.out.println("Introduzca la contraseña");
        password=escaner.escanerString();

   ;
          if(managerUsuario.encontradoRolProfesor(correo,password)){
              System.out.println("Introduzca el nombre del foro");
              tituloDelForo=escaner.escanerString();
              SubForo subForo=new SubForo(tituloDelForo,manager);
              if(tituloDelForo.equals("")){
                  System.out.println("El nombre del foro no puede estar vacio");
              }else{
                  manager.crearSubforos(subForo);
                  System.out.println("Sub Foro creado satisfactoriamente");
              }
          }else {
              System.out.println("no se puede crear");
          }

    }


    private void crearUsuario() throws IOException {
        //Pedimos todos los datos al usuario
        System.out.println("Introduzca el nombre");
        String nombre = escaner.escanerString();
        System.out.println("Introduzca los apellidos");
        String apellidos = escaner.escanerString();
        System.out.println("Introduzca el nick");
        String nick = escaner.escanerString();
        System.out.println("Introduzca el correo");
        String correo = escaner.escanerString();
        System.out.println("Introduzca la contraseña");
        String contraseña = escaner.escanerString();
        System.out.println("Introduzca el rol");
        String rol = escaner.escanerString();


        if (!(rol.equals("profesor") || rol.equals("Profesor") || rol.equals("usuario") || rol.equals("Usuario"))) {
            System.out.println("El rol seleccionado no es valido");
        }

        if (managerUsuario.crearUsuario(new Usuario(nombre, apellidos, nick, correo, contraseña, rol,managerUsuario))) {
            System.out.println("Usuario creado satisfactoriamente");
        } else {
            System.out.println("No se ha podido crear");
        }
    }

    private void mostrarUsuario() {
        System.out.println("Mostrar Usuarios");
        managerUsuario.listarUsuarios();
    }

    private void crearEntrada() throws IOException {
        String correo;
        String password;
        String tituloEntrada;
        String textoEntrada;
        System.out.println("Seleccione el subforo donde crear la entrada");
        String foro=escaner.escanerString();

        if(manager.encontrarSubforos(foro)){
            SubForo forosito= manager.getSubforoEncontrado(foro);
            if(forosito!=null){
                System.out.println("Dime el correo");
                correo=escaner.escanerString();
                System.out.println("Dime la contraseña");
                password=escaner.escanerString();
                Usuario usuario = managerUsuario.usuarioExisteSistema(correo, password);
                if(usuario!=null) {
                    System.out.println("Escriba T para texto plano(alumno y profesor), E para Ejercicios(profesor) o S para encuestas(profesor)");
                    String letra;
                    try {
                        do {
                            letra = escaner.escanerString();
                            switch (letra) {
                                case "T":
                                    //crear tareas
                                        System.out.println("Di el titulo de la entrada");
                                        tituloEntrada = escaner.escanerString();
                                        System.out.println("Escriba el texto");
                                        textoEntrada = escaner.escanerString();
                                        if (forosito.crearEntrada(new Entrada(tituloEntrada, textoEntrada, forosito, usuario))) {
                                            System.out.println("Creada entrada correctamente");
                                        } else {
                                            System.out.println("Entrada no creada");
                                        }
                                    break;
                                case "E":
                                    //crear ejercicios
                                    if(managerUsuario.encontradoRolProfesor(correo,password)){
                                        System.out.println("Di el titulo de la entrada");
                                        tituloEntrada = escaner.escanerString();
                                        System.out.println("Escriba el texto");
                                        textoEntrada = escaner.escanerString();
                                        if (forosito.crearEntrada(new Entrada(tituloEntrada, textoEntrada, forosito, usuario))) {
                                            System.out.println("Creada entrada correctamente");
                                        } else {
                                            System.out.println("Entrada no creada");
                                        }
                                    }else{
                                        System.out.println("El rol no se corresponde");
                                    }
                                    break;
                                case "S":
                                    //crear encuestas
                                    System.out.println("Dime el correo");
                                    correo = escaner.escanerString();
                                    System.out.println("Dime la contraseña");
                                    password = escaner.escanerString();
                                    managerUsuario.encontradoRolProfesor(correo, password);
                                    break;
                            }
                        } while (letra.equals("F"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("Usuario no existente");
                }
            }else{
                System.out.println("SubForo no encontrado");
            }
        }else{
            System.out.println("SubForo no encontrado");
        }
    }


    private void mostrarEntradas() throws IOException {
        System.out.println("Dime el foro que desea mirar");
        String tituloForo=escaner.escanerString();
            SubForo forosito= manager.getSubforoEncontrado(tituloForo);
            if(forosito!=null){
                System.out.println("Mostrar entrada");
                forosito.listarEntrada(tituloForo);
            }else{
                System.out.printf("no encontrado");
        }
    }

    private void agregarComentario() throws IOException {
        System.out.println("Dime el foro");
        String tituloForo=escaner.escanerString();
        if(manager.encontrarSubforos(tituloForo)){
            SubForo forosito=manager.getSubforoEncontrado(tituloForo);
            if(forosito!=null){
                forosito.listarEntrada(tituloForo);
                System.out.println("Dime la entrada");
                String tituloDeLaEntrada=escaner.escanerString();
                Entrada entrada=forosito.getEntradaEncontrada(tituloDeLaEntrada);
                if(entrada!=null){
                    System.out.println("Dime el correo");
                    String correo=escaner.escanerString();
                    System.out.println("Dime la contraseña");
                    String password=escaner.escanerString();
                    if(managerUsuario.usuarioRegistrado(correo,password)){
                        System.out.println("Introduzca su comentario");
                        String comentario=escaner.escanerString();
                        entrada.crearComentario(new Comentarios(comentario));
                    }else{
                        System.out.println("No se ha podido crear");
                    }
                }
            }else{
                System.out.println("Foro no existente");
            }
        }
    }

    private void editarEntrada() throws IOException {
        System.out.println("Dime el foro");
        String tituloForo=escaner.escanerString();
        if(manager.encontrarSubforos(tituloForo)){
            SubForo forosito=manager.getSubforoEncontrado(tituloForo);
            if(forosito!=null){
                forosito.listarEntrada(tituloForo);
                System.out.println("Dime la entrada");
                String tituloDeLaEntrada=escaner.escanerString();
                Entrada entrada=forosito.getEntradaEncontrada(tituloDeLaEntrada);
                if(entrada!=null){
                    System.out.println("Dime el correo");
                    String correo=escaner.escanerString();
                    System.out.println("Dime la contraseña");
                    String password=escaner.escanerString();
                    Usuario usuario=managerUsuario.usuarioExisteSistema(correo,password);
                    if(usuario!=null){
                        if(entrada.getCreador().equals(usuario)){
                            System.out.println("edite la entrada");
                            String edicion=escaner.escanerString();
                            entrada.setTextoEntrada(edicion);
                        }else{
                            System.out.println("Esta entrada no es suya");
                        }
                    }
                }else{
                    System.out.println("Entrada no existe");
                }
            }else{
                System.out.println("Foro no existente");
            }
        }
    }


    public void mostrarComentario() throws IOException {
        System.out.println("Introduzca el foro");
        String tituloForo=escaner.escanerString();
        SubForo forosito=manager.getSubforoEncontrado(tituloForo);
        if(forosito!=null){
            forosito.listarEntrada(tituloForo);
            System.out.println("Introduzca la entrada");
            String nombreEntrada=escaner.escanerString();
            for(Entrada entry:forosito.getEntry()){
                if(nombreEntrada.equals(entry.getTituloEntrada())){
                    entry.mostrarComentarios(nombreEntrada);
                }

            }

        }
    }

    public void votarEntrada()throws IOException{
        String letra;
        boolean encontrado=false;
        System.out.println("Dime el foro que desea mirar");
        String tituloForo=escaner.escanerString();
        SubForo forosito= manager.getSubforoEncontrado(tituloForo);
        if(forosito!=null) {
            System.out.println("Mostrar entrada");
            forosito.listarEntrada(tituloForo);
            System.out.println("Dime el correo");
            String correo = escaner.escanerString();
            System.out.println("Dime la contraseña");
            String password = escaner.escanerString();
            Usuario usuario = managerUsuario.usuarioExisteSistema(correo, password);
            if (usuario != null) {
                System.out.println("Introduzca la entrada");
                String nombreEntrada = escaner.escanerString();
                for (Entrada entry : forosito.getEntry()) {
                    if (nombreEntrada.equals(entry.getTituloEntrada()) && (!(entrada.getCreador().equals(usuario)))) {
                        forosito.votarEntrada(usuario, nombreEntrada, tituloForo);
                    }
                }
            } else {
                System.out.println("no encontrado");
            }
        }
    }

    public void suscripcionesForos() throws IOException{
        System.out.println("Mostrando subforos");
        manager.mostrarSubForo();
        System.out.println("Elija la entrada a la que quiere suscribirse");
        String tituloForo=escaner.escanerString();
        SubForo forosito=manager.getSubforoEncontrado(tituloForo);
        if(forosito!=null){
            System.out.println("Dime el correo");
            String correo = escaner.escanerString();
            System.out.println("Dime la contraseña");
            String password = escaner.escanerString();
            if(managerUsuario.usuarioRegistrado(correo,password)){
                Usuario usuario=managerUsuario.usuarioExisteSistema(correo,password);
                if(usuario!=null){
                    managerUsuario.inscripcion(forosito,usuario);
                }else{
                    System.out.println("No existe o credenciales invalidas");
                }
            }
        }else{
            System.out.println("el subforo no existe");
        }

    }

    public void mostrarSuscripciones()throws IOException{
        System.out.println("Dime el correo");
        String correo = escaner.escanerString();
        System.out.println("Dime la contraseña");
        String password = escaner.escanerString();
        System.out.println("Mostrando suscripciones");
        managerUsuario.mostrarLasSucripciones(correo,password);

    }
}
