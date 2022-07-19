import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AppJSON {
    public static void main(String[] args) throws Exception {
        var url = "https://imdb-api.com/en/API/Top250Movies/k_om97iutj"; // Acessar url
        URI uri = URI.create(url); // Cria uma uri com a url acima
        var client = HttpClient.newHttpClient(); // Cria um client
        var request = HttpRequest.newBuilder(uri).build(); // Cria uma requisição usando o uri
        var json = client.send(request, HttpResponse.BodyHandlers.ofString()).body(); // pegar texto(JSON)
        System.out.println(json); // Imprimir JSON
    }
}