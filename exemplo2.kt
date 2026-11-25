import java.io.File // Importa a classe File para criar e manipular arquivos no disco

fun main() {
    // Cria um objeto File referenciando 'produtos.txt' no diretório atual de execução
    val arquivoProdutos = File("produtos.txt")

    // Cria (ou sobrescreve) o arquivo com 4 linhas de dados separados por ';' (nome;preço)
    arquivoProdutos.writeText(
        "Mouse Gamer; 120.0\n" +
        "Monitor 24pol;890.0\n" +
        "Mousepad Extra; 45.5\n" +
        "Teclado Mecânico; 310.0"
    )

    // Imprime o título da seção filtrada no console
    println("=== PRODUTOS EM PROMOÇÃO (ATÉ R$ 200) ===")

    // Lê o arquivo linha a linha e executa o bloco abaixo para cada 'linha' encontrada
    arquivoProdutos.forEachLine { linha ->
        // O método split(";") fatia a String em uma lista: ["Mouse Gamer", "120.0"]
        val dados = linha.split(";")

        // Acessa o primeiro elemento da lista (índice 0) correspondente ao nome do produto
        val nome = dados[0]

        // Acessa o segundo elemento (índice 1) e converte a String de preço para Double
        val preco = dados[1].toDouble()

        // Filtra apenas os produtos cujo preço seja menor ou igual a 200.0
        if (preco <= 200.0) {
            // Exibe no console o nome e o preço do produto que atendeu à condição
            println("Produto: $nome | Preço: R$ $preco")
        }
    }
}
