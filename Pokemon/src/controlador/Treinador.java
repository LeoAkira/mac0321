package controlador;

public class Treinador {
	String name;
	Pokemon[] pokemons;
	Pokemon pokemonAtivo;
	public Treinador(String nome, Pokemon[] pokemons){
		this.name = nome;
		this.pokemons = pokemons;
		this.pokemonAtivo = pokemons[0];
		this.pokemons[0].ativo = true;
	}
}
