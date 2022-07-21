import java.io.InputStream;
import java.net.URL;
import java.util.List;

//package aula1;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello world!");
        String url = "http://apidanasa.com"; // Pode ser qualquer url
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        //System.out.println(body); // Mostra o JSON
        ExtratorConteudo extrator = new ExtratorConteudoNasa();
        List<Conteudo> conteudos = extrator.extrairConteudos(json);
        //System.out.println(listaDeFilmes.size()); // Mostra a quantidade de itens na lista
        //System.out.println(listaDeFilmes.get(0)); // Pega o primeiro item
        // Exibir e manipular os dados
        var geradora = new GeradorDeFigurinhas();
        for (int i = 0; i < 10; i++){ // Enquanto i é menor que 10
            String urlImage = conteudos.get(i).getUrlImagem();
            String titulo = conteudos.get(i).getTitulo();
            InputStream inputStream = new URL(urlImage).openStream();
            String nomeArquivo = titulo + ".jpg";
            
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(nomeArquivo);

           /*  System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating")); */
        }

    }
}
