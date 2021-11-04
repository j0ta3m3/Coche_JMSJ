import java.awt.Color
import java.lang.NumberFormatException

fun main() {
    var kia = Coche("kia", "rio", "blanco", 45.0, 250, 60, true, 5, 10,0.5)
    var ford = Coche("Ford","Fiesta","Azul",80.0,240,78,false,3,7,0.8)


}

class Coche(
    var Marca: String,
    var Modelo: String,
    var Color: String,
    var tanque: Double,
    var velocidadMax: Int,
    var Velocidad: Int,
    var Estado: Boolean,
    var MarchaActual: Int,
    var variacionVelocidad: Int,
    var factorGasto: Double
) {


    init {
        require(Marca.trim() != null)
    }

    init {
        require(Velocidad > 10)
        require(Velocidad < 250)
    }

    //funciones


    fun encender(): Boolean {
        if (Estado == true && MarchaActual > 0 && tanque > 50) {
            println("El coche está encendido")
            return true
        } else {
            println("Coche apagado , no puede encender")
        }
        return false
    }

    fun apagar() {
        if (Estado == false && MarchaActual == 0 && tanque == 0.0) {
            println("el coche está apagado")
        } else {
            Estado = false && MarchaActual == 0
            parar()
            println("el coche se ha apagado")


        }
    }

    fun iniciar() {
        if (
            encender() == true
        ) acelerar()


    }

    fun parar():Boolean {
        while (Velocidad > 1){frenar()}
        MarchaActual = 0
        return true
    }

    fun acelerar() {
        if (tanque > 50) {
            gasto()
        } else {
            println("No tiene gasolina suficiente")
            parar()
        }
        require(Velocidad < velocidadMax)
    }

    fun gasto() {
        when (MarchaActual) {
            1 -> tanque = tanque - 5 * factorGasto
            2 -> tanque = tanque - 4 * factorGasto
            3 -> tanque = tanque - 3 * factorGasto
            4 -> tanque = tanque - 2 * factorGasto
            5 -> tanque = tanque - 1 * factorGasto

        }
    }

    fun frenar() {
        Velocidad = Velocidad - variacionVelocidad
        gasto()

    }

    fun incrementaMarcha() {
        MarchaActual + 1
    }

    fun decrementaMarcha() {
        MarchaActual - 1
    }

    fun llenarTanque() {
        tanque = tanque + 50
    }

    companion object{
  fun comparaCoches(coche1:Coche,coche2:Coche):Boolean{

        if (coche1.Velocidad > coche2.Velocidad){
          return true
            }
      return false
  try {
      coche1.Velocidad != coche2.Velocidad
  } catch (e: NumberFormatException) {false}
  }
    }



}


