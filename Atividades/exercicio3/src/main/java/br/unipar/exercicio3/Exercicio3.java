/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.unipar.exercicio3;

/**
 *
 * @author lucia
 */
public class Exercicio3 {

    public static void main(String[] args) {
        int contagem = 0;
        System.out.println("Iniciando contagem regressiva: ");
        contagemRegressiva(contagem);
    }

    public static void contagemRegressiva(int numero) {
        if (numero == 50) {
            System.out.println("Explosão");
        } else {
            System.out.println(numero);
            contagemRegressiva(numero = numero + 1);
        }
    }

}
