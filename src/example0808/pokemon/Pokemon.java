package example0808.pokemon;

import java.util.Map;

public class Pokemon {
    private String name;
    private int hpStatus;

    private Map<String,String> statMap;

    private Map<String,Integer> skillMap;


    public Pokemon(String name) {
        this.name = name;
    }
    public void setInitPokeStat(Map<String,String> statMap){
        this.hpStatus = Integer.parseInt(statMap.get("hp"));
        this.statMap = statMap;
    }

    public void setInitPokeSkill(Map<String,Integer> skillMap){
        this.skillMap = skillMap;
    }
    @Override
    public String toString() {
        return       "=============INFORMATION============\n"+
                     "이름 : " + name + "\n"+
                     "현재 체력 : " + hpStatus + "\n"+
                     "능력 : " + statMap + "\n"+
                     "스킬 : " + skillMap + "\n"+
                     "===================================";
    }
    public String getName() {
        return name;
    }

    public int getHpStatus() {
        return hpStatus;
    }

    public void setHpStatus(int hpStatus) {
        this.hpStatus = hpStatus;
    }

    public Map<String, String> getStatMap() {
        return statMap;
    }

    public Map<String, Integer> getSkillMap() {
        return skillMap;
    }


}

