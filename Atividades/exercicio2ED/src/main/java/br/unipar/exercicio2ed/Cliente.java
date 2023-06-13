/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.exercicio2ed;

public class Cliente {

        private String codigo;
        private String nome;
        private String dataNascimento;
        private String cpf;

        public Cliente(String codigo, String nome, String dataNascimento, String cpf) {
            this.codigo = codigo;
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.cpf = cpf;
        }

        public String getCodigo() {
            return codigo;
        }

        public String getNome() {
            return nome;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public String getCpf() {
            return cpf;
        }
    }

