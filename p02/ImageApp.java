
import java.awt.Color;
import java.awt.image.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ImageApp   {

	// Leitura da imagem
	public static BufferedImage loadImage(String surl) {
		BufferedImage bimg = null;
		try {
			URL url = new URL(surl);
			bimg = ImageIO.read(url);
			//bimg = ImageIO.read(new File("D:/Temp/mundo.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bimg;
	}

	public void apresentaImagem(JFrame frame, BufferedImage img) {
		frame.setBounds(0, 0, img.getWidth(), img.getHeight());
		JImagePanel panel = new JImagePanel(img, 0, 0);
		frame.add(panel);
		frame.setVisible(true);
	}

	public static BufferedImage criaImagemRGB() {
		BufferedImage img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);

		WritableRaster raster = img.getRaster();

		for(int h=0;h<200;h++) //200 � o tamanho e w e h � a posi��o x e y
			for(int w=0;w<200;w++) {//refere-se a imagem amarela
				raster.setSample(w,h,0,220); // Componente Vermelho
				raster.setSample(w,h,1,219); // Componente Verde
				raster.setSample(w,h,2,97);  // Componente Azul
			}
		return img;
	}
	public static BufferedImage converteAzul(BufferedImage imgOriginal) {
		int height = imgOriginal.getHeight();
		int width = imgOriginal.getWidth();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = img.getRaster();
		WritableRaster rasterAzul = img.getRaster();
		for(int h = 0; h < height; h++)
			for(int w = 0; w < width; w++) {
				Color color = new Color(imgOriginal.getRGB(w, h));
				int intensidade = color.getBlue();
				rasterAzul.setSample(w, h, 0, intensidade);
			}
		return img;
	}
	public static BufferedImage converteVerde(BufferedImage imgOriginal) {
		int height = imgOriginal.getHeight();
		int width = imgOriginal.getWidth();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = img.getRaster();
		WritableRaster rasterVerde = img.getRaster();
		for(int h = 0; h < height; h++)
			for(int w = 0; w < width; w++) {
				Color color = new Color(imgOriginal.getRGB(w, h));
				int intensidade = color.getGreen();
				rasterVerde.setSample(w, h, 0, intensidade);
			}
		return img;
	}
	public static BufferedImage converteVermelho(BufferedImage imgOriginal) {
		int height = imgOriginal.getHeight();
		int width = imgOriginal.getWidth();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = img.getRaster();
		WritableRaster rasterVermelho = img.getRaster();
		for(int h = 0; h < height; h++)
			for(int w = 0; w < width; w++) {
				Color color = new Color(imgOriginal.getRGB(w, h));
				int intensidade = color.getRed();
				rasterVermelho.setSample(w, h, 0, intensidade);
			}
		return img;
	}
	public static BufferedImage reduzImagem(BufferedImage imgOriginal) {
		int height = imgOriginal.getHeight();
		int width = imgOriginal.getWidth();
		BufferedImage img = new BufferedImage(width / 4, height / 4, BufferedImage.TYPE_INT_RGB);
		WritableRaster raster = imgOriginal.getRaster();
		WritableRaster rasterReduzida = img.getRaster();

		int hMenor = 0;
		for (int h = 0; h < height; h += 4) {
			int wMenor = 0;
			for (int w = 0; w < width; w += 4) {
				rasterReduzida.setSample(wMenor, hMenor, 0, raster.getSample(w, h, 0));
				rasterReduzida.setSample(wMenor, hMenor, 1, raster.getSample(w, h, 1));
				rasterReduzida.setSample(wMenor, hMenor, 2, raster.getSample(w, h, 2));
				wMenor++;
			}
			hMenor++;
		}

		return img;
	}
	public static BufferedImage converteEmCinza(BufferedImage imgOriginal) {
		int height = imgOriginal.getHeight();
		int width = imgOriginal.getWidth();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = img.getRaster();
		for(int h = 0; h < height; h++)
			for(int w = 0; w < width; w++) {
				Color color = new Color(imgOriginal.getRGB(w, h));
				int r = (int) (color.getRed() * 0.3);
				int g = (int) (color.getGreen() * 0.59);
				int b = (int) (color.getBlue() * 0.11);
				raster.setSample(w, h, 0, r + g + b);
			}
		return img;
	}

	public static BufferedImage criaImagemCinza() {
		BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_BYTE_GRAY);
		WritableRaster raster = img.getRaster();
		for(int h=0;h<256;h++)
			for(int w=0;w<256;w++) {
				raster.setSample(w,h,0,h);//como o h = 0 e vai aumentando, cada linha vai ficando mais clara
			}
		return img;
	}

	public static BufferedImage converteEmBinaria(BufferedImage imgCinza) {
		int height = imgCinza.getHeight();
		int width = imgCinza.getWidth();
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);

		WritableRaster rasterCinza = imgCinza.getRaster();
		WritableRaster rasterBinaria = img.getRaster();
		for(int h = 0; h < height; h++)
			for(int w = 0; w < width; w++) {
				int intensidade = rasterCinza.getSample(w, h, 0);
				if (intensidade >= 127)
					rasterBinaria.setSample(w,h,0,1);
				else rasterBinaria.setSample(w,h,0,0);
			}
		return img;
	}

	public static BufferedImage criaImagemBinaria() {
		BufferedImage img = new BufferedImage(256, 256, BufferedImage.TYPE_BYTE_BINARY);
		WritableRaster raster = img.getRaster();
		for(int h=0;h<256;h++)
			for(int w=0;w<256;w++) {
				if (((h/50)+(w/50)) % 2 == 0)
					raster.setSample(w,h,0,0); // checkerboard pattern.
				else raster.setSample(w,h,0,1);
			}
		return img;
	}

	// Imprime valores dos pixeis de imagem RGB
	public static void  imprimePixeis(BufferedImage bufferedImage) {
		// Get a pixel
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();

		for(int h=0;h<height;h++)
			for(int w=0;w<width;w++) {
				int rgb = bufferedImage.getRGB(w,h);
				int r = (int)((rgb&0x00FF0000)>>>16); // componente vermelho
				int g = (int)((rgb&0x0000FF00)>>>8); // componente verde
				int b = (int)(rgb&0x000000FF); //componente azul
				System.out.print("at ("+w+","+h+"): ");
				System.out.println(r+","+g+","+b);
			}
	}

	public static void main(String[] args) {
		ImageApp ia = new ImageApp();
		BufferedImage imgJPEG = loadImage("http://www.inf.ufsc.br/~willrich/INE5431/RGB.jpg");

		BufferedImage imgCinza = converteEmCinza(imgJPEG);
		BufferedImage imgBinaria = converteEmBinaria(imgCinza);
		BufferedImage imgReduzida = reduzImagem(imgJPEG);
		BufferedImage imgVermelha = converteVermelho(imgJPEG);
		BufferedImage imgVerde = converteVerde(imgJPEG);
		BufferedImage imgAzul = converteAzul(imgJPEG);
		ia.apresentaImagem(new JFrame("imgCinza"), imgCinza);
		ia.apresentaImagem(new JFrame("imgBinaria"), imgBinaria);
		ia.apresentaImagem(new JFrame("imgReduzida"), imgReduzida);
		ia.apresentaImagem(new JFrame("imgVermelha"), imgVermelha);
		ia.apresentaImagem(new JFrame("imgVerde"), imgVerde);
		ia.apresentaImagem(new JFrame("imgAzul"), imgAzul);
	}
}
