import org.fusesource.jansi.AnsiConsole

fun main() {
    System.setProperty("jansi.passthrough", "true")
    AnsiConsole.systemInstall()

    var option = 1
    println("Bienvenido al juego de 4 en raya!")
    while (option != 0) {
        option = menu()
        when (option) {
            1 -> {
                val partida = Partida()
                partida.iniciarPartida()
            }
            2 -> {
                Partida.verEstadisticas()
            }
            0 -> println("Hasta pronto!")
        }
    }
}

fun menu() : Int {
    println("¿Qué desea hacer?\n" +
            "1. Jugar\n" +
            "2. Ver estadísticas\n" +
            "0. Salir")

    try {
        when(readln().toInt()) {
            1 -> return 1
            2 -> return 2
            0 -> return 0
            else -> println("Opción no valida. Por favor, introduzca una de las opciones dadas")
        }
    } catch (e: NumberFormatException) {
        println("El input no ha sido numérico. Por favor, introduzca una de las opciones dadas")
    }
    return menu()
}
