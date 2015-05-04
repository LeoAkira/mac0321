package controlador;

import java.util.Scanner;

public class Batalha extends Controller {
	private class Fight1 extends Event {

		public Fight1(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}

		public boolean action(Treinador atac, Treinador def) {
			int resposta;
			Event e;
			resposta = escolherAtaque(atac, scanIn);
			atacar(atac, def, resposta);
			if (!def.pokemonAtivo.vivo) {
				e = new Trocar(def, atac, scanIn);
				e.action(def, atac);
			}
			if (!algumVivo(def)) {
				System.out.println(atac.name + " won the battle!");
				return false;
			}
			return true;
		}
	}

	private class Fight2 extends Event {

		public Fight2(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}

		public boolean action(Treinador prim, Treinador seg) {
			int resp1;
			int resp2;
			int prio1;
			int prio2;
			Event e;

			resp1 = escolherAtaque(prim, scanIn);
			resp2 = escolherAtaque(seg, scanIn);

			prio1 = prim.pokemonAtivo.moves[resp1].prioridade;
			prio2 = seg.pokemonAtivo.moves[resp2].prioridade;

			if (prio1 <= prio2) {
				atacar(prim, seg, resp1);
				if (seg.pokemonAtivo.vivo) {
					atacar(seg, prim, resp2);
					if (!prim.pokemonAtivo.vivo) {
						e = new Trocar(prim, seg, scanIn);
						e.action(prim, seg);
					}

				} else {
					e = new Trocar(prim, seg, scanIn);
					e.action(prim, seg);
				}

			} else {
				atacar(seg, prim, resp2);
				if (prim.pokemonAtivo.vivo) {
					atacar(prim, seg, resp1);
					if (!seg.pokemonAtivo.vivo) {
						e = new Trocar(prim, seg, scanIn);
						e.action(prim, seg);
					}

				} else {
					e = new Trocar(prim, seg, scanIn);
					e.action(prim, seg);
				}
			}

			if (!algumVivo(prim)) {
				System.out.println(seg.name + " won the battle!");
				return false;
			} else if (!algumVivo(seg)) {
				System.out.println(prim.name + " won the battle!");
				return false;
			}
			return true;
		}
	}
	
	public class Fight3 extends Event {
		public Fight3(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}
		
		public boolean action (Treinador prim, Treinador seg) {
			int resp1;
			int resp2;
			int prio1;
			int prio2;
			Event e;

			resp1 = escolherAtaque(prim, scanIn);
			resp2 = (int)(Math.random()*4);

			prio1 = prim.pokemonAtivo.moves[resp1].prioridade;
			prio2 = seg.pokemonAtivo.moves[resp2].prioridade;

			if (prio1 <= prio2) {
				atacar(prim, seg, resp1);
				if (seg.pokemonAtivo.vivo) {
					atacar(seg, prim, resp2);
					if (!prim.pokemonAtivo.vivo) {
						e = new Trocar(prim, seg, scanIn);
						e.action(prim, seg);
					}

				}
				
			}
			else {
				atacar(seg, prim, resp2);
				if (prim.pokemonAtivo.vivo) {
					atacar(prim, seg, resp1);
				} else {
					e = new Trocar(prim, seg, scanIn);
					e.action(prim, seg);
				}
			}

			if (!algumVivo(prim)) {
				System.out.println(seg.name + " won the battle!");
				return false;
			} else if (!algumVivo(seg)) {
				System.out.println(prim.name + " won the battle!");
				return false;
			}
			return true;
		}
	}
	
	private class Fight4 extends Event {

		public Fight4(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}

		public boolean action(Treinador atac, Treinador def) {
			int resposta;
			Event e;
			resposta = (int)(Math.random()*4);
			atacar(atac, def, resposta);
			if (!def.pokemonAtivo.vivo) {
				e = new Trocar(def, atac, scanIn);
				e.action(def, atac);
			}
			if (!algumVivo(def)) {
				System.out.println(atac.name + " won the battle!");
				return false;
			}
			return true;
		}
	}
	
	public class Run extends Event {

		public Run(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}

		public boolean action(Treinador arregao, Treinador vencedor) {
			System.out.println(arregao.name + " has fled.");
			System.out.println(vencedor.name + " won the battle!");
			return false;
		}
	}

	private class Bag extends Event {

		public Bag(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}

		public boolean action(Treinador t, Treinador esperando) {
			int resp1;
			int resp2;
			int i;
			System.out.println("Which item do you want to use?");
			System.out.println("1: Potion (restores 20 HP)");
			System.out.println("2: Hyper Potion (restores 50 HP)");

			resp1 = scanIn.nextInt();

			System.out.println("On which Pokemon do you want to use this?");
			for (i = 0; i < 6; i++) {
				System.out.println((i + 1) + ": " + t.pokemons[i].nickname);
			}

			resp2 = scanIn.nextInt() - 1;

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

		public Trocar(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}

		public boolean action(Treinador t, Treinador esperando) {
			int i;
			int resp;
			System.out.println("To which pokemon do you want to change?");
			for (i = 0; i < t.pokemons.length; i++) {
				System.out.println((i + 1) + ": " + t.pokemons[i].nickname);
			}
			resp = scanIn.nextInt();
			System.out.println("Come back " + t.pokemonAtivo.nickname + "!");
			t.pokemonAtivo.ativo = false;
			t.pokemonAtivo = t.pokemons[resp - 1];
			t.pokemonAtivo.ativo = true;
			System.out.println("Go " + t.pokemonAtivo.nickname + "!");
			return true;
		}
	}

	public class Rodada extends Event {

		public Rodada(Treinador atual, Treinador enemy, Scanner scanIn) {
			super(atual, enemy, scanIn);
		}

		public boolean action(Treinador prim, Treinador seg) {
			int resp1;
			int resp2;
			Event e = null;

			System.out.println("What will " + prim.name + " do?");
			System.out.println("1: Fight");
			System.out.println("2: Bag");
			System.out.println("3: Pokemon");
			System.out.println("4: Run");

			resp1 = scanIn.nextInt();

			if (resp1 == 4) {
				e = new Run(prim, seg, scanIn);
				e.continua = e.action(prim, seg);
				return e.continua;
			}
			
			if (!seg.selvagem) {
				System.out.println("What will " + seg.name + " do?");
				System.out.println("1: Fight");
				System.out.println("2: Bag");
				System.out.println("3: Pokemon");
				System.out.println("4: Run");
	
				resp2 = scanIn.nextInt();
			}
			else
				resp2 = 1;
			

			if (resp2 == 4) {
				e = new Run(seg, prim, scanIn);
				e.continua = e.action(seg, prim);
				return e.continua;
			}
			if (resp1 == 3) {
				e = new Trocar(prim, seg, scanIn);
				e.continua = e.action(prim, seg);
			}
			if (resp2 == 3) {
				e = new Trocar(seg, prim, scanIn);
				e.continua = e.action(seg, prim);
			}
			if (resp1 == 2) {
				e = new Bag(prim, seg, scanIn);
				e.continua = e.action(prim, seg);
			}
			if (resp2 == 2) {
				e = new Bag(seg, prim, scanIn);
				e.continua = e.action(seg, prim);
			}
			if (resp1 == 1) {
				if (resp2 == 1) {
					if (!seg.selvagem) 
						e = new Fight2(prim, seg, scanIn);
					else 
						e = new Fight3(prim, seg, scanIn);
					e.continua = e.action(prim, seg);
					return e.continua;
				} else {
					e = new Fight1(prim, seg, scanIn);
					e.continua = e.action(prim, seg);
				}

			}
			if (resp2 == 1) {
				if (!seg.selvagem) 
					e = new Fight1(seg, prim, scanIn);
				else
					e = new Fight4(seg, prim, scanIn);
				
				e.continua = e.action(seg, prim);
			}
			return e.continua;
		}
	}

	public boolean algumVivo(Treinador t) {
		int i;
		for (i = 0; i < t.pokemons.length; i++) {
			if (t.pokemons[i].vivo)
				return true;
		}
		return false;
	}

	public void atacar(Treinador atac, Treinador def, int resp) {
		atac.pokemonAtivo.moves[resp].attack(def.pokemonAtivo);
		System.out.println(atac.pokemonAtivo.nickname + " used "
				+ atac.pokemonAtivo.moves[resp].name + "!");
		System.out.println(def.pokemonAtivo.nickname + " HP: "
				+ def.pokemonAtivo.Hp + "/" + def.pokemonAtivo.maxHp);
		if (!def.pokemonAtivo.vivo) {
			System.out.println(def.pokemonAtivo.nickname + " has fainted!");
		}
	}

	public int escolherAtaque(Treinador blado, Scanner scanIn) {
		int resposta;
		int i;
		System.out.println("What will " + blado.pokemonAtivo.nickname + " do?");
		for (i = 0; i < 4; i++) {
			System.out.println(i + 1 + ": " + blado.pokemonAtivo.moves[i].name);
		}

		resposta = scanIn.nextInt();

		return resposta - 1;
	}
}
