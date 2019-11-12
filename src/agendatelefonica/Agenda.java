package agendatelefonica;

/**
 *
 * @author Francisco
 */
public class Agenda {

    private Contacto[] contactos;

    public Agenda() {
        this.contactos = new Contacto[10];
    }

    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio];
    }

    public void anadirContacto(Contacto contacto) {
        if (existeContacto(contacto)) {
            System.out.println("El contacto con ese nombre ya existe");
        } else if (agendaLlena()) {
            System.out.println("La agenda está llena, no se pueden añadir mas contactos.");
        } else {
            boolean encontrado = false;
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) {
                    contactos[i] = contacto;
                    encontrado = true;
                }
            }
            if (encontrado) {
                System.out.println("Se ha añadido el contacto correctamente.");
            } else {
                System.out.println("No se ha podido añadir el contacto.");
            }
        }
    }

    public void listarContactos() {
        if(huecoLibre() == contactos.length){
            System.out.println("Lista vacía, no hay contactos para mostrar.");
        }
        else{
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) {
                    System.out.println(contactos[i]);
                }
            }
        }
        
    }

    public void buscarPorNombre(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Su telefono es: " + contactos[i].getTelefono());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se ha encontrado el contacto con ese nombre.");
        }
    }

    public boolean existeContacto(Contacto contacto) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contacto.equals(contactos[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean agendaLlena() {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void eliminarContacto(Contacto contacto) {
        boolean encontrado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(contacto)) {
                contactos[i] = null;
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("El contacto se ha eliminado.");
        }
        else{
            System.out.println("El contacto no se ha eliminado.");
        }
    }

    public int huecoLibre() {
        int contador = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contador++;
            }
        }
        return contador;
    }
}
