package example0802.kiosk.labber;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labber {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        //1. 플레이어 입력
        int playerCnt =  getPlayerCnt();
        //2. 높이 입력
        int ladderHeight = getLadderHeight();
        //3. 순위 정하기
        int[] playerRank = getPlayerRank(playerCnt);
        //4. 다리만들기
        int[][] ladder = getGenerateLadder(playerCnt,ladderHeight);
        //5. 플레이어 순위 출력
        for (int i = 0; i < playerCnt ; i++) {
            getPrintPlayerRank(playerRank, ladder, i);
        }

        //사다리 체크
        System.out.println("=======사다리=======");
        printLadder(ladder);
        System.out.println("==================");
    }
    private static int getPlayerCnt(){
        System.out.println("플레이수와 사다리 층수를 입력해 주세요");
        return sc.nextInt();
    }
    private static int getLadderHeight(){
        return sc.nextInt();
    }
    private static int[] getPlayerRank(int playerCnt){
        System.out.println("플레이어수 만큼 등수를 정해주세요");
        int[] playerRank = new int[playerCnt];

        for (int i = 0; i < playerRank.length ; i++) {
            playerRank[i] = sc.nextInt();
        }
        return playerRank;
    }

    private static void getPrintPlayerRank(int[] playerRank, int[][] ladder, int player) {
        int i=0;
        int j=player;
        while(i< ladder.length-1) {
            if (ladder[i][j] == 0) {
                i++;
            }
            else if (ladder[i][j] == 1) {
                i++;
                j++;
            }
            else if (ladder[i][j] == 2) {
                i++;
                j--;
            }
        }
        System.out.println((player+1)+"번째 플레이어의 등수는 = " +  playerRank[j]);
    }

    private static int[][] getGenerateLadder(int playerCnt, int ladderHeight) {
        int[][] ladder = new int[ladderHeight][];
        for (int i = 0; i < ladderHeight; i++) {
            ladder[i] = makeOneLayer(playerCnt);
        }
        return ladder;
    }

    private static int[] makeOneLayer(int playerCnt) {
        int[] makeLayerNum = new int[playerCnt];
        boolean flag = true;

        while(flag) {
            int oneCnt = 0;
            int twoCnt = 0;

            for (int i = 0; i < makeLayerNum.length; i++) {
                makeLayerNum[i] = random.nextInt(3);
                if(makeLayerNum[i] ==1){
                    oneCnt++;
                }else if(makeLayerNum[i]==2){
                    twoCnt++;
                }
            }
            for (int i = 0; i < makeLayerNum.length -1; i++) {
                if (makeLayerNum[i] == 1 && makeLayerNum[i + 1] == 2 && oneCnt==1 && twoCnt==1 ) {
                    flag = false;
                    break;
                }
            }
        }
        return makeLayerNum;
    }

    private static void printLadder(int[][] ladder){
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j] + " ");
            }
            System.out.println();
        }
    }
}
