import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

//package aula1;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello world!");
        // Fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://imdb-api.com/en/API/TOP250Movies/k_0ojt0yvm"; // Link expirado, consultar o site do imDb
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body); // Mostra o JSON
        // Extrair só os dados que interessam (Título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        //System.out.println(listaDeFilmes.size()); // Mostra a quantidade de itens na lista
        //System.out.println(listaDeFilmes.get(0)); // Pega o primeiro item
        // Exibir e manipular os dados
         for (Map<String, String> filme: listaDeFilmes){
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".jpg";
            var geradora = new GeradorDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
        }

    }
}
