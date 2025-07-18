package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaItem;

    public CarrinhoDeCompras() {
        this.listaItem = new ArrayList<>();
    }
    public void adicionarItem(String nome, double preco, int quantidade) {
        listaItem.add(new Item(nome, preco, quantidade));
    }
    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if(!listaItem.isEmpty()) {
            for(Item i : listaItem) {
                if(i.getName().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            listaItem.removeAll(itensParaRemover);
        }else {
            System.out.println("A lista está vazia");
        }
    }
    public double calcularValorTotal() {
        double valorTotal = 0d;
        if(!listaItem.isEmpty()) {
            for (Item item : listaItem) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista esta vazia");
        }
    }
    public void exibirItens() {
        System.out.println(listaItem);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("TV", 5000.00, 3);
        carrinhoDeCompras.adicionarItem("Celular", 2000.00, 1);
        carrinhoDeCompras.adicionarItem("Torradeira", 100.00, 1);

        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Celular");

        carrinhoDeCompras.exibirItens();

        System.out.println("O valor total da compra é: " + carrinhoDeCompras.calcularValorTotal());

    }
}
