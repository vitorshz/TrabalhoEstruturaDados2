package br.unipar.aula1005ed;

import javax.swing.JOptionPane;

public class Aula1005ED {

    public static void main(String[] args) {
        String input;
        int v1;

        input = JOptionPane.showInputDialog("Deseja informar quantos números: ");
        v1 = Integer.parseInt(input);

        int[] vetor = new int[v1];
        for (int i = 0; i < vetor.length; i++) {
            input = JOptionPane.showInputDialog("Informe os números: ");
            vetor[i] = Integer.parseInt(input);
        }

        int tpPesquisa;
        input = JOptionPane.showInputDialog("Qual tipo de pesquisa deseja fazer? "
                + "\n 1 - Pesquisa Linear"
                + "\n 2 - Pesquisa Binária");
        tpPesquisa = Integer.parseInt(input);
        int numeroPesquisar;

        switch (tpPesquisa) {
            case 1:
                input = JOptionPane.showInputDialog("Informe o número a ser pesquisado ");
                numeroPesquisar = Integer.parseInt(input);
                ordenaVetor(vetor);
                JOptionPane.showMessageDialog(null,
                        "O elemento " + numeroPesquisar + " está na posição: "
                        + pesquisaLinear(numeroPesquisar, vetor));
            case 2:
                input = JOptionPane.showInputDialog("Informe o número a ser pesquisado ");
                numeroPesquisar = Integer.parseInt(input);
                ordenaVetor(vetor);
                JOptionPane.showMessageDialog(null,
                        "O elemento " + numeroPesquisar + " está na posição: "
                        + pesquisaBinaria(numeroPesquisar, vetor));

        }

    }

    public static int pesquisaLinear(int numPesq, int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            if (numPesq == vet[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int pesquisaBinaria(int numPesq, int[] vet) {
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length - 1;

        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if (numPesq == vet[meio]) {
                return meio;
            }
            if (numPesq > vet[meio]) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }

    public static int ordenaVetor(int[] vet) {

        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[i] < vet[j]) {
                    int aux = vet[i];
                    vet[i] = vet[j];
                    vet[j] = aux;
                }
            }

        }
        return -1;
    }

    public static void ImprimeVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }
    }

}
