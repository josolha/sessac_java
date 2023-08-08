package example0808.pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokemonArchive {

    private Map<String, Map<String,String>> pokemonStat;
    private Map<String, Integer> skillNameToPower;
    private Map<String, List<String>> typeToSkillsMap;

    public PokemonArchive(){

    }
    public void makePokemonStat(int[][] pkStat,String[] pks,String[] pkType){
        pokemonStat = new HashMap<>();
        List<String> names = new ArrayList<>();
        names.add("hp");
        names.add("power");
        names.add("speed");
        names.add("type");

        for (int i = 0; i < pks.length; i++) {
            Map<String, String> stats = new HashMap<>();
            stats.put(names.get(0), String.valueOf(pkStat[i][0])); // hp
            stats.put(names.get(1), String.valueOf(pkStat[i][1])); // power
            stats.put(names.get(2), String.valueOf(pkStat[i][2])); // speed
            stats.put(names.get(3), pkType[i]); // type
            pokemonStat.put(pks[i], stats);
        }
        /*
        //CEHCK
        for (String pokemonName : pokemonStat.keySet()) {
        Map<String, String> stats = pokemonStat.get(pokemonName);
        System.out.println(pokemonName + ": " + stats);
        }*/
    }
    public void makeSkillNameToPower(String[] skills,int[] skillPower){
        skillNameToPower = new HashMap<>();

        for (int i = 0; i < skills.length; i++) {
            skillNameToPower.put(skills[i], skillPower[i]);
        }
        /*
        //CHECK
        for (Map.Entry<String, Integer> entry : skillNameToPower.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
    }
    public void makeTypeToSkillsMap(String[][] skillType,String[] skills){
        typeToSkillsMap = new HashMap<>();
        for (int i = 0; i < skillType.length; i++) {
            for (int j = 0; j < skillType[i].length; j++) {
                if (!typeToSkillsMap.containsKey(skillType[i][j])) {
                    typeToSkillsMap.put(skillType[i][j], new ArrayList<>());
                }
                typeToSkillsMap.get(skillType[i][j]).add(skills[i]);
            }
        }
        /*
        //CHECK
        for (Map.Entry<String, List<String>> entry : typeToSkillsMap.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
    }
    public Map<String, String> getPokemonStat(String pokemon) {
        Map<String, String> original = pokemonStat.get(pokemon); //put all도 사용가능 한번해보기
        if (original == null) {
            return null;
        }
        return new HashMap<>(original);
    }

    public Map<String, Integer> getSkillNameToPower() {
        return new HashMap<>(skillNameToPower);
    }
    public Map<String, List<String>> getTypeToSkillsMap() {
        Map<String, List<String>> copyMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : typeToSkillsMap.entrySet()) {
            copyMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
        }
        return copyMap;
    }
}
