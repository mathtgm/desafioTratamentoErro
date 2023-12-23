package br.com.desafio.main;

import br.com.desafio.GitUserRecord;
import br.com.desafio.exception.ErroConsultaGitHub;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Desafio3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o nome do usuário do Github: ");
        String usuario = scan.nextLine();

        String endereco = "https://api.github.com/users/" + usuario;

        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder(URI.create(endereco))
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 404) {
                throw new ErroConsultaGitHub("Usuario não encontrado!");
            }

            String json = response.body();
            Gson gson = new Gson();

            GitUserRecord user = gson.fromJson(json, GitUserRecord.class);

            System.out.println("""
                    #### Informações do usuário ####
                    Nome: %s
                    Usuário: %s
                    Criado em: %s
                    Pais: %s
                    Biografia: %s
                    Perfil do Github: %s
                    """.formatted(user.name(), user.login(), user.created_at(), user.location(), user.bio(), user.html_url()));
        } catch (ErroConsultaGitHub | IOException | InterruptedException msg) {
            System.out.println(msg.getMessage());
        }
    }
}
