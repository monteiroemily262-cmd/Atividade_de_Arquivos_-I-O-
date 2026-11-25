import java.io.File // Importa a classe File para manipulação de arquivos no disco

fun main() {
    // Cria um objeto File referenciando 'mapa_radar.txt' no diretório atual
    val arquivoMapa = File("mapa_radar.txt")

    // Grava (ou sobrescreve) o arquivo com uma grade de 4 linhas e 4 colunas separadas por espaço
    arquivoMapa.writeText(
        "0 1 0 2\n" +
        "1 0 0 1\n" +
        "0 2 9 0\n" +
        "1 1 0 2"
    )

    // Lê todas as linhas do arquivo e retorna uma List<String>
    val linhasArquivo = arquivoMapa.readLines()

    // Obtém a quantidade de linhas lidas (4 neste exemplo)
    val n = linhasArquivo.size

    // 1. Criando a matriz 4x4 e populando a partir do arquivo
    // Cria um array de tamanho 'n' onde cada elemento é um IntArray de tamanho 'n'
    val matrizRadar = Array(n) { IntArray(n) }

    // Laço externo: percorre os índices de linha de 0 até n - 1
    for (i in 0 until n) {
        // Divide a linha 'i' pelos espaços em branco para obter cada valor como String
        val colunasTexto = linhasArquivo[i].split(" ")

        // Laço interno: percorre os índices de coluna de 0 até n - 1
        for (j in 0 until n) {
            // Converte o texto da coluna 'j' para Int e armazena na posição [i][j] da matriz
            matrizRadar[i][j] = colunasTexto[j].toInt()
        }
    }

    // 2. Varrendo a matriz com controle de fluxo (continue e break)
    // Exibe mensagem inicial antes de começar a leitura da matriz
    println("Iniciando varredura do radar...")

    // Flag booleana usada para sinalizar ao laço externo que o alvo já foi achado
    var alvoEncontrado = false

    // Percorre os índices das linhas ('i') da matriz
    for (i in matrizRadar.indices) {
        // Percorre os índices das colunas ('j') dentro da linha 'i'
        for (j in matrizRadar[i].indices) {
            // Obtém o valor numérico armazenado na coordenada [i][j]
            val setor = matrizRadar[i][j]

            // Se o setor for 0 (vazio), pula imediatamente para a próxima coluna
            if (setor == 0) {
                continue
            }

            // Mostra qual coordenada não vazia está sendo avaliada e seu código
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
