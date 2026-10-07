package fase1

// Disenyar una funció que rebi una variable (String?) i la mostri al terminal. Si la variable conte text,
// mostrarà el text, si no, mostrarà un missatge indicant que la variable està buida, ha de mostrar
// un missatge alternatiu per defecte fent servir l'operador (?:).

fun imprimirVariable (text : String?) {
    val mensaje = text ?: "La variable está vacía"
    println(mensaje)
}


// Dissenyar una funció pura que rebi dos paràmetres (un preu de tipus numèric i un percentatge de descompte)
//  i retorni el preu final després d'aplicar aquest descompte.

fun calcularDescompte (preu : Double, Descompte : Double) : Double {
    return preu - (preu * (Descompte / 100))
}

fun main() {
    imprimirVariable("Hola, món!")
    imprimirVariable(null)

    val preuFinal = calcularDescompte(100.0, 20.0)
    println("El preu final després del descompte és: $preuFinal")
}