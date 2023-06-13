/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package br.unipar.exercicio2ed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lucia
 */
public class Exercicio2ED {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Cliente> clientes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Pesquisar cliente");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (opcao == 1) {
                System.out.print("Informe o código do cliente: ");
                String codigo = scanner.nextLine();
                System.out.print("Informe o nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("Informe a data de nascimento do cliente (formato: DD/MM/AAAA): ");
                String dataNascimento = scanner.nextLine();
                System.out.print("Informe o CPF do cliente: ");
                String cpf = scanner.nextLine();

                Cliente cliente = new Cliente(codigo, nome, dataNascimento, cpf);
                inserirOrdenado(cliente, clientes);

                System.out.println("Cliente cadastrado com sucesso!");
            } else if (opcao == 2) {
                System.out.print("Informe o código do cliente que deseja pesquisar: ");
                String codigoPesquisa = scanner.nextLine();

                int indiceCliente = pesquisaBinaria(codigoPesquisa, clientes);

                if (indiceCliente != -1) {
                    Cliente clienteEncontrado = clientes.get(indiceCliente);
                    System.out.println("Cliente encontrado:");
                    System.out.println("Código: " + clienteEncontrado.getCodigo());
                    System.out.println("Nome: " + clienteEncontrado.getNome());
                    System.out.println("Data de Nascimento: " + clienteEncontrado.getDataNascimento());
                    System.out.println("CPF: " + clienteEncontrado.getCpf());
                } else {
                    System.out.println("Cliente não encontrado!");
                }
            } else if (opcao == 0) {
                break;
            } else {
                System.out.println("Opção inválida! Digite novamente.");
            }
        }

        System.out.println("Encerrando o aplicativo...");
    }

    public static void inserirOrdenado(Cliente cliente, List<Cliente> clientes) {
        int indice = 0;
        while (indice < clientes.size() && cliente.getCodigo().compareTo(clientes.get(indice).getCodigo()) > 0) {
            indice++;
        }
        clientes.add(indice, cliente);
    }

    public static int pesquisaBinaria(String codigoPesquisa, List<Cliente> clientes) {
        int esquerda = 0;
        int direita = clientes.size() - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            Cliente cliente = clientes.get(meio);
            int comparacao = cliente.getCodigo().compareTo(codigoPesquisa);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }

    
}
