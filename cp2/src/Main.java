import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Digite a idade do cliente: ");
        int idade = Integer.parseInt(sc.nextLine()); // Conversão de String para int

        Cliente cliente = new Cliente(nome, idade);

        Pedido pedido = new Pedido(cliente);

        while (true) {
            System.out.println("\nProdutos disponíveis:");
            System.out.println("1 - Hamburguer - R$15.00");
            System.out.println("2 - Refrigerante - R$5.00");
            System.out.println("3 - Batata Frita - R$8.00");
            System.out.println("4 - Finalizar pedido");

            System.out.print("Escolha um produto: ");
            int opcao = Integer.parseInt(sc.nextLine());

            if (opcao == 1) {
                pedido.adicionarProduto(new Produto("Hamburguer", 15.00, "Lanche"));
            } else if (opcao == 2) {
                pedido.adicionarProduto(new Produto("Refrigerante", 5.00)); // construtor sem categoria
            } else if (opcao == 3) {
                System.out.print("Quantas batatas fritas deseja? ");
                int qtd = Integer.parseInt(sc.nextLine());
                pedido.adicionarProduto(new Produto("Batata Frita", 8.00, "Acompanhamento"), qtd); // sobrecarga com quantidade
            } else if (opcao == 4) {
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("\n--- Resumo do Pedido ---");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos:");
        for (Produto p : pedido.getProdutos()) {
            System.out.println("- " + p.getNome() + " (" + p.getCategoria() + ") R$" + p.getPreco());
        }

        double total = pedido.calcularTotal();
        double totalComDesconto = pedido.calcularTotalComDesconto(10); // desconto de 10%
        System.out.printf("Total: R$ %.2f\n", total);
        System.out.printf("Total com desconto (10%%): R$ %.2f\n", totalComDesconto);

        sc.close();
    }
}
