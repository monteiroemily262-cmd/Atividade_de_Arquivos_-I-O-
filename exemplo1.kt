import java.io.File

fun main() {
    val itens = arrayOf("Hambúrguer Artesanal", "Batata Rústica", "Suco Natural")
    val precos = doubleArrayOf(32.00, 15.50, 9.00)
    var total = 0.0

    val recibo = File("recibo_pedido.txt")
    recibo.writeText("=== RECIBO DO PEDIDO ===\n")

    for (i in itens.indices) {
        recibo.appendText("${i + 1} ${itens[i]} R$ ${precos[i]}\n")
        total += precos[i]
    }

    recibo.appendText("-----------\n")
    recibo.appendText("TOTAL A PAGAR: R$ $total\n")
    println("Recibo gerado em: ${recibo.absolutePath}")
}
