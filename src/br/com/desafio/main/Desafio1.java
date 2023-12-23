package br.com.desafio.main;

import java.util.Scanner;

public class Desafio1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int primeiroNumero;
        int segundoNumero;
        double resultado;

        primeiroNumero = scan.nextInt();
        segundoNumero = scan.nextInt();

        try {
            resultado = primeiroNumero / segundoNumero;
        } catch (ArithmeticException erro) {
            System.out.println("Erro de divisão, mesagem do sistema: " + erro.getMessage());
        }
    }
}
