package actividad2aistemagestionbiblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Actividad2SistemaGestionBiblioteca {
    public static void main(String[] args) {
        ArrayList<String[]> libros = new ArrayList<>();
        LinkedList<String[]> usuarios = new LinkedList<>();
        Stack<String[]> LibrosPrestados = new Stack<>();
        Queue<String[]> ColadeEspera = new LinkedList<>();
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1000319806 - Jerson Daniel Alonso Martinez");
            System.out.println("=================================");
            System.out.println("      SISTEMA DE BIBLIOTECA      ");
            System.out.println("           Seleccione:           ");
            System.out.println("=================================");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Agregar Usuario");
            System.out.println("3. Prestar Libro");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Consultar Libro");
            System.out.println("6. Consultar Usuario");
            System.out.println("0. Salir");
            System.out.println("=================================");
            
            while (!entrada.hasNextInt()) {
                System.out.println("Invalido, escoga otra opcion");
                entrada.next();
            }
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el ID del libro: ");
                    String IDLibro = entrada.nextLine();
                    boolean duplicadoid = false;
                    for (String[] libro : libros) {
                        if (libro[0].equals(IDLibro)) {
                            duplicadoid = true;
                            break;
                        }
                    }
                    if (duplicadoid) {
                        System.out.println("El ID del libro ya existe");
                    } else {
                        System.out.println("Ingrese el nombre del libro: ");
                        String NombreLibro = entrada.nextLine();
                        System.out.println("Ingrese el autor del libro: ");
                        String Autor = entrada.nextLine();
                        String[] libro = {IDLibro, NombreLibro, Autor};
                        libros.add(libro);
                        System.out.println("Libro agregado");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese su cedula:");
                    while (!entrada.hasNextInt()) {
                        System.out.println("ingrese un numero valido");
                        entrada.next();
                    }
                    int Cedula = entrada.nextInt();
                    entrada.nextLine();
                    System.out.println("Ingrese su nombre:");
                    String Nombre = entrada.nextLine();
                    System.out.println("Ingrese su apellido:");
                    String Apellido = entrada.nextLine();
                    boolean ceduladuplex = false;
                    for (String[] usuario : usuarios) {
                        if (usuario[0].equals(String.valueOf(Cedula))) {
                            ceduladuplex = true;
                            break;
                        }
                    }
                    if (ceduladuplex) {
                        System.out.println("el usuario ya existe");
                    } else {
                        String[] usuario = {String.valueOf(Cedula), Nombre, Apellido};
                        usuarios.add(usuario);
                        System.out.println("Usuario agregado");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el ID del libro que está solicitando:");
                    String idprestamo = entrada.nextLine();
                    System.out.println("Ingrese el ID del usuario que solicita el libro:");
                    int cedulaprestar = entrada.nextInt();
                    entrada.nextLine();

                    boolean usuarioregistrado = false;
                    for (String[] usuario : usuarios) {
                        if (usuario[0].equals(String.valueOf(cedulaprestar))) {
                            usuarioregistrado = true;
                            break;
                        }
                    }

                    if (!usuarioregistrado) {
                        System.out.println("El usuario no existe. Por favor haga el registro.");
                    } else {
                        boolean libroEncontrado = false;
                        for (String[] libro : libros) {
                            if (libro[0].equals(idprestamo)) {
                                LibrosPrestados.push(new String[]{idprestamo, libro[1], libro[2], String.valueOf(cedulaprestar)});
                                libros.remove(libro);
                                libroEncontrado = true;
                                System.out.println("Libro prestado.");
                                break;
                            }
                        }
                        if (!libroEncontrado) {
                            System.out.println("Libro no encontrado. ¿Quiere estar en la cola de espera? (si/no)");
                            String respuesta = entrada.nextLine();
                            if (respuesta.equalsIgnoreCase("si")) {
                                ColadeEspera.add(new String[]{idprestamo, String.valueOf(cedulaprestar)});
                                System.out.println("Agregado a la cola de espera");
                            }
                        }
                    }
                    break;

                case 4:
                    if (!LibrosPrestados.isEmpty()) {
                        String[] libroDevuelto = LibrosPrestados.pop();
                        libros.add(new String[]{libroDevuelto[0], libroDevuelto[1], libroDevuelto[2]});
                        System.out.println("Libro devuelto");
                    } else {
                        System.out.println("No hay libros prestados");
                    }

                    if (!ColadeEspera.isEmpty()) {
                        String[] proximoEnCola = ColadeEspera.poll();
                        System.out.println("El usuario con cédula " + proximoEnCola[1] + " está en cola y se le prestará el libro con el ID: " + proximoEnCola[0]);
                        LibrosPrestados.push(new String[]{proximoEnCola[0], "", "", proximoEnCola[1]}); 
                    }
                    break;

                case 5:
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros");
                    } else {
                        System.out.println("=== Libros disponibles ===");
                        System.out.printf("%-10s %-15s %-30s%n", "ID", "Nombre", "Autor");
                        for (String[] libro : libros) {
                            System.out.printf("%-10s %-15s %-30s%n", libro[0], libro[1], libro[2]);
                        }
                    }
                    break;

                case 6:
                    if (usuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados");
                    } else {
                        System.out.println("=== Usuarios registrados ===");
                        System.out.printf("%-10s %-15s %-20s%n", "Cédula", "Nombre", "Apellido");
                        for (String[] usuario : usuarios) {
                            System.out.printf("%-10s %-15s %-20s%n", usuario[0], usuario[1], usuario[2]);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Salida");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        entrada.close();
    }
}
