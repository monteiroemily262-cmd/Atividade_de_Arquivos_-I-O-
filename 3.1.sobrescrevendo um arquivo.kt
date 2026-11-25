import java.io.File // Importa a classe File para escrever dados em arquivo

fun main() {
    // Cria uma referência para 'boas_vindas.txt' no diretório atual
    val arquivo = File("boas_vindas.txt")

    // Cria o arquivo se não existir ou sobrescreve todo o conteúdo anterior se já existir
    arquivo.writeText("Olá, turma de Kotlin!\nEsta é a primeira linha salva no disco.")

    // Confirma no console que a gravação foi concluída
    println("Arquivo gravado com sucesso!")
}
