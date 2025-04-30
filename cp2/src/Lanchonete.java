import java.util.ArrayList;
import java.util.List;

public class Lanchonete {
    private List<Pedido> pedidos;

    public Lanchonete() {
        pedidos = new ArrayList<>();
    }

    public void registrarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void exibirResumoPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Produtos:");
            for (Produto p : pedido.getProdutos()) {
                System.out.println("- " + p.getNome() + " (" + p.getCategoria() + ") R$" + p.getPreco());
            }
            System.out.printf("Total com desconto: R$ %.2f%n%n", pedido.calcularTotalComDesconto(10));
        }
    }
}
