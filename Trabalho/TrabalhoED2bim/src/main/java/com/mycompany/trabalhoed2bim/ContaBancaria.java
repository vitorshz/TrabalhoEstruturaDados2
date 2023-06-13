package com.mycompany.trabalhoed2bim;

public class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    private double saldoSaque;
    private double saldoDeposito;

    public ContaBancaria() {
    }

    public ContaBancaria(int numeroConta, String nomeTitular, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoSaque() {
        return saldoSaque;
    }

    public void setSaldoSaque(double saldoSaque) {
        this.saldoSaque = saldoSaque;
    }

    public double getSaldoDeposito() {
        return saldoDeposito;
    }

    public void setSaldoDeposito(double saldoDeposito) {
        this.saldoDeposito = saldoDeposito;
    }

    public void deposito(double valor){
        this.saldoDeposito +=  valor;
        this.saldo += valor;
    }
    public void saque(double valor){
        this.saldoSaque +=  valor;
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numeroConta=" + numeroConta +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
