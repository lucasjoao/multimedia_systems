/**
 * @author Roberto Willrich
 * 
 * Aplicao Java usada para gerar arquivo CUIF a partir de um arquivo BMP (Windows Bitmap)
 * 
 * Exemplo de uso: java bmp2cuif --version 1 lena.bmp lena.cuif
 *  
 */

public class bmp2cuif {
	
	public static void main(String[] args) {
	
		// Analisa argumentos
	    if (args.length!=4) {
	    	System.out.println("Nmero errado de argumentos:" + args.length);
	    	System.out.println("Sintaxe: java bmp2cuif --version <version> <arquivo entrada> <arquivo saida>");
	    	return;
	    }
	    String arg1 = args[0].toLowerCase().trim();
	    if (!arg1.equals("--version")) {
	    	System.out.println("Argumento desconhecido: " + args[0]);
	    	System.out.println("Sintaxe: java bmp2cuif --version <version> <arquivo entrada> <arquivo saida>");
	    	return;
	    }
	    try {
	    	int version = Integer.parseInt(args[1]);
	    	if (version !=1) {
		    	System.out.println("Verso no suportada");
		    	return;
	    	}
	    } catch (NumberFormatException e) {
	    	System.out.println("Verso no suportada");
	    }
	    	
	    String inputFile = args[2];
	    String outputFile = args[3];
	    
	    try {
	    	// Leitura de arquivo bmp 
	    	Bitmap bmpimg = new Bitmap(inputFile);
	    	
	    	// Criao de do arquivo Cuif1 a partir da leutura do arquivo lena.bmp
	    	// modifique numero_estudantes e id_estudante indicando o nmero de membros da equipe e a matrcula dos membros
	    	int numero_de_estudantes = 2;
	    	int[] id_estudante = {15100737, 15100752}; 
	    	Cuif lenacuif = new Cuif(bmpimg,1, numero_de_estudantes,id_estudante);
	    	lenacuif.save(outputFile);

	    } catch (Exception ioex) {
	    	ioex.printStackTrace();
	    }
	  }
  }
