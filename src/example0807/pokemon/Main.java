package example0807.pokemon;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String[] skills  = {"몸통박치기", "할퀴기", "울부짖기", "하이드로펌프", "물대포", "파도타기", "불대문자", "니트로차지", "솔라빔", "풀베기"};
        String[][] skillType = {{"물","불","풀"}, {"불","풀"}, {"물","불","풀"}, {"물"}, {"물"}, {"물"}, {"불"}, {"불"}, {"풀"}, {"풀"}};
        int[] skillPower = {60,50,20,100,90,90,120,70,110,80};
        String[] pks = {"꼬북이","파이리","이상해씨","뚜벅초","고라파덕","가디"};
        String[] pkType = {"물","불","풀","풀","물","불"};
        int[][] pkStat ={{250,90,90}, {150,120,90}, {200,100,90}, {150,80,80}, {160,80,80}, {150,90,100}};

        //1.아카이브 생성
        PokemonArchive PokeArch = new PokemonArchive();
        PokeArch.makePokemonStat(pkStat,pks,pkType);
        PokeArch.makeSkillNameToPower(skills,skillPower);
        PokeArch.makeTypeToSkillsMap(skillType,skills);

        //2.포켓몬 센터(아카이브)
        PokemonCenter pokemonCenter = new PokemonCenter(PokeArch);

        //3.포켓몬 픽, 닉네임
        String name = pokemonCenter.randomPick();
        String nickName = sc.next();

        //4.포켓몬 객체 받기 (픽,닉네임)
        Pokemon pokemon = pokemonCenter.initPockmon(name,nickName);
        System.out.println(pokemon);
    }
}
