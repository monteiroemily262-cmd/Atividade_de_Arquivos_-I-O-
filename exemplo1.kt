import java.io.File // Importa a classe File da biblioteca padrão do Java para manipular arquivos no disco

fun main() {
    // Array de Strings com os nomes dos itens do pedido (tamanho fixo: 3 elementos)
    val itens = arrayOf("Hambúrguer Artesanal", "Batata Rústica", "Suco Natural")

    // Array primitivo de Double para armazenar os preços na mesma ordem de 'itens'
    val precos = doubleArrayOf(32.00, 15.50, 9.00)

    // Variável mutável ('var') que acumulará a soma dos preços; começa em 0.0 (Double)
    var total = 0.0

    // Cria um objeto File apontando para 'recibo_pedido.txt' no diretório de execução atual
    val recibo = File("recibo_pedido.txt")

    // Cria (ou sobrescreve, se já existir) o arquivo com o cabeçalho do recibo
    recibo.writeText("=== RECIBO DO PEDIDO ===\n")

    // Percorre os índices válidos de 'itens' (0, 1, 2) usando o intervalo 'itens.indices'
    for (i in itens.indices) {
        // Usa string templates para montar a linha numerada (i + 1 para começar em 1) e adiciona ao arquivo
        recibo.appendText("${i + 1} ${itens[i]} R$ ${precos[i]}\n")

        // Soma o preço correspondente ao índice 'i' no acumulador 'total'
        total += precos[i]
    }

    // Adiciona uma linha separadora ao final da lista de itens
    recibo.appendText("-----------\n")

    // Escreve o valor total acumulado no final do arquivo
    recibo.appendText("TOTAL A PAGAR: R$ $total\n")

    // Exibe no console o caminho completo onde o arquivo foi salvo
    println("Recibo gerado em: ${recibo.absolutePath}")
}
