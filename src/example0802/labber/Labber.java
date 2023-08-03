package example0802.labber;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labber {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        //1. 플레이어 수 입력
        int playerCnt =  getPlayerCnt();

        //2. 높이 입력
        int ladderHeight = getLadderHeight();

        //3. 커스텀 순위 입력 (1번의 플레이어 수만큼)
        int[] playerRank = getPlayerRank(playerCnt);

        //4. 다리만들기 (1번의 플레이어 수, 2번의 높이)
        int[][] ladder = getGenerateLadder(playerCnt,ladderHeight);

        //5. 플레이어 순위 출력
        //반복 (1번의 플레이어 수 만큼) -> (3번의 완성 커스텀 순위, 4번의 완성 사다리)
        for (int i = 0; i < playerCnt ; i++) {
            getPrintPlayerRank(playerRank, ladder, i);
        }

        //사다리 체크
        System.out.println("\n======사다리======");
        printLadder(ladder);
        System.out.println("=================");
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

        int number = random.nextInt(playerCnt-1);
        makeLayerNum[number] = 1;
        makeLayerNum[number+1] = 2;

        return makeLayerNum;
    }

    private static void printLadder(int[][] ladder){
        for (int[] lines : ladder) {
            for (int unit : lines) {
                System.out.print(unit + "    ");
            }
            System.out.println();
        }
    }
}
