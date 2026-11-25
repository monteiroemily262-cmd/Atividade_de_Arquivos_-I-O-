import java.io.File // Importa a classe File para gerar o arquivo de recibo

fun main() {
    // Arrays paralelos com os itens do pedido e seus respectivos preços
    val itens = arrayOf("Hambúrguer Artesanal", "Batata Rústica", "Suco Natural")
    val precos = doubleArrayOf(32.00, 15.50, 9.00)

    // Acumulador mutável para somar o valor total do pedido
    var total = 0.0

    // Aponta para o arquivo 'recibo_pedido.txt'
    val recibo = File("recibo_pedido.txt")

    // Inicia o arquivo com o cabeçalho, limpando qualquer conteúdo antigo se já existir
    recibo.writeText("=== RECIBO DO PEDIDO ===\n")

    // Percorre os índices de 'itens' para montar cada linha e somar o total
    for (i in itens.indices) {
        // Adiciona cada item numerado ao final do arquivo sem apagar os anteriores
        recibo.appendText("${i + 1} ${itens[i]} R$ ${precos[i]}\n")

        // Soma o preço do item atual ao total acumulado
        total += precos[i]
    }

    // Insere uma linha separadora ao final da lista de itens
    recibo.appendText("-----------\n")

    // Escreve o valor total a pagar ao final do recibo
    recibo.appendText("TOTAL A PAGAR: R$ $total\n")

    // Exibe no console o caminho completo onde o recibo foi salvo
    println("Recibo gerado em: ${recibo.absolutePath}")
}
