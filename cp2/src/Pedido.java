import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;
    private double desconto;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.desconto = 0;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            produtos.add(produto);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco();
        }
        return total;
    }

    public double calcularTotalComDesconto(double percentual) {
        double total = calcularTotal();
        desconto = (percentual / 100) * total;
        return total - desconto;
    }

    public Cliente getCliente() { return cliente; }
    public List<Produto> getProdutos() { return produtos; }
    public double getDesconto() { return desconto; }
}
