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
        return name +"의 상태입니다.\n"+
                     "현재 채력 " + hpStatus + "\n"+
                     "능력창 " + statMap + "\n"+
                     "스킬창 " + skillMap;
    }
}

