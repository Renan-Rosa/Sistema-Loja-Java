package main;

import Utils.Utils;
import model.Cliente;
import model.Fornecedor;
import model.Funcionario;
import model.Produto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;



public class Loja {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static ArrayList<Fornecedor> fornecedores;
    private static ArrayList<Funcionario> funcionarios;
    private static ArrayList<Cliente> clientes;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        fornecedores = new ArrayList<>();
        funcionarios = new ArrayList<>();
        clientes = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {
        System.out.println("=====================================================");
        System.out.println("------Seja Bem-vindo a Loja de Informática------");
        System.out.println("***** -------- Selecione uma operação --------- *****");
        System.out.println("=====================================================");
        System.out.println("| 1 - Cadastrar Produto     | ");
        System.out.println("| 2 - Listar Produto        | ");
        System.out.println("-----------------------------------------------------");
        System.out.println("| 3 - Cadastrar Fornecedor  | ");
        System.out.println("| 4 - Listar Fornecedor     | ");
        System.out.println("-----------------------------------------------------");
        System.out.println("| 5 - Cadastrar Funcionário | ");
        System.out.println("| 6 - Listar Funcionário    | ");
        System.out.println("-----------------------------------------------------");
        System.out.println("| 7 - Cadastrar Cliente     | ");
        System.out.println("| 8 - Listar Cliente        | ");
        System.out.println("-----------------------------------------------------");
        System.out.println("| 9 - Comprar Produto       | ");
        System.out.println("| 10 - Carrinho             | ");
        System.out.println("-----------------------------------------------------");
        System.out.println("| 11 - Sair                 | ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProduto();
                break;
            case 3:
                cadastrarForn();
                break;
            case 4:
                listarForn();
                break;
            case 5:
                cadastrarFunc();
                break;
            case 6:
                listarFunc();
                break;
            case 7:
                cadastrarCli();
                break;
            case 8:
                listarCli();
                break;
            case 9:
                comprarProdutos();
                break;
            case 10:
                verCarrinho();
                break;
            case 11:
                System.out.println("Volte sempre");
                System.exit(0);
            default:
                System.out.println("Opção Inválida");
                menu();
                break;
        }
    }
    private static void cadastrarProdutos() {
        System.out.println("Nome do produto: ");
        String nome = input.next();

        System.out.println("Preço do Produto: ");
        Double preco = input.nextDouble();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println(produto.getNome() + " Cadastrado com sucesso !");
        menu();
    }

    private static void listarProduto() {
        if (produtos.size() > 0) {
            System.out.println("Lista de Produtos  \n");

            for (Produto p : produtos) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum produto cadastrado");
        }

        menu();
    }

    private static void cadastrarForn() {
        System.out.println("Nome do Fornecedor: ");
        String nome = input.next();

        System.out.println("CNPJ do Fornecedor: ");
        int CNPJ = input.nextInt();

        Fornecedor fornecedor = new Fornecedor(nome, CNPJ);
        fornecedores.add(fornecedor);

        System.out.println(fornecedor.getNome() + " Cadastrado com sucesso !");
        menu();
    }

    private static void listarForn() {
        if (fornecedores.size() > 0) {
            System.out.println("Lista de Fornecedores  \n");

            for (Fornecedor p: fornecedores) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum Fornecedor cadastrado");
        }

        menu();
    }

    private static void cadastrarFunc() {
        System.out.println("Nome do Funcionario: ");
        String nome = input.next();

        System.out.println("CPF do Funcionario: ");
        int CPFFunc = input.nextInt();

        Funcionario funcionario = new Funcionario(nome, CPFFunc);
        funcionarios.add(funcionario);

        System.out.println(funcionario.getNome() + " Cadastrado com sucesso !");
        menu();
    }

    private static void listarFunc() {
        if (funcionarios.size() > 0) {
            System.out.println("Lista de Funcionarios  \n");

            for (Funcionario p : funcionarios) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum funcionario cadastrado");
        }

        menu();
    }

    private static void cadastrarCli() {
        System.out.println("Nome do Cliente: ");
        String nome = input.next();

        System.out.println("CPF do Cliente: ");
        int CPFCli = input.nextInt();

        Cliente cliente = new Cliente(nome, CPFCli);
        clientes.add(cliente);

        System.out.println(cliente.getNome() + " Cadastrado com sucesso !");
        menu();
    }

    private static void listarCli() {
        if (clientes.size() > 0) {
            System.out.println("Lista de Clientes  \n");

            for (Cliente p : clientes) {
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum Cliente cadastrado !");
        }

        menu();
    }

    private static void comprarProdutos() {
        if (produtos.size() > 0) {
            System.out.println("Digite o Codigo do produto: \n");

            System.out.println("---------------Produtos Disponiveis--------------");
            for (Produto p : produtos) {
                System.out.println(p + "\n");
            }

            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Produto p : produtos) {
                if (p.getId() == id) {
                    int qtd = 0;
                    try {
                        qtd = carrinho.get(p);
                        //checar se o produto esta no carrinho
                        carrinho.put(p, qtd+1);
                    }catch (NullPointerException e) {
                        //se o produto for primeiro no carrinho
                        carrinho.put(p, 1);
                    }
                    System.out.println(p.getNome() + "Adicione ao carrinho ");
                    isPresent = true;

                    if (isPresent) {
                        System.out.println("Deseja adicionar outro produto ao carrinho? ");
                        System.out.println("Digite 1 para sim, ou 0 para finalizar a compra. \n");
                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProdutos();
                        }else {
                            finalizarCompra();
                        }
                    }
                }else {
                    System.out.println("Produto nao encontrado ");
                    menu();
                }
            }
        }else {
            System.out.println("Nao existem produtos cadastrados!");
            menu();
        }

    }

    private static void verCarrinho() {
        System.out.println("-----Produtos no seu carrinho-----");
        if (carrinho.size() > 0) {
            for (Produto p: carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
            }
        }else {
            System.out.println("Carrinho vazio!");
        }
        menu();
    }

    private static void finalizarCompra() {
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos!");

        for (Produto p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;
            System.out.println(p);
            System.out.println("Quantidade: " + qtd);
            System.out.println("---------------------");
        }
        System.out.println("O valor da sua compra e: " + Utils.doubleToString(valorDaCompra));
        carrinho.clear();
        System.out.println("Obrigado pela preferencia!");
        menu();
    }
}
