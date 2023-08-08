package example0808.pokemon;

import java.util.*;

public class PokemonCenter {
    private Random random = new Random();

    private PokemonArchive pokemonArchive;
    private ArrayList<String> apperPokemon;

    public PokemonCenter(PokemonArchive pokemonArchive){
        this.pokemonArchive = pokemonArchive;

        apperPokemon = new ArrayList<>();
        apperPokemon.add("파이리");
        apperPokemon.add("꼬북이");
        apperPokemon.add("이상해씨");
    }

    public Pokemon initPockmon(String name, String Nickname){
        Pokemon pokemon = new Pokemon(Nickname);
        pokemon.setInitPokeStat(randomStat(name));
        pokemon.setInitPokeSkill(randomSkill(name));
        return pokemon;
    }
    public String randomPick(){
        System.out.println(this.apperPokemon+"중 플레이어의 포켓몬을 뽑습니다");
        int num = this.random.nextInt(2)+1;
        String pickedPoke = this.apperPokemon.get(num);
        System.out.println(pickedPoke+"의 이름을 입력해주세요");
        return pickedPoke;
    }
    public Map<String,String> randomStat(String name){
        Map<String,String> stat = this.pokemonArchive.getPokemonStat(name);
        String[] keys = {"hp", "power", "speed"};
        for (String key : keys) {
            int currentValue = Integer.parseInt(stat.get(key));
            currentValue += random.nextInt(21) - 10;
            stat.replace(key, String.valueOf(currentValue));
        }
        return stat;
    }
    public Map<String,Integer> randomSkill(String name){
        Map<String,Integer> skillMap = new HashMap<>();
        List<String> skillsOfType = this.pokemonArchive.getTypeToSkillsMap().get(this.pokemonArchive.getPokemonStat(name).get("type"));
        Collections.shuffle(skillsOfType);
        for (int i = 0; i < skillsOfType.size() && i < 2 ; i++) {
            String skill = skillsOfType.get(i);
            Integer power = this.pokemonArchive.getSkillNameToPower().get(skill);
            skillMap.put(skill, power);
        }
        return skillMap;
    }

    //대결기능
    //abstract void match();
}
