import java.io.File // Importa a classe File para criar e escrever arquivos no disco

fun main() {
    // Cria um objeto File apontando para 'boas_vindas.txt' no diretório atual de execução
    val arquivo = File("boas_vindas.txt")

    // Grava o texto no arquivo (cria se não existir ou sobrescreve o conteúdo se já existir)
    arquivo.writeText("Olá, turma de Kotlin!\nEsta é a primeira linha salva no disco.")

    // Exibe no console que a operação de escrita foi concluída
    println("Arquivo gravado com sucesso!")
}
