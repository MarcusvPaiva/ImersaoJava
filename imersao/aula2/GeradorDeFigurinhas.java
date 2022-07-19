import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        inputStream = new URL("Endereço URL").openStream(); // Procura o arquivo (Internet)
        // inputStream = new FileInputStream(new File("Caminho do arquivo/arquivo.jpg")); // Procura o arquivo (Local)
        BufferedImage imagemOriginal = ImageIO.read(inputStream);// Lê o arquivo
        int largura = imagemOriginal.getWidth(); // Identifica a largura da imagem
        int altura = imagemOriginal.getHeight(); // Identifica a altura da imagem
        int novaAltura = altura + 200; // Adiciona 200px de altura a imagem
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT); // Cria uma imagem translucida
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics(); // Copia a imagem original para nova imagem (em memória)
        graphics.drawImage(imagemOriginal,0,0, null); // Desenha a imagem com base na imagem original
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 32); // Seleciona a fonte, seu tipo, tamanho e outras características
        graphics.setColor(Color.YELLOW); // Seleciona a cor da fonte
        graphics.setFont(fonte); // seleciona a fonte configurada na linha 18
        graphics.drawString("Escrita", 0, novaAltura - 100); // Escrever uma frase na nova imagem
        ImageIO.write(novaImagem, "jpg", new File("arquivo2.png")); // Escreve a nova imagem em um arquivo
    }
    public static void main(String[] args) throws Exception {
        //var geradora = new GeradorDeFigurinhas(); // Instancia um novo GeradorDeFigurinhas
        //geradora.cria(); // Executa o método
    }
}
