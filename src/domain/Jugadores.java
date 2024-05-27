package domain;


public class Jugadores {

    private final int idJugador;
    private String nombre;
    private String juego;
    private int puntaje;
    private static int contadorJugadores;

    private Jugadores() {                                //Se va a encarga de inicializar la variable idJugador y asignarle un nuevo valor                                                             
        this.idJugador = ++Jugadores.contadorJugadores;
    }

    public Jugadores(String nombre, String juego, int puntaje) {
        this();                                                   //mandamos a llamar el constructor privado de la clase con esto se inicializa la variable de idJugador
        this.nombre = nombre;
        this.juego = juego;
        this.puntaje = puntaje;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Jugadores{" + "idJugador=" + idJugador + ", nombre=" + nombre + ", juego=" + juego + ", puntaje=" + puntaje + '}';
    }

}
