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
            Stack<String []> LibrosPrestados = new Stack<>();
            Queue <String []> ColadeEspera = new LinkedList<>();
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
                System.out.println("Seleccione una Opcion: ");
                }
                    opcion = entrada.nextInt();
                    entrada.nextLine();
                switch(opcion){
                    case 1:
                        System.out.println("Ingrese el ID del libro: ");
                        String IDLibro = entrada.nextLine();
                            boolean duplicadoid =  false;
                        for (String[] libro : libros) {
                                                    if(libro[0].equals(IDLibro)) {
                                                        duplicadoid = true;
                                                        break;
                                                    }
                                                }
                        if (duplicadoid == true) {
                            System.out.println("El ID del libro ya existe");
                        }else{
                            {
                        System.out.println("Ingrese el nombre del libro: ");
                            String NombreLibro = entrada.nextLine();
                        System.out.println("Ingrese el autor del libro: ");
                            String Autor = entrada.nextLine();
                        String [] libro = {IDLibro, NombreLibro, Autor};
                            libros.add(libro);
                        System.out.println("Libro agregado");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese su cedula:");
                            while (!entrada.hasNextInt()) {
                        System.out.println("ingrese un numero valido");
                            entrada.next();
                        System.out.println("Ingrese los numeros de su numero de identificación");
                        }
                        int Cedula = entrada.nextInt();
                            entrada.nextLine();
                        System.out.println("Ingrese su nombre:");
                            String Nombre = entrada.nextLine();
                        System.out.println("Ingrese su apellido");
                            String Apellido = entrada.nextLine();
                            boolean ceduladuplex =  false;
                        for (String[] usuario : usuarios) {
                                                    if(usuario[0].equals(String.valueOf(Cedula))) {
                                                        ceduladuplex = true;
                                                        break;
                                                    }
                                                }
                        if (ceduladuplex == true) {
                            System.out.println("el usuario ya existe");
                        }else{
                            String [] usuario = {String.valueOf(Cedula), Nombre, Apellido};
                                                        usuarios.add(usuario);
                            System.out.println("Usuario agregado");
                        }
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 0:
                        default:
                        System.out.println("Opcion no valida");
        }
        while (opcion != 6);
    }
}
}