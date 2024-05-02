import java.util.Collections

class Partida {
    private lateinit var tablero: Tablero
    private lateinit var jugador1: Jugador
    private lateinit var jugador2: Jugador
    //private var jugadores: ArrayList<Jugador> = ArrayList()

    fun iniciarPartida() {
        println("Iniciando partida")
        println("Por favor, introduzca nombre de jugador 1: (ficha 'x')")
        val nombre1: String = readLine().toString()
        println("Por favor, introduzca nombre de jugador 2: (ficha 'o')")
        val nombre2: String = readLine().toString()
        var checkP1: Boolean = false
        var checkP2: Boolean = false
        for (i in jugadores){
            if(!checkP1 && i.getNombre() == nombre1){
                jugador1 = i
                jugador1.setFicha('x')
                checkP1 = true
            }
            if(!checkP2 && i.getNombre() == nombre2){
                jugador2 = i
                jugador2.setFicha('o')
                checkP2 = true
            }
            if (checkP1 && checkP2){
                break
            }
        }
        if(!checkP1){
            jugador1 = Jugador(nombre1, 'x')
            jugadores.add(jugador1)
        }
        if(!checkP2){
            jugador2 = Jugador(nombre2, 'o')
            jugadores.add(jugador2)
        }
        tablero = Tablero()
        println("Partida iniciada")
        jugar()
    }

    private fun jugar() {
        var partidaAcabada: Boolean = false
        var jugadorActual: Jugador;
        jugadorActual = when ((0..1).random()) {
            0 -> jugador1
            else -> jugador2
        }
        tablero.mostrarTablero()
        var turno: Int = 0
        while (turno < 80){
            jugadorActual = cambioTurno(jugadorActual)
            println("Turno de ${jugadorActual.getNombre()} (${jugadorActual.getFicha()})")
            partidaAcabada = tablero.colocarFicha(jugadorActual.getFicha())
            tablero.mostrarTablero()
            if (partidaAcabada) {
                println("Ha ganado ${jugadorActual.getNombre()}!")
                jugadorActual.setVictorias(jugadorActual.getVictorias() + 1)
                break
            }
            turno++
        }
        if (!partidaAcabada) println("Partida terminada, han sido tablas")
    }

    private fun cambioTurno(jugadorActual: Jugador): Jugador {
        var nextPlayer = jugadorActual
        if (jugadorActual.getFicha() == 'x') {
            nextPlayer = jugador2
        }
        if (jugadorActual.getFicha() == 'o') {
            nextPlayer = jugador1
        }
        return nextPlayer
    }

    companion object {
        private var jugadores: ArrayList<Jugador> = ArrayList()

        fun verEstadisticas() {
            jugadores.sortWith(Comparator<Jugador> { o1, o2 -> o1.getVictorias().compareTo(o2.getVictorias()) }.reversed())
            for (i in jugadores){
                println("${i.getNombre()} ha ganado ${i.getVictorias()} veces")
            }
        }
    }
}