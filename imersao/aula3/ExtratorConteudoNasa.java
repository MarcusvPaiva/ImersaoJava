import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorConteudo {
    public List<Conteudo> extrairConteudos(String json){
        var parser = new JsonParser();// Extrair só os dados que interessam (Título, poster, classificação)
        List<Map<String, String>> listaAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();
        for(Map<String, String> atributos : listaAtributos){
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }
        return conteudos;
    }
}
