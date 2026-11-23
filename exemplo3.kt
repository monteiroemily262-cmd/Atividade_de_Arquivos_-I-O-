import java.io.File

fun main() {
    val arquivoMapa = File("mapa_radar.txt")
    arquivoMapa.writeText(
        "0 1 0 2\n" +
        "1 0 0 1\n" +
        "0 2 9 0\n" +
        "1 1 0 2"
    )

    val linhasArquivo = arquivoMapa.readLines()
    val n = linhasArquivo.size

    // 1. Criando a matriz 4x4 e populando a partir do arquivo
    val matrizRadar = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val colunasTexto = linhasArquivo[i].split(" ")
        for (j in 0 until n) {
            matrizRadar[i][j] = colunasTexto[j].toInt()
        }
    }

    // 2. Varrendo a matriz com controle de fluxo (continue e break)
    println("Iniciando varredura do radar...")
    var alvoEncontrado = false

    for (i in matrizRadar.indices) {
        for (j in matrizRadar[i].indices) {
            val setor = matrizRadar[i][j]

            // Se o setor for 0 (vazio), pula imediatamente para a próxima coluna
            if (setor == 0) {
                continue
            }

            println("Analisando setor [$i] [$j] -> Código: $setor")

            // Se encontrar o código 9 (Alvo), interrompe o laço interno
            if (setor == 9) {
                println("ALVO PRIORITÁRIO LOCALIZADO na coordenada [$i] [$j]!")
                alvoEncontrado = true
                break
            }
        }

        // Se já encontrou no laço interno, interrompe também o laço externo (linhas)
        if (alvoEncontrado) {
            break
        }
    }
}
