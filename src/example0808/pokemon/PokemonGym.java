package example0808.pokemon;

public class PokemonGym extends PokemonCenter {

    private String apperPokemon = "이상해씨";

    public PokemonGym(PokemonArchive pokemonArchive) {
        super(pokemonArchive);
    }
    public Pokemon initPokemon(){
        Pokemon pokemon = new Pokemon(this.apperPokemon);
        pokemon.setInitPokeStat(randomStat(this.apperPokemon));
        pokemon.setInitPokeSkill(randomSkill(this.apperPokemon));
        System.out.println("야생의 "+this.apperPokemon+"가 나타났다!");
        return pokemon;
    }
}
