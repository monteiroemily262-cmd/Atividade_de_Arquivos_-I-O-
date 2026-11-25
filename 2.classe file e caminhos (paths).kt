import java.io.File // Importa a classe File para representar caminhos e manipular arquivos

fun main() {
    // Aponta para um arquivo na raiz do projeto (caminho relativo)
    val arquivo = File("dados.txt")

    // Verificações úteis antes de operar
    println("O arquivo existe? ${arquivo.exists()}") // Verifica se o arquivo já existe no disco
    println("Caminho absoluto: ${arquivo.absolutePath}") // Exibe o caminho completo no sistema operacional
}
