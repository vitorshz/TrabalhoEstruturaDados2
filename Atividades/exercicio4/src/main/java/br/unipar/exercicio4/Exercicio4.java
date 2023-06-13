/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.unipar.exercicio4;

import javax.swing.JOptionPane;

/**
 *
 * @author lucia
 */
public class Exercicio4 {

    public static void main(String[] args) {
        int n;
        String input = JOptionPane.showInputDialog("Informe um número inteiro  ");
        n = Integer.parseInt(input);
        System.out.println(fatorial(n));
    }

    public static int fatorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return fatorial(num - 1) * num;
        }

    }

}
