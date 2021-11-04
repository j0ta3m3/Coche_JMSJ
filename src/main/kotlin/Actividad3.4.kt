import java.awt.Color

fun main() {

    class Coche(Marca:String,Modelo:String,velocidadMax:Int,color:Color,Velocidad:Int)
    {
        init {
            require(Velocidad>10)
            require(Velocidad<250)
        }
    }
}