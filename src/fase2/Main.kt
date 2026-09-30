package fase2

fun main() {
    val inventari = Inventari()

    while (true) {
        println(
            """
            --- Gestió de l'inventari ---
            1. Afegir un producte
            2. Llistar els productes
            3. Modificar preu o stock
            4. Sortir
            """.trimIndent()
        )

        when (readlnOrNull()?.trim()) {
            "1" -> afegirProducte(inventari)
            "2" -> llistarProductes(inventari)
            "3" -> modificarProducte(inventari)
            "4", null -> {
                println("Aplicació finalitzada.")
                return
            }
            else -> println("Opció no vàlida.")
        }
    }
}

private fun afegirProducte(inventari: Inventari) {
    val id = llegirEnter("ID: ", positiu = true) ?: return

    print("Nom: ")
    val nom = readlnOrNull()?.trim()
    if (nom.isNullOrEmpty()) {
        println("El nom no pot estar buit.")
        return
    }

    val preu = llegirDecimal("Preu: ", positiu = true) ?: return
    val stock = llegirDecimal("Stock: ", positiu = false) ?: return

    println("Categories disponibles: ${Categoria.values().joinToString()}")
    print("Categoria: ")
    val nomCategoria = readlnOrNull()?.trim()
    val categoria = Categoria.values().firstOrNull {
        it.name.equals(nomCategoria, ignoreCase = true)
    }
    if (categoria == null) {
        println("Categoria no vàlida.")
        return
    }

    inventari.registrarProducto(Producto(id, nom, preu, stock, categoria))
    println("Producte registrat correctament.")
}

private fun llistarProductes(inventari: Inventari) {
    val productes = inventari.consultarProductos()
    if (productes.isEmpty()) {
        println("No hi ha productes a l'inventari.")
    } else {
        productes.forEach { println(it) }
    }
}

private fun modificarProducte(inventari: Inventari) {
    val id = llegirEnter("ID del producte: ", positiu = true) ?: return

    print("Què vols modificar? (1. Preu / 2. Stock): ")
    when (readlnOrNull()?.trim()) {
        "1" -> {
            val preu = llegirDecimal("Nou preu: ", positiu = true) ?: return
            if (inventari.actualizarPreu(id, preu)) {
                println("Preu actualitzat correctament.")
            } else {
                println("No s'ha trobat cap producte amb aquest ID.")
            }
        }
        "2" -> {
            val stock = llegirDecimal("Nou stock: ", positiu = false) ?: return
            if (inventari.actualizarStock(id, stock)) {
                println("Stock actualitzat correctament.")
            } else {
                println("No s'ha trobat cap producte amb aquest ID.")
            }
        }
        else -> println("Opció no vàlida.")
    }
}

private fun llegirEnter(missatge: String, positiu: Boolean): Int? {
    print(missatge)
    val valor = readlnOrNull()?.trim()?.toIntOrNull()
    if (valor == null || (positiu && valor <= 0)) {
        println("Introdueix un nombre enter vàlid.")
        return null
    }
    return valor
}

private fun llegirDecimal(missatge: String, positiu: Boolean): Double? {
    print(missatge)
    val valor = readlnOrNull()?.trim()?.replace(',', '.')?.toDoubleOrNull()
    if (valor == null || !valor.isFinite() || (positiu && valor <= 0) || (!positiu && valor < 0)) {
        println("Introdueix un nombre decimal vàlid.")
        return null
    }
    return valor
}
