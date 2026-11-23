import java.io.File

fun main() {
    val arquivoProdutos = File("produtos.txt")
    arquivoProdutos.writeText(
        "Mouse Gamer; 120.0\n" +
        "Monitor 24pol;890.0\n" +
        "Mousepad Extra; 45.5\n" +
        "Teclado Mecânico; 310.0"
    )

    println("=== PRODUTOS EM PROMOÇÃO (ATÉ R$ 200) ===")
    arquivoProdutos.forEachLine { linha ->
        // O método split(";") fatia a String em uma lista: ["Mouse Gamer", "120.0"]
        val dados = linha.split(";")
        val nome = dados[0]
        val preco = dados[1].toDouble()

        if (preco <= 200.0) {
            println("Produto: $nome | Preço: R$ $preco")
        }
    }
}
