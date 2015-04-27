package controlador;

import java.util.Scanner;

public class Batalha extends Controller {
	private class Rodada extends Event {

		public void action(Treinador primeiro, Treinador segundo) {
			int i;
			int resposta1;
			int resposta2;

			System.out.println("What will " + primeiro.name + " do?");
			System.out.println("1: Fight");
			System.out.println("2: Bag");
			System.out.println("3: Pokemon");
			System.out.println("4: Run");

			Scanner scanIn = new Scanner(System.in);
			resposta1 = scanIn.nextInt();
			scanIn.close();

			System.out.println("What will " + segundo.name + " do?");
			System.out.println("1: Fight");
			System.out.println("2: Bag");
			System.out.println("3: Pokemon");
			System.out.println("4: Run");

			Scanner scanIn2 = new Scanner(System.in);
			resposta2 = scanIn2.nextInt();
			scanIn.close();

			if (resposta1 < resposta2) {

			}
			if (resposta1 == resposta2) {

			}
			if (resposta1 > resposta2) {

			}

			for (i = 0; i < 4; i++) {
				System.out.println((i + 1) + ": "
						+ primeiro.pokemonAtivo.moves[i]);
			}
			int resposta;
			Scanner scanIn3 = new Scanner(System.in);
			resposta = scanIn3.nextInt();
			scanIn3.close();
			if (resposta >= 1 && resposta <= 4) {

			}
		}

		public void Fight1(Treinador atac, Treinador def) {
			int resposta;
			resposta = escolherAtaque(atac);
			atacar(atac, def, resposta);
		}

		public void Fight2(Treinador prim, Treinador seg) {
			int resp1;
			int resp2;
			int prio1;
			int prio2;

			resp1 = escolherAtaque(prim);
			resp2 = escolherAtaque(seg);

			prio1 = prim.pokemonAtivo.moves[resp1].prioridade;
			prio2 = seg.pokemonAtivo.moves[resp2].prioridade;

			if (prio1 >= prio2) {
				atacar(prim, seg, resp1);
				atacar(seg, prim, resp2);
			} else {
				atacar(seg, prim, resp2);
				atacar(prim, seg, resp1);
			}
		}

		public void atacar(Treinador atac, Treinador def, int resp) {
			atac.pokemonAtivo.moves[resp].attack(def.pokemonAtivo);
			System.out.println(def.pokemonAtivo.name + " HP: "
					+ def.pokemonAtivo.Hp + "/" + def.pokemonAtivo.maxHp);
		}

		public int escolherAtaque(Treinador blado) {
			int resposta;
			int i;
			System.out.println("What will " + blado.pokemonAtivo.name + " do?");
			for (i = 0; i < 4; i++) {
				System.out.println(i + 1 + ": "
						+ blado.pokemonAtivo.moves[i].name);
			}

			Scanner scanIn = new Scanner(System.in);
			resposta = scanIn.nextInt();
			scanIn.close();
			return resposta;
		}

		public void Run(Treinador arregao) {
			System.out.println(arregao.name + " has fled.");
		}

		public void Bag(Treinador t) {
			int resp1;
			int resp2;
			int i;
			System.out.println("Which item do you want to use?");
			System.out.println("1: Potion (restores 20 HP)");
			System.out.println("2: Hyper Potion (restores 50 HP");

			Scanner scanIn = new Scanner(System.in);
			resp1 = scanIn.nextInt();
			scanIn.close();

			System.out.println("On which Pokémon do you want to use this?");
			for (i = 0; i < 6; i++) {
				System.out.println((i + 1) + ": " + t.pokemons[i].name);
			}

			Scanner scanIn2 = new Scanner(System.in);
			resp2 = scanIn2.nextInt() - 1;
			scanIn2.close();

			if (resp1 == 1) {
				if (t.pokemons[resp2].Hp + 20 > t.pokemons[resp2].maxHp)
					t.pokemons[resp2].Hp = t.pokemons[resp2].maxHp;
				else
					t.pokemons[resp2].Hp += 20;
			}
			if (resp1 == 2) {
				if (t.pokemons[resp2].Hp + 50 > t.pokemons[resp2].maxHp)
					t.pokemons[resp2].Hp = t.pokemons[resp2].maxHp;
				else
					t.pokemons[resp2].Hp += 50;
			}
			System.out.println(t.pokemons[resp2].name + " HP: "
					+ t.pokemons[resp2].Hp + "/" + t.pokemons[resp2].maxHp);
		}
	}
}
