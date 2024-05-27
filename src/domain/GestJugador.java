/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;

public class GestJugador {

    private ArrayList<Jugadores> jugadores;

    public GestJugador() {
        jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugadores jugador) {
        jugadores.add(jugador);
        listarJugadores();
    }

    public void listarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
        } else {
            for (Jugadores jugador : jugadores) {
                System.out.println(jugador);
            }
        }

    }

    public boolean eliminarJugador(int id) {
        for (Jugadores jugador : jugadores) {
            if (jugador.getIdJugador() == id) {
                jugadores.remove(jugador);
                return true;
            }
        }
        return false;
    }

    public Jugadores buscarJugador(int id) {
        for (Jugadores jugador : jugadores) {
            if (jugador.getIdJugador() == id) {
                return jugador;
            }
        }
        return null;
    }

    public boolean modificarJugador(int id, String nuevoNombre, String nuevoJuego, int nuevoPuntaje) {
        Jugadores jugador = buscarJugador(id);
        if (jugador != null) {
            jugador.setNombre(nuevoNombre);
            jugador.setJuego(nuevoJuego);
            jugador.setPuntaje(nuevoPuntaje);

            return true;

        }
        return false;

    }


        
}
