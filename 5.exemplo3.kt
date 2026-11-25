import java.io.File // Importa a classe File para manipular o arquivo do mapa

fun main() {
    // Cria a referência para 'mapa_radar.txt'
    val arquivoMapa = File("mapa_radar.txt")

    // Grava a grade 4x4 com os códigos do terreno (0 = vazio, 1 = vegetação, 2 = obstáculo, 9 = alvo)
    arquivoMapa.writeText(
        "0 1 0 2\n" +
        "1 0 0 1\n" +
        "0 2 9 0\n" +
        "1 1 0 2"
    )

    // Lê todas as linhas do arquivo como uma lista de Strings
    val linhasArquivo = arquivoMapa.readLines()

    // Guarda o tamanho da grade (quantidade de linhas)
    val n = linhasArquivo.size

    // 1. Criando a matriz 4x4 e populando a partir do arquivo
    val matrizRadar = Array(n) { IntArray(n) }

    // Percorre cada linha do arquivo
    for (i in 0 until n) {
        // Separa os valores da linha pelos espaços em branco
        val colunasTexto = linhasArquivo[i].split(" ")

        // Percorre cada coluna e converte o texto para Int na matriz
        for (j in 0 until n) {
            matrizRadar[i][j] = colunasTexto[j].toInt()
        }
    }

    // 2. Varrendo a matriz com controle de fluxo (continue e break)
    println("Iniciando varredura do radar...")

    // Sinalizador (flag) para avisar ao laço externo que o alvo foi encontrado
    var alvoEncontrado = false

    // Percorre as linhas da matriz
    for (i in matrizRadar.indices) {
        // Percorre as colunas da linha atual
        for (j in matrizRadar[i].indices) {
            // Obtém o código do setor na posição [i][j]
            val setor = matrizRadar[i][j]

            // Se o setor for 0 (vazio), pula imediatamente para a próxima coluna
            if (setor == 0) {
                continue
            }

            // Exibe a análise dos setores não vazios
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
