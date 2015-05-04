package controlador;

import java.util.Scanner;

public class Mapa {
	int[][] mapa = new int[7][11];
	static int t = 0;
	static int c = 1;
	static int g = 2;
	int px;
	int py;
	
	public Mapa() {
		int i;
		int j;
		
		px = 0;
		py = 0;
		
		for (i = 0; i < 7; i++) {
			for (j = 0; j < 11; j++)
				mapa[i][j] = c;
		}

		for (i = 7; i < 11; i++)
			mapa[0][i] = g;
		for (i = 1; i < 7; i++) {
			for (j = 9; j < 11; j++)
				mapa[i][j] = g;
		}

		for (i = 2; i < 6; i++) {
			for (j = 0; j < 6; j++)
				mapa[i][j] = g;
		}
	}

	public void imprimeMapa() {
		int i;
		int j;
		System.out.println("");
		for (i = 0; i < 7; i++) {
			System.out.print("  ");
			for (j = 0; j < 11; j++) {
				if (i == py && j == px)
					System.out.print("⍢⃝");
				else if (mapa[i][j] == 1)
					System.out.print("_");
				else if (mapa[i][j] == 2)
					System.out.print("w");
			}
			System.out.println("");
		}
	}

	public int andar(Scanner scanIn) {
		int resposta;
		System.out.println("\nWhere do you want to go?");
		System.out.println("1: ↑");
		System.out.println("2: ↓");
		System.out.println("3: ←");
		System.out.println("4: →");
		System.out.println("5: Chega!!!!!11!onze!");
		
		resposta = scanIn.nextInt();

		
		if (resposta == 1 && py != 0)
			py--;
		if (resposta == 2 && py != 6)
			py++;
		if (resposta == 3 && px != 0)
			px--;
		if (resposta == 4 && px != 10)
			px++;
		
		if (resposta == 5)
			return 2;
		if (mapa[py][px] == g)
			return 1;
		else 
			return 0;
	}
	
	public void temPokemon(Scanner scanIn) {
		if (Math.random() > 0.8) {
			Controller c = new Controller();
			c.run(scanIn, true);
			imprimeMapa();
		}
	}
	
	public static void main(String[] args) {
		Mapa m = new Mapa();
		int resposta;
		boolean continua = true;
		Scanner scanIn = new Scanner(System.in);
		
		m.imprimeMapa();
		while (continua) {
			resposta = m.andar(scanIn);
			m.imprimeMapa();
			if (resposta == 1) {
				m.temPokemon(scanIn);
			}
			if (resposta == 2)
				continua = false;
		}
		
		scanIn.close();
	}
}
