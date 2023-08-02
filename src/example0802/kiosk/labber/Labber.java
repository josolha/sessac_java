package example0802.kiosk.labber;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labber {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {

        System.out.println("플레이수와 사다리 층수를 입력해 주세요");
        int playerCnt =  sc.nextInt();
        int layerCnt = sc.nextInt();

        System.out.println("플레이어수 만큼 등수를 정해주세요");
        int[] playerRank = new int[playerCnt];
        for (int i = 0; i < playerRank.length ; i++) {
            playerRank[i] = sc.nextInt();
        }

        int[][] labber = new int[layerCnt][];


        for (int i = 0; i < layerCnt; i++) {
            labber[i] = makeOneLayer(playerCnt);
            System.out.println(Arrays.toString(labber[i]));
        }
        for (int k = 0; k < playerCnt ; k++) {
            int i=k;
            int j=0;
            while(i< layerCnt-1) {
                if (labber[i][j] == 0) {
                    i++;
                    System.out.println(labber[i][j]);
                }
                else if (labber[i][j] == 1) {
                    i++;
                    j++;
                    System.out.println(labber[i][j]);

                }
                else if (labber[i][j] == 2) {
                    i++;
                    j--;
                    System.out.println(labber[i][j]);
                }
            }
            System.out.println("등수는 = "+(j+1));
            System.out.println(k+"번째 플레이어의 등수는 = " +  playerRank[k]);
        }
    }
    private static int[] makeOneLayer(int playerCnt) {
        int[] makeLayerNum = new int[playerCnt];
        boolean flag = true;
        while(flag) {
            int oneCnt = 0;
            int twoCnt = 0;

            for (int i = 0; i < makeLayerNum.length; i++) {
                makeLayerNum[i] = random.nextInt(3);
            }
            for (int j : makeLayerNum) {
                if (j == 1) {
                    oneCnt++;
                } else if (j == 2) {
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
}
