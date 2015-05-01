package controlador;

import java.util.Scanner;

public class Batalha extends Controller {
		/*public boolean action(Treinador primeiro, Treinador segundo) {
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
			scanIn2.close();

			if (resposta1 == 4) {
				run(primeiro);
				return false;
			}
			if (resposta2 == 4) {
				run(segundo);
				return false;
			}
			if (resposta1 == 3) {
				trocar(primeiro);
			}
			if (resposta2 == 3) {
				trocar(segundo);
			}
			if (resposta1 == 2) {
				bag(primeiro);
			}
			if (resposta2 == 2) {
				bag(segundo);
			}
			if (resposta1 == 1) {
				if (resposta2 == 1) {
					fight2(primeiro, segundo);
					if (!algumVivo(primeiro))
						return false;
					if (!algumVivo(segundo))
						return false;
					return true;
				} else {
					fight1(primeiro, segundo);
					if (!algumVivo(segundo))
						return false;
				}

			}
			if (resposta2 == 1) {
				fight1(segundo, primeiro);
				if (!algumVivo(primeiro))
					return false;
			}
			return true;
		}*/

	public class Fight1 extends Event {
		public boolean action (Treinador atac, Treinador def) {
			int resposta;
			resposta = escolherAtaque(atac);
			atacar(atac, def, resposta);
			if(!algumVivo(def))
				return false;
			return true;
		}
	}

	private class Fight2 extends Event {
		public boolean action (Treinador prim, Treinador seg) {
			int resp1;
			int resp2;
			int prio1;
			int prio2;
			Trocar t = new Trocar();
			

			resp1 = escolherAtaque(prim);
			resp2 = escolherAtaque(seg);

			prio1 = prim.pokemonAtivo.moves[resp1].prioridade;
			prio2 = seg.pokemonAtivo.moves[resp2].prioridade;

			if (prio1 >= prio2) {
				atacar(prim, seg, resp1);
				if (seg.pokemonAtivo.vivo) {
					atacar(seg, prim, resp2);
				} else
					t.action(seg, prim);
					
			} else {
				atacar(seg, prim, resp2);
				if (prim.pokemonAtivo.vivo) {
					atacar(prim, seg, resp1);
				} else
					t.action(prim, seg);
			}
			
			if (!algumVivo(prim) || !algumVivo(seg))
				return false;
			return true;
		}
	}

	private class Run extends Event {
		public boolean action (Treinador arregao, Treinador vencedor) {
			System.out.println(arregao.name + " has fled.");
			return false;
		}
	}

	private class Bag extends Event {
		public boolean action (Treinador t, Treinador esperando) {
			int resp1;
			int resp2;
			int i;
			System.out.println("Which item do you want to use?");
			System.out.println("1: Potion (restores 20 HP)");
			System.out.println("2: Hyper Potion (restores 50 HP");

			Scanner scanIn = new Scanner(System.in);
			resp1 = scanIn.nextInt();
			scanIn.close();

			System.out.println("On which Pokemon do you want to use this?");
			for (i = 0; i < 6; i++) {
				System.out.println((i + 1) + ": " + t.pokemons[i].nickname);
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
			System.out.println(t.pokemons[resp2].nickname + " HP: "
					+ t.pokemons[resp2].Hp + "/" + t.pokemons[resp2].maxHp);
			return true;
		}
	}

	private class Trocar extends Event {
		public boolean action (Treinador t, Treinador esperando) {
			int i;
			int resp;
			System.out.println("Para qual pokemon deseja trocar?");
			for (i = 0; i < 6; i++) {
				System.out.println((i + 1) + ": " + t.pokemons[i].nickname);
			}
			Scanner scanIn = new Scanner(System.in);
			resp = scanIn.nextInt();
			scanIn.close();
			t.pokemonAtivo = t.pokemons[resp - 1];
			return true;
		}
	}

	public boolean algumVivo(Treinador t) {
		int i;
		for (i = 0; i < 6; i++) {
			if (t.pokemons[i].vivo)
				return true;
		}
		return false;
	}
	
	public void atacar(Treinador atac, Treinador def, int resp) {
		atac.pokemonAtivo.moves[resp].attack(def.pokemonAtivo);
		System.out.println(def.pokemonAtivo.nickname + " HP: "
				+ def.pokemonAtivo.Hp + "/" + def.pokemonAtivo.maxHp);
		if (def.pokemonAtivo.Hp == 0) {
			System.out.println(def.pokemonAtivo.nickname + " has fainted.");
			def.pokemonAtivo.vivo = false;
		}
	}

	public int escolherAtaque(Treinador blado) {
		int resposta;
		int i;
		System.out.println("What will " + blado.pokemonAtivo.nickname
				+ " do?");
		for (i = 0; i < 4; i++) {
			System.out.println(i + 1 + ": "
					+ blado.pokemonAtivo.moves[i].name);
		}

		Scanner scanIn = new Scanner(System.in);
		resposta = scanIn.nextInt();
		scanIn.close();
		return resposta;
	}
}
