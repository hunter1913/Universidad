package domain;

import java.util.Scanner;

public class Menu {

    private static GestJugador Gtjugador = new GestJugador();
    static int opcion = -1;

    public static void main(String[] args) {

        System.out.println(
                "Seleccione una opcion: "
                + "\n1. Agregar Jugador"
                + "\n2. Buscar Jugador"
                + "\n3. Editar Jugador"
                + "\n4. Eliminar Jugador"
                + "\n5. Listar Jugadores"
                + "\n6. Salir");
        Scanner scanner = new Scanner(System.in);
        do {
            opcion = scanner.nextInt();

            scanner.nextLine();
            switch (opcion) {

                case 1:
                    agregarJugador();
                    mostrarMenu();
                    break;
                case 2:
                    buscarJugador();
                    mostrarMenu();
                case 3:
                    modificarJugador();
                    mostrarMenu();
                    break;

                case 4:
                    eliminarJugador();
                    mostrarMenu();
                    break;

                case 5:
                    listarJugadores();
                    mostrarMenu();
                    break;
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("  Menu de Jugadores  ");
        System.out.println("1. Agregar un jugador");
        System.out.println("2. Buscar un jugador");
        System.out.println("3. Editar un jugador");
        System.out.println("4. Eliminar un jugador");
        System.out.println("5. Listar Jugadores");
        System.out.println("6. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    private static void agregarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Nombre del juego: ");
        String juego = scanner.nextLine();
        System.out.print("Posicion del jugador: ");
        int puntaje = scanner.nextInt();

        Jugadores jugador = new Jugadores(nombre, juego, puntaje);
        Gtjugador.agregarJugador(jugador);
        System.out.println("Jugador agregado exitosamente.");
    }

    private static void buscarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del jugador a buscar: ");
        int id = scanner.nextInt();
        Jugadores jugador = Gtjugador.buscarJugador(id);
        if (jugador != null) {
            System.out.println("Jugador encontrado: " + jugador);
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

  private static void eliminarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Jugadores jugador = Gtjugador.buscarJugador(id);
        if (jugador != null) {
            System.out.println("Jugador encontrado: " + jugador);
            System.out.print("¿Esta seguro que desea eliminar este jugador? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                if (Gtjugador.eliminarJugador(id)) {
                    System.out.println("Jugador eliminado exitosamente.");
                } else {
                    System.out.println("Error al eliminar el jugador.");
                }
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void modificarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID del jugador a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Nuevo nombre del jugador: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Nueva juego del jugador: ");
        String nuevoJuego = scanner.nextLine();

        System.out.print("Nueva posicion del jugador: ");
        int nuevoPuntaje = scanner.nextInt();

        System.out.println("Desea modificar los datos del jugador Y o N?  ");

        {

            if (Gtjugador.modificarJugador(id, nuevoNombre, nuevoJuego, nuevoPuntaje)) {
                System.out.println("Jugador modificado exitosamente.");
            } else {
                System.out.println("Jugador no encontrado.");
            }

        }

    }

    private static void listarJugadores() {
        Gtjugador.listarJugadores();
    }
}
