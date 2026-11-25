import java.io.File // Importa a classe File para gravar e ler o catálogo

fun main() {
    // Cria a referência para o arquivo 'produtos.txt'
    val arquivoProdutos = File("produtos.txt")

    // Grava os produtos no formato "Nome; Preço", separados por quebra de linha
    arquivoProdutos.writeText(
        "Mouse Gamer; 120.0\n" +
        "Monitor 24pol;890.0\n" +
        "Mousepad Extra; 45.5\n" +
        "Teclado Mecânico; 310.0"
    )

    // Exibe o cabeçalho dos produtos filtrados
    println("=== PRODUTOS EM PROMOÇÃO (ATÉ R$ 200) ===")

    // Lê o arquivo linha a linha sem carregar tudo de uma vez na memória
    arquivoProdutos.forEachLine { linha ->
        // O método split(";") fatia a String em uma lista: ["Mouse Gamer", "120.0"]
        val dados = linha.split(";")

        // Recupera o nome do produto (primeira posição)
        val nome = dados[0]

        // Recupera o preço (segunda posição) e converte de String para Double
        val preco = dados[1].toDouble()

        // Exibe apenas os produtos com preço menor ou igual a 200.0
        if (preco <= 200.0) {
            println("Produto: $nome | Preço: R$ $preco")
        }
    }
}
