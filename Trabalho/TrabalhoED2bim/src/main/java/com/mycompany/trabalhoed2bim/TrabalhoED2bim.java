package com.mycompany.trabalhoed2bim;

import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class TrabalhoED2bim {

    public static void main(String[] args) {
        boolean continua = true;

        String input = JOptionPane.showInputDialog("Quantas contas seu banco deseja ter? ");
        int quantidadeContas = Integer.parseInt(input);
        ContaBancaria[] listaContaBancaria = new ContaBancaria[quantidadeContas];
        int posContaVetor = 0;

        while (continua) {
            int menu = Integer.parseInt(JOptionPane.showInputDialog("--------------------------\n"
                    + "1 - Cadastrar conta\n"
                    + "2 - Ordenar e Listar\n"
                    + "3 - Depositar\n"
                    + "4 - Sacar\n"
                    + "5 - Somar saldo total entre Contas\n"
                    + "6 - Verificar Saldos Negativos\n"
                    + "7 - Sair"));
            switch (menu) {
                //1 - Cadastro de contas
                case 1: {
                    
                    if (posContaVetor == listaContaBancaria.length) {
                        JOptionPane.showMessageDialog(null, "Você atingiu o número máximo!");

                    } else {
                        input = JOptionPane.showInputDialog("Digite o número da " + (posContaVetor + 1) + "  conta: ");
                        int numeroConta = Integer.parseInt(input);

                        String nomeTitular = JOptionPane.showInputDialog("Digite o titular da  " + (posContaVetor + 1) + " conta: ");

                        input = JOptionPane.showInputDialog("Digite o saldo da  " + (posContaVetor + 1) + " conta: ");
                        double saldoConta = Double.parseDouble(input);

                        listaContaBancaria[posContaVetor] = new ContaBancaria(numeroConta, nomeTitular, saldoConta);
                        posContaVetor++;
                    }
                    break;
                }
                 //2 - Ordenando e listando as contas pela escolha do usuario
                case 2: {
                   
                    
                    input = JOptionPane.showInputDialog("Deseja ordenar por\n"
                            + "1 - número da conta\n"
                            + "2 - saldo ");
                    int opcaoOrdenacao = Integer.parseInt(input);
                    listaContaBancaria = ordenarConta(listaContaBancaria, opcaoOrdenacao);

                    //2 - Listando a conta
                    listarContas(listaContaBancaria);
                    break;
                    
                }
                //3 - Menu do depósito
                case 3: {
                    
                    
                    input = JOptionPane.showInputDialog("Digite uma conta que deseja depositar: ");
                    int contaBusca = Integer.parseInt(input);
                    int posConta = pesquisaConta(listaContaBancaria, contaBusca);

                    if (posConta == -1) {
                        JOptionPane.showMessageDialog(null, "Conta (" + contaBusca + ") não encontrada.");
                        break;
                    }
                    
                    input = JOptionPane.showInputDialog("Qual o valor que deseja depositar:  ");
                    double valorDeposito = Double.parseDouble(input);
                    listaContaBancaria[posConta].deposito(valorDeposito);
                    
                    break;
                }
                
                case 4: {
                    //4 - Menu para sacar
                    
                    input = JOptionPane.showInputDialog("Digite uma conta que deseja sacar: ");
                    int contaBusca = Integer.parseInt(input);
                    int posConta = pesquisaConta(listaContaBancaria, contaBusca);

                    if (posConta == -1) {
                        JOptionPane.showMessageDialog(null, "Conta (" + contaBusca + ") não encontrada.");
                        break;
                    }
                    
                    input = JOptionPane.showInputDialog("Qual o valor que deseja sacar:  ");
                    double valorDeposito = Double.parseDouble(input);
                    listaContaBancaria[posConta].saque(valorDeposito);
                    break;
                    
                }
                //5 - Menu para calcular o saldo total entre as contas
                case 5: {
                    

                    int pos = 0;
                    double soma = 0;
                    soma = somaTodasContas(listaContaBancaria, pos, soma);
                    JOptionPane.showMessageDialog(null, "A somatória de todas as contas é de:" + soma);
                    break;
                }
                
                //6 - Verificar se o saldo é negativo
                case 6: {
                    
                    if (posContaVetor == 0) {
                        JOptionPane.showMessageDialog(null, "Você não cadastrou nenhuma conta. "
                                + "Por favor, selecione a opção 1 no MENU.");
                        break;
                    }

                    int pos = 0;
                    String negativo = "";
                    negativo = verificaSaldoNegativo(listaContaBancaria, pos, negativo);
                    System.out.println(negativo);
                    
                    break;
                    
                }
                case 7: {
                    continua = false;
                    break;
                }

            }
        }

    }

    //método para ordenar contas
    public static ContaBancaria[] ordenarConta(ContaBancaria[] listaContas, int v1) {
        int n = listaContas.length;
        if (v1 == 1) {
            for (int i = 1; i < n; i++) {
                if (listaContas[i] != null) {
                    for (int j = i - 1; j < n - i; j++) {
                        if (listaContas[j + 1] != null) {
                            if (listaContas[j].getNumeroConta() > listaContas[j + 1].getNumeroConta()) {
                                ContaBancaria aux = listaContas[j];
                                listaContas[j] = listaContas[j + 1];
                                listaContas[j + 1] = aux;
                            }
                        }
                    }
                }
            }
        } else if (v1 == 2) {
            for (int i = 1; i < n; i++) {
                if (listaContas[i] != null) {
                    for (int j = i - 1; j < n - i; j++) {
                        if (listaContas[j + 1] != null) {
                            if (listaContas[j].getSaldo() > listaContas[j + 1].getSaldo()) {
                                ContaBancaria aux = listaContas[j];
                                listaContas[j] = listaContas[j + 1];
                                listaContas[j + 1] = aux;
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Opção não existente!");
            return listaContas;
        }

        return listaContas;
    }

    //método para listar as contas existentes
    public static void listarContas(ContaBancaria[] listaContas) {

        for (int i = 0; i < listaContas.length; i++) {
            if (listaContas[i] != null) {
                System.out.println("Conta: " + listaContas[i].getNumeroConta() + "\n"
                        + "Titular: " + listaContas[i].getNomeTitular() + "\n"
                        + "Saldo: " + listaContas[i].getSaldo()
                        + "-----------------------------------------------");
            }
        }

    }
    //método para pesquisar entre as contas existentes

    public static int pesquisaConta(ContaBancaria[] listaConta, int numero) {
        int n = listaConta.length;

        for (int i = 0; i < n; i++) {
            if (listaConta[i] != null) {
                if (listaConta[i].getNumeroConta() == numero) {
                    return i;
                }
            }
        }
        return -1;

    }

    //método de soma do saldo de todas as contas
    public static double somaTodasContas(ContaBancaria[] listaConta, int posicao, double somatoria) {
        if (posicao == listaConta.length) {
            return somatoria;
        }
        if (listaConta[posicao] != null) {
            somatoria += listaConta[posicao].getSaldo();
            posicao++;
        } else {
            posicao++;
        }
        return somaTodasContas(listaConta, posicao, somatoria);
    }

    //método para verificar saldo negativo das contas
    public static String verificaSaldoNegativo(ContaBancaria[] listaConta, int posicao, String contasNegativas) {
        double aux;
        if (posicao == listaConta.length) {
            return contasNegativas;
        }
        if (posicao == 0) {
            contasNegativas = "Contas com saldo negativo:";
        }
        if (listaConta[posicao] != null) {
            aux = listaConta[posicao].getSaldo();

            if (aux < 0) {
                contasNegativas += ("\nTitular:" + listaConta[posicao].getNomeTitular()
                        + "/ Conta:" + listaConta[posicao].getNumeroConta()
                        + " / Saldo: " + aux);
            }

            posicao++;
        } else {
            posicao++;
        }
        return verificaSaldoNegativo(listaConta, posicao, contasNegativas);
    }
}
