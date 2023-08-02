package example0802.kiosk.labber;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Labber {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {


        int playerNum =  sc.nextInt();
        int layer = sc.nextInt();
        int[] makeLayerNum = new int[playerNum];
        int[][] twoDimensionalArray = new int[layer][];

        for (int i = 0; i < layer; i++) {
            twoDimensionalArray[i] = extracted(makeLayerNum, true);
            System.out.println(Arrays.toString(twoDimensionalArray[i]));
        }

//        for (int i = 0; i < layer ; i++) {
//            for (int j = 0; j < playerNum; j++) {
//                System.out.print(twoDimensionalArray[i][j]);
//            }
//            System.out.println();
//        }

        int i=0;
        int j=0;
        while(i< layer-1) {
            if (twoDimensionalArray[i][j] == 0) {
                System.out.println(twoDimensionalArray[i][j]);
                i++;
            }
            else if (twoDimensionalArray[i][j] == 1) {
                System.out.println(twoDimensionalArray[i][j]);
                i++;
                j++;
            }
            else if (twoDimensionalArray[i][j] == 2) {
                System.out.println(twoDimensionalArray[i][j]);
                i++;
                j--;
            }
        }
        System.out.println("등수는 = "+(j+1));
    }
    private static int[] extracted(int[] inputArray, boolean flag) {
        int[] makeLayerNum = Arrays.copyOf(inputArray, inputArray.length); // make a copy of the input array
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
