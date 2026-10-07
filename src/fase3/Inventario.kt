package fase3

// Dissenyar una classe Inventari que mantingui una llista privada mutable de productes.
// Implementar mètodes per a:

//Consultar tots els productes.
//Actualitzar l'stock o el preu d'un producte donat el seu ID.

class Inventario {

    private val listaProd = mutableListOf<Producto>()
    //Registrar un nou producte.
    fun registrarProd(producto: Producto){
        listaProd.add(producto)
    }
    //Consultar tots els productes.
    fun consultarProd(): List<Producto> {
        return  listaProd.toList()
    }

    //Actualitzar l'stock o el preu d'un producte donat el seu ID.

    fun actualizarProd(id: Int, nuevoStock: Int? = null, nuevoPrecio: Double? = null): Boolean {
        val producto = listaProd.find { it.id == id } ?: return false // verifica si el id que se proporciona es el mismo que el producto que se busca

        if (nuevoPrecio != null) {
            producto.precio = nuevoPrecio
        }

        if (nuevoStock != null) {
            producto.stock = nuevoStock
        }
        return true
    }

}