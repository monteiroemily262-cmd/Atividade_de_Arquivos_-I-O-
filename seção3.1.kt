import java.io.File

fun main() {
    val arquivo = File("boas_vindas.txt")
    arquivo.writeText("Olá, turma de Kotlin!\nEsta é a primeira linha salva no disco.")
    println("Arquivo gravado com sucesso!")
}
