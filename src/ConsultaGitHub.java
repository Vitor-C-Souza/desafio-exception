import com.google.gson.Gson;
import exceptions.ErroConsultaGitHubException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Scanner;

record githubUserException(String message) {
}

public class ConsultaGitHub {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner read = new Scanner(System.in);

        System.out.println("Digite o usuario de github que deseja consultar: ");
        String user = read.nextLine();

        String endereco = "https://api.github.com/users/" + user;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        try{
            Gson gson = new Gson();
            var gitubUser = gson.fromJson(response.body(), githubUserException.class);

            if (Objects.equals(gitubUser.message(), "Not Found")) {
                throw new ErroConsultaGitHubException("Usuario não encontrado!!!");
            }

            System.out.println(response.body());
        } catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }
    }
}
