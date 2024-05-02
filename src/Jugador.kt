class Jugador(private var nombre: String, private var ficha: Char) {
/*    private var nombre: String = ""
    private var ficha: Char = ' ' */
    private var turno: Boolean = false
    private var victorias: Int = 0

    fun setNombre(nombre: String, ficha: Char) {
        this.nombre = nombre
    }

    fun setFicha(ficha: Char) {
        this.ficha = ficha
    }

    fun setTurno(turno: Boolean) {
        this.turno = turno
    }

    fun setVictorias(victorias: Int) {
        this.victorias = victorias
    }

    fun getNombre(): String {
        return this.nombre
    }

    fun getFicha(): Char {
        return this.ficha
    }

    fun getTurno(): Boolean {
        return this.turno
    }

    fun getVictorias(): Int {
        return this.victorias
    }

    fun elegirColumna() {


    }
}