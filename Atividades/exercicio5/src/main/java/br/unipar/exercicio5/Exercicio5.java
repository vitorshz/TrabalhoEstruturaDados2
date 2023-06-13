/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.unipar.exercicio5;

/**
 *
 * @author lucia
 */
public class Exercicio5 {

     public static void main(String[] args) {
            int number = 20; // Número para o qual você deseja gerar a sequência Fibonacci
            System.out.println("Sequência Fibonacci de " + number + ":");
            for (int i = 0; i <= number; i++) {
                System.out.print(fibonacci(i) + " ");
            }
        }

        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }

}
