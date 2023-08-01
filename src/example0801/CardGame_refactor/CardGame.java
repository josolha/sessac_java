package example0801.CardGame_refactor;

import java.util.Scanner;

public class CardGame {
    private final ComputerPlayer computerPlayer;
    private final UserPlayer userPlayer;

    private final Scanner sc = new Scanner(System.in);

    public CardGame(int numLength){
        this.computerPlayer = new ComputerPlayer(numLength);
        this.userPlayer = new UserPlayer(numLength);
    }
    public void play() {
        System.out.println("카드가 분배됩니다\n" +
                          this.userPlayer.toString() +
                          " 두개의 카드를 선택해주세요.");
        userPlayer.pickNum(sc.nextInt(),sc.nextInt());
        computerPlayer.makeMaxSecondNum();

        String winner = winner();
        System.out.println(userPlayer.getAddNum()+" vs "+ computerPlayer.getAddNum()+winner);

        //check
        System.out.println("======체크======");
        System.out.println("컴퓨터의 숫자 배열 = "+computerPlayer.toString());
        System.out.println("컴퓨터의 가장 큰 숫자 = " +computerPlayer.getMaxNum());
        System.out.println("컴퓨터의 두번쨰 큰 숫자 = " + computerPlayer.getSecondNum());

        System.out.println("사용자의 숫자 배열 = "+userPlayer.toString());
        System.out.println("사용자의 첫번째 숫자 = " +userPlayer.getFirstNum());
        System.out.println("사용자의 두번째 숫자 = " + userPlayer.getSecondNum());
        System.out.println("===============");
    }
    public String winner(){
        if(this.computerPlayer.getAddNum() > this.userPlayer.getAddNum()){
            return " 컴퓨터의 승리입니다.";

        } else if (this.computerPlayer.getAddNum() < this.userPlayer.getAddNum()) {
            return " 사용자의 승리입니다.";
        }
        return "비겼습니다.";

    }

}
