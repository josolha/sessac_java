package example0808.pokemon;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //아카이브 생성
        PokemonArchive PokeArch = makeArchive();
        //포켓몬 센터 생성
        PokemonCenter pokemonCenter = new PokemonCenter(PokeArch);
        pokemonCenter.initAppearPokemon();
        //포켓몬 이름, 닉네임 설정
        String name = pokemonCenter.randomPick();
        String nickName = sc.next();
        //포켓몬 객체 받기 (픽,닉네임)
        Pokemon pokemon = pokemonCenter.initPokemon(name,nickName);
        System.out.println(pokemon);
        play(PokeArch, pokemonCenter, name, pokemon);
    }
    private static void play(PokemonArchive PokeArch, PokemonCenter pokemonCenter, String name, Pokemon pokemon) {
        while(true) {
            System.out.println("무엇을 하시겠습니까?"
                    + "\n1.사냥 2.도전 3.회복 4.종료");
            int selected = sc.nextInt();
            if (selected == 1) {
                gotoTaeCho(PokeArch, pokemonCenter, pokemon);
            } else if (selected == 2) {
                gotoGym(PokeArch, pokemonCenter, pokemon);
            } else if (selected == 3) {
                pokemonCenter.hospital(name, pokemon);
            }else{
                break;
            }
        }
    }
    private static void gotoGym(PokemonArchive PokeArch, PokemonCenter pokemonCenter, Pokemon pokemon) {
        PokemonGym gym = new PokemonGym(PokeArch);
        Pokemon gymPokemon = gym.initPokemon();
        pokemonCenter.match(pokemon,gymPokemon);
    }

    private static void gotoTaeCho(PokemonArchive PokeArch, PokemonCenter pokemonCenter, Pokemon pokemon) {
        PokemonTaeCho taeCho = new PokemonTaeCho(PokeArch);
        taeCho.initAppearPokemon();
        Pokemon taeChoPokemon = taeCho.initPokemon();
        pokemonCenter.match(pokemon, taeChoPokemon);
    }

    private static PokemonArchive makeArchive() {
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
        return PokeArch;
    }
}
