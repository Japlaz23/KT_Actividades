package fase2

data class Producto(
    val id: Int,
    val nombre: String,
    var preu: Double,
    var stock: Double,
    val categoria: Categoria
)
