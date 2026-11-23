import java.io.File

fun main() {
    // Aponta para um arquivo na raiz do projeto
    val arquivo = File("dados.txt")

    // Verificações úteis antes de operar
    println("O arquivo existe? ${arquivo.exists()}")
    println("Caminho absoluto: ${arquivo.absolutePath}")
}
