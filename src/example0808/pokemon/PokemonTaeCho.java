package example0808.pokemon;

import java.util.*;

public class PokemonTaeCho extends PokemonCenter {
    private ArrayList<String> apperPokemon;

    public PokemonTaeCho(PokemonArchive pokemonArchive) {
        super(pokemonArchive);
    }
    @Override
    public void initAppearPokemon() {
        apperPokemon = new ArrayList<>();
        apperPokemon.add("뚜벅초");
        apperPokemon.add("고라파덕");
        apperPokemon.add("가디");
    }
    public Pokemon initPokemon(){
        String pickedPokemon = randomPick();
        Pokemon pokemon = new Pokemon(pickedPokemon);
        pokemon.setInitPokeStat(randomStat(pickedPokemon));
        pokemon.setInitPokeSkill(randomSkill(pickedPokemon));
        System.out.println("야생의 "+pickedPokemon+"가 나타났다!");
        return pokemon;
    }
    public String randomPick(){
        int num = super.random.nextInt(3);
        return this.apperPokemon.get(num);
    }
    @Override
    public Map<String,String> randomStat(String name){
        Map<String,String> stat = super.pokemonArchive.getPokemonStat(name);
        String[] keys = {"hp", "power", "speed"};
        for (String key : keys) {
            int currentValue = Integer.parseInt(stat.get(key));
            currentValue += random.nextInt(10) - 5;
            stat.replace(key, String.valueOf(currentValue));
        }
        return stat;
    }
}
