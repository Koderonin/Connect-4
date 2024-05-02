import org.fusesource.jansi.Ansi

class Tablero {

    private var tablero: Array<Array<Char>> = Array(8) { Array(10) { '-' } }

    fun colocarFicha(ficha: Char): Boolean {
        println("Introduzca columna:")
        var columna: Int? = readln().toIntOrNull()
        var columnaOK: Int = 0
        var isValid: Boolean = false
        while(!isValid){
            // comprobar que el valor introducido es un número
            if (columna == null) {
                println("El valor introducido no es numérico (1-10). Introduzca un valor válido:")
                columna = readln().toIntOrNull()
                continue
            }
            // comprobar que la columna introducida es un número entre 1 y 10
            if (columna !in 1..10) {
                println("El valor introducido no se encuentra en el rango (1-10). Introduzca un valor válido:")
                columna = readln().toIntOrNull()
                continue
            }
            // comprobar que la columna no este llena
            if(tablero[0][columna - 1] != '-'){
                println("La columna ya esta llena. Introduzca otro valor:")
                columna = readln().toIntOrNull()
                continue
            }
            isValid = true
            columnaOK = columna - 1
        }
        var y: Int = 0
        // coloco la ficha
        for (j in 7 downTo 0) {
            if (tablero[j][columnaOK] == '-') {
                tablero[j][columnaOK] = ficha
                y = j
                break
            }
        }
        return comprobarVictoria(columnaOK, y, ficha)
    }

    private fun comprobarVictoria(x: Int, y: Int, ficha: Char): Boolean {
        var victoria: Boolean = false
        var posX: Int = x
        var posY: Int = y
        var pos0: Char = ' '
        var pos1: Char = ' '
        var pos2: Char = ' '
        var pos3: Char = ' '

        // comprobar filas
        for (i in -3..0) {
            posX = x + i
/*            pos0 = tablero[y][posX]
            pos1 = tablero[y][posX + 1]
            pos2 = tablero[y][posX + 2]
            pos3 = tablero[y][posX + 3] */
            try {
                if (tablero[y][posX] == ficha && tablero[y][posX + 1] == ficha && tablero[y][posX + 2] == ficha && tablero[y][posX + 3] == ficha) {
                    victoria = true
                    break
                }
            } catch (e: Exception) {
                // nada
            }
        }
        // comprobar columnas
        for (i in -3..0) {
            posY = y + i
            try {
                if (tablero[posY][x] == ficha && tablero[posY + 1][x] == ficha && tablero[posY + 2][x] == ficha && tablero[posY + 3][x] == ficha) {
                    victoria = true
                    break
                }
            } catch (e: Exception) {
                // nada, es solo pa que no pete
            }
        }
        // comprobar diagonal /
        for (i in -3..0) {
            posX = x + i
            posY = y + i
            try {
                if (tablero[posY][posX] == ficha && tablero[posY + 1][posX + 1] == ficha && tablero[posY + 2][posX + 2] == ficha && tablero[posY + 3][posX + 3] == ficha) {
                    victoria = true
                    break
                }
            } catch (e: Exception) {
                // nada, es solo pa que no pete
            }
        }
        // comprobar diagonal \
        for (i in -3..0) {
            posX = x - i
            posY = y + i
            try {
                if (tablero[posY][posX] == ficha && tablero[posY + 1][posX - 1] == ficha && tablero[posY + 2][posX - 2] == ficha && tablero[posY + 3][posX - 3] == ficha) {
                    victoria = true
                    break
                }
            } catch (e: Exception) {
                // nada, es solo pa que no pete
            }
        }
        return victoria
    }

    fun mostrarTablero() {
        for (i in 0..7) {
            for (j in 0..9) {
                if (tablero[i][j] == 'x') {
                    print(Ansi.ansi().fg(Ansi.Color.BLUE).a(tablero[i][j]).reset().toString() + " ")
                }
                if (tablero[i][j] == 'o') {
                    print(Ansi.ansi().fg(Ansi.Color.RED).a(tablero[i][j]).reset().toString() + " ")
                }
                if (tablero[i][j] == '-') {
                    print(tablero[i][j] + " ")
                }
            }
            println()
        }
    }
}