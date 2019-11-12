package agendatelefonica;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class AgendaTelefonica {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        boolean salir = false;
        int opcion;

        Agenda miAgenda = new Agenda(3);
        String nombre;
        int telefono;
        Contacto contacto;
        while (!salir) {
            System.out.println("1. Añadir contacto.");
            System.out.println("2. Listar contacto.");
            System.out.println("3. Buscar contacto.");
            System.out.println("4. Existe contacto.");
            System.out.println("5. Eliminar contacto.");
            System.out.println("6. Contactos disponibles.");
            System.out.println("7. Agenda llena");
            System.out.println("8. Salir.");
            try {
                System.out.println("Elija una opción.");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Escriba el nombre.");
                        nombre = teclado.next();
                        System.out.println("Escriba el número de telefono");
                        telefono = teclado.nextInt();
                        contacto = new Contacto(nombre, telefono);
                        miAgenda.anadirContacto(contacto);
                        break;
                    case 2:
                        miAgenda.listarContactos();
                        break;
                    case 3:
                        System.out.println("Escriba el nombre.");
                        nombre = teclado.next();
                        miAgenda.buscarPorNombre(nombre);
                        break;
                    case 4:
                        System.out.println("Escriba el nombre.");
                        nombre = teclado.next();
                        contacto = new Contacto(nombre, 0);
                        if (miAgenda.existeContacto(contacto)) {
                            System.out.println("El contacto si existe en la agenda.");
                        } else {
                            System.out.println("El contacto no existe en la agenda.");
                        }
                        break;
                    case 5:
                        System.out.println("Escriba el nombre.");
                        nombre = teclado.next();
                        contacto = new Contacto(nombre, 0);
                        miAgenda.eliminarContacto(contacto);
                        break;
                    case 6:
                        System.out.println("Hay " + miAgenda.huecoLibre() + " espacios libres para guardar contactos.");
                        break;
                    case 7:
                        if (miAgenda.agendaLlena()) {
                            System.out.println("La agenda está llena, no se pueden añadir mas contactos.");
                        } else {
                            System.out.println("Aún se pueden añadir contactos.");
                        }
                        break;
                    case 8:
                        salir = true;
                        break;
                    default:
                        System.out.println("Digite un número entre 1 y 8.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe digitar un número");
                teclado.next();
            }
        }
    }
}
