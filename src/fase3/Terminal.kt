package fase3

// Bucle de Control: Implementar un bucle continu que mantingui l'aplicació oberta fins que se seleccioni l'opció de sortir.


fun main(){
    val inventario = Inventario()
    val salir = false

    print("Bienvenido al inventario: ")

    while (!salir){
        // Menu de opciones
        println("\n ----- Menu ----")
        println(" 1. Añadir un producto nuevo.")
        println(" 2. Mostrar todos los productos")
        println(" 3. Actulizar precio o stock de un producto")
        println(" 4. Salir")
        println("Seleccione una opcion")

        // Leer una opción ingresada de esto me lo lei de la documentación de kotlin y de una pagina web que me encontre
        // por lo que entendi funciona como el scanner en java
        val opcion = readln()

        when (opcion) {
            "1" -> {
                println("\n--- Añadir un producto ---")

                println("ID: ")
                val id = readln().toInt() // ESto comvierte el valor añadido por terminal(texto a integer)

                println("Nombre del producto: ")
                val nombre = readln()

                println("Precio: ")
                val precio = readln().toDouble()

                println("Stock: ")
                val stock = readln().toInt()

                println("Categoria:(Ejemplo: BEBIDAS," + "FRUTAS," + "LIMPIEZA," + "CARNES," + "PANADERIA," + "LACTEOS," + "SNACKS) ")
                val categoria = readln().uppercase().trim() //Combierte en mayusculas en caso que se inserte la categoria en minusculas

                // Validación del datos

                if (id == null || nombre.isEmpty()|| precio == null || stock == null || categoria == null){
                    println("Error: Valores incorretos o vacios")
                }else if(precio< 0 || stock < 0 ){
                    println("Error: No pueden ser valores negativos")
                }else{
                    val nuevoProducto = Producto(
                        id = id,
                        nombre = nombre,
                        precio = precio,
                        stock = stock,
                        categoria = Categoria.valueOf(categoria)
                    )
                    inventario.registrarProd(nuevoProducto)
                    println("Producto registrado correctamente")
                }
            }

            "2" -> {
                println("\n --- Lista de productos ---")
                val productos = inventario.consultarProd()

                if (productos.isEmpty()){
                    println("El inventario esta vacio")
                }else {
                    for (p in productos){
                        println("ID: ${p.id} | Nombre: ${p.nombre} | Precio: ${p.precio} | Stock: ${p.stock} | Categoria: ${p.categoria}")
                    }
                }
            }

            "3"-> {
                println("\n --- Actualizando precio / stock ---")
                println("Introduce el ID del producto: ")
                val id = readln().toInt()

                if (id == null) {
                    println("Id del procducto erroneo.")
                } else{
                    println("Nuevo precio del producto: (Dejar en blanco para no cambiar) ")
                    val precioInput = readln()
                    val nuevoPrecio = precioInput.toDouble()

                    println("Nuevo stock del producto:(Dejar en blanco para no cambiar) ")

                }

            }
        }


    }
}