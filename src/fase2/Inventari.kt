package fase2

// Dissenyar una classe Inventari que mantingui una llista privada mutable de productes.
// Implementar mètodes per a:
//Registrar un nou producte.
//Consultar tots els productes.
//Actualitzar l'stock o el preu d'un producte donat el seu ID.

class Inventari {
    private val listaProductos = mutableListOf<Producto>()

    fun registrarProducto(producto: Producto) {
        listaProductos.add(producto)
    }

    fun consultarProductos(): List<Producto> {
        return listaProductos.toList()
    }

    fun actualizarStock(id: Int, stock: Double): Boolean {
        val producto = listaProductos.find { it.id == id } ?: return false
        producto.stock = stock
        return true
    }

    fun actualizarPreu(id: Int, preu: Double): Boolean {
        val producto = listaProductos.find { it.id == id } ?: return false
        producto.preu = preu
        return true
    }
}
