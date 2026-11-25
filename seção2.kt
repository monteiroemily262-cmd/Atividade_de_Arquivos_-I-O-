import java.io.File // Importa a classe File para representar caminhos e manipular arquivos no disco

fun main() {
    // Aponta para um arquivo na raiz do projeto
    val arquivo = File("dados.txt")

    // Verificações úteis antes de operar
    println("O arquivo existe? ${arquivo.exists()}")
    println("Caminho absoluto: ${arquivo.absolutePath}")
}
