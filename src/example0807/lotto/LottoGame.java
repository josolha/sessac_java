package example0807.lotto;

import java.util.*;

public class LottoGame {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static Set<Integer> computerNumber;
    static final int numberSize = 6;


    public LottoGame(){
        computerNumber = makeRandomNum();
    }

    public void play() {

        int tryNum = userTry();

        while(tryNum>0){
            Player playerNumber = new Player(makeRandomNum());
            Set<Integer> intersection = new HashSet<>(playerNumber.getUserNumber());
            intersection.retainAll(computerNumber);

            //ENUM 처리
            Rank rank = Rank.getRankByCount(intersection.size());
            System.out.println(rank.getRankString());

            //메소드 처리
            //checkRank(intersection.size());

            //체크
            System.out.println("==========================");
            System.out.println("로또 번호 : "+computerNumber);
            System.out.println("  내 번호 : "+playerNumber.getUserNumber());
            System.out.println("==========================");
            tryNum--;
        }
    }

//    private void checkRank(int cnt) {
//        if(cnt==3) {
//            System.out.println("4등!");
//        }
//        else if(cnt==4) {
//            System.out.println("3등!");
//        }
//        else if(cnt==5) {
//            System.out.println("2등!");
//        }else if(cnt==6){
//            System.out.println("1등!");
//        }
//        else{
//            System.out.println("꽝!");
//        }
//    }

    private int userTry(){
        System.out.println("로또를 몇개 생성하시겠습니까?");
        return sc.nextInt();
    }
    private Set<Integer> makeRandomNum(){

        Set<Integer> madeRandomNum = new HashSet<>();

        while (madeRandomNum.size() < LottoGame.numberSize) {
            madeRandomNum.add(random.nextInt(46) +1);
        }
        return madeRandomNum;
    }

    }



