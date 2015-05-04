package controlador;

import java.util.Scanner;

import controlador.Batalha;

public class Controller {
	public void run(Scanner scanIn) {
		Event e;

		Pokemon[] pkmnRed = new Pokemon[6];

		Move[] movPik = new Move[4];
		movPik[0] = new Move("Charm", 0, 2);
		movPik[1] = new Move("Quick Attack", 40, 1);
		movPik[2] = new Move("Thunderbolt", 90, 2);
		movPik[3] = new Move("Thunder", 110, 2);
		pkmnRed[0] = new Pokemon("Pikachu", 206, movPik);

		Move[] movEsp = new Move[4];
		movEsp[0] = new Move("Mud-Slap", 20, 2);
		movEsp[1] = new Move("Swift", 60, 2);
		movEsp[2] = new Move("Reflect", 0, 2);
		movEsp[3] = new Move("Psychic", 90, 2);
		pkmnRed[1] = new Pokemon("Espeon", 200, movEsp);

		Move[] movSnr = new Move[4];
		movSnr[0] = new Move("Amnesia", 0, 2);
		movSnr[1] = new Move("Snore", 0, 2);
		movSnr[2] = new Move("Rest", 0, 2);
		movSnr[3] = new Move("Body Slam", 85, 2);
		pkmnRed[2] = new Pokemon("Snorlax", 385, movSnr);

		Move[] movVns = new Move[4];
		movVns[0] = new Move("Sunny Day", 0, 2);
		movVns[1] = new Move("Giga Drain", 75, 2);
		movVns[2] = new Move("Synthesis", 0, 2);
		movVns[3] = new Move("Solar Beam", 120, 2);
		pkmnRed[3] = new Pokemon("Venusaur", 271, movVns);

		Move[] movCrz = new Move[4];
		movCrz[0] = new Move("Flamethrower", 90, 2);
		movCrz[1] = new Move("Wing Attack", 60, 2);
		movCrz[2] = new Move("Slash", 70, 2);
		movCrz[3] = new Move("Fire Spin", 105, 2);
		pkmnRed[4] = new Pokemon("Charizard", 271, movCrz);

		Move[] movBlst = new Move[4];
		movBlst[0] = new Move("Rain Dance", 0, 2);
		movBlst[1] = new Move("Surf", 95, 2);
		movBlst[2] = new Move("Blizzard", 120, 2);
		movBlst[3] = new Move("Whirlpool", 105, 2);
		pkmnRed[5] = new Pokemon("Blastoise", 258, movBlst);

		Treinador red = new Treinador("Red", pkmnRed);

		Pokemon[] pkmnBlu = new Pokemon[6];

		Move[] movSnd = new Move[4];
		movSnd[0] = new Move("Slash", 70, 2);
		movSnd[1] = new Move("Fury Swipes", 54, 1);
		movSnd[2] = new Move("Poison Sting", 15, 2);
		movSnd[3] = new Move("Earthquake", 100, 2);
		pkmnBlu[0] = new Pokemon("Sandslash", 202, movSnd);

		Move[] movAlk = new Move[4];
		movAlk[0] = new Move("Psychic", 90, 2);
		movAlk[1] = new Move("Kinesis", 0, 2);
		movAlk[2] = new Move("Psybeam", 65, 2);
		movAlk[3] = new Move("Recover", 0, 2);
		pkmnBlu[1] = new Pokemon("Alakazam", 172, movAlk);

		Move[] movExg = new Move[4];
		movExg[0] = new Move("Leech Seed", 0, 2);
		movExg[1] = new Move("Barrage", 45, 2);
		movExg[2] = new Move("Hypnosis", 0, 2);
		movExg[3] = new Move("Stopm", 65, 2);
		pkmnBlu[2] = new Pokemon("Exeggutor", 227, movExg);

		Move[] movClt = new Move[4];
		movClt[0] = new Move("Spike Cannon", 60, 2);
		movClt[1] = new Move("Ice Beam", 95, 2);
		movClt[2] = new Move("Clamp", 105, 2);
		movClt[3] = new Move("Aurora Beam", 65, 2);
		pkmnBlu[3] = new Pokemon("Cloyster", 172, movClt);

		Move[] movNit = new Move[4];
		movNit[0] = new Move("Fire Spin", 105, 2);
		movNit[1] = new Move("Tail Whip", 0, 2);
		movNit[2] = new Move("Quick Attack", 40, 2);
		movNit[3] = new Move("Cofuse Ray", 0, 2);
		pkmnBlu[4] = new Pokemon("Ninetales", 206, movNit);

		Move[] movJlt = new Move[4];
		movJlt[0] = new Move("Thunder", 120, 2);
		movJlt[1] = new Move("Thunderbolt", 95, 2);
		movJlt[2] = new Move("Quick Attack", 40, 2);
		movJlt[3] = new Move("Pin Missile", 42, 2);
		pkmnBlu[5] = new Pokemon("Jolteon", 202, movJlt);

		Treinador blue = new Treinador("Blue", pkmnBlu);

		
		boolean continua = true;
		Batalha bt = new Batalha();

		while (continua) {
			e = bt.new Rodada(red, blue, scanIn);
			continua = e.action(red, blue);
		}
	}
	
	static Scanner scanIn;
	
	public static void main(String[] args) {
		Controller c = new Controller();
		
		scanIn = new Scanner(System.in);
		c.run(scanIn);
		scanIn.close();
	}
}
