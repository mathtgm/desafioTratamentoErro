package br.com.desafio.main;

import br.com.desafio.exception.SenhaInvalidaException;
import br.com.desafio.model.Usuario;

import java.util.Scanner;

public class Desafio2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Usuario user;
        String usuario;
        String senha;

        try {
            usuario = scan.nextLine();
            senha = scan.nextLine();

            if(senha.length() < 8) {
                throw new SenhaInvalidaException("Senha com menos de oito caracteres");
            }

            user = new Usuario(usuario, senha);

        } catch (SenhaInvalidaException erro) {
            System.out.println(erro.getMessage());
        }
    }
}
