fun main() {

    class Coche(Marca:String)
    {
        init {
            require(Marca.trim()!=null)
        }
    }
}