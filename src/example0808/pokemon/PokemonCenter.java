package example0808.pokemon;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class PokemonCenter {
    protected Random random = new Random();
    protected PokemonArchive pokemonArchive;
    private ArrayList<String> apperPokemon;

    public PokemonCenter(PokemonArchive pokemonArchive){
        this.pokemonArchive = pokemonArchive;
    }
    public void initAppearPokemon(){
        apperPokemon = new ArrayList<>();
        apperPokemon.add("파이리");
        apperPokemon.add("꼬북이");
        apperPokemon.add("이상해씨");
    }

    public Pokemon initPokemon(String name, String Nickname){
        Pokemon pokemon = new Pokemon(Nickname);
        pokemon.setInitPokeStat(randomStat(name));
        pokemon.setInitPokeSkill(randomSkill(name));
        return pokemon;
    }
    public String randomPick(){
        System.out.println(this.apperPokemon+"중 플레이어의 포켓몬을 뽑습니다");
        int num = this.random.nextInt(3);
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
    public void match(Pokemon myPokemon, Pokemon opponetPokemon){
        System.out.println(opponetPokemon);
        Pokemon attacker = chooseFirstAttack(myPokemon, opponetPokemon);
        Pokemon defender = (attacker == myPokemon) ? opponetPokemon : myPokemon;
//        System.out.println(attacker.getName()+"먼저 공격!!");
        while(checkHpStatus(myPokemon,opponetPokemon)) {
            attack(attacker, defender);
            Pokemon temp = attacker;
            attacker = defender;
            defender = temp;
        }
        winner(myPokemon,opponetPokemon);
    }
    public Pokemon chooseFirstAttack(Pokemon myPokemon, Pokemon opponetPokemon){
        if (Integer.parseInt(myPokemon.getStatMap().get("speed")) > Integer.parseInt(opponetPokemon.getStatMap().get("speed"))) {
            return myPokemon;
        }
        return opponetPokemon ;
    }
    public void attack(Pokemon attacker, Pokemon defender) {
        int calculatedPower = calculateAttackDamage(attacker);
        System.out.println(" (데미지:"+calculatedPower+" ) ");
        updateHpStatus(defender, calculatedPower);
    }
    public void updateHpStatus(Pokemon pokemon, int damage) {
        pokemon.setHpStatus(pokemon.getHpStatus() - damage);
    }
    public int calculateAttackDamage(Pokemon pokemon) {
        int damage = chooseSkillDamage(pokemon);
        return (int) ((damage * Integer.parseInt(pokemon.getStatMap().get("power"))*0.01) * 0.5);
    }

    public boolean checkHpStatus(Pokemon pokemon1,Pokemon pokemon2){
        return pokemon1.getHpStatus() > 0 && pokemon2.getHpStatus() > 0;
    }
    public int chooseSkillDamage(Pokemon pokemon) {
        Map<String, Integer> skillMap = pokemon.getSkillMap();
        List<String> skills = new ArrayList<>(skillMap.keySet());
        int skillNum = random.nextInt(skills.size());
        String chosenSkill = skills.get(skillNum);
        System.out.print(pokemon.getName()+"의 "+chosenSkill+" 공격!");
        return skillMap.get(chosenSkill);
    }
    public void winner(Pokemon pokemon1,Pokemon pokemon2){
        if (pokemon1.getHpStatus() <= 0) {
            System.out.println("=============WINNER==============\n"+
                                pokemon2.getName() + "의 승리!\n" +
                                "================================");
        } else if (pokemon2.getHpStatus() <= 0) {
            System.out.println("=============WINNER==============\n"+
                                pokemon1.getName() + "의 승리!\n" +
                                "================================");
        }
    }
    public void hospital(String name,Pokemon pokemon){
        int beforeHp = pokemon.getHpStatus();
        if(beforeHp <0) beforeHp=0;
        int originalHp = Integer.parseInt(this.pokemonArchive.getPokemonStat(name).get("hp"));
        pokemon.setHpStatus(originalHp);
        System.out.println("++++++++++HOSPITAL+++++++++");
        System.out.println("HP : "+beforeHp+" -> "+originalHp);
        System.out.println("+++++++++++++++++++++++++++");
    }
}
