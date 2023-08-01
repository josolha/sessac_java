package example0801;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CardGame {

    static int[] computerNum ;
    static int[] userNum ;
    static int comMax = 0;
    static int comSecondMax = 0;
    static int userPickNum1;
    static int userPickNum2;


    static Random random =new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        init();
        makeNumber();
        userInputNums();

        int userNumAdd = userNumberAdd(userPickNum1,userPickNum2);
        int comNumAdd = comNumberAdd();

        System.out.println(selectWinner(userNumAdd,comNumAdd));


        //data 체킹
        System.out.println("=========================");
        System.out.println("컴퓨터의 숫자 = "+Arrays.toString(computerNum));
        System.out.println("컴퓨터가 고른 숫자 두개 = "+comMax+" 와 "+comSecondMax);
        System.out.println("컴퓨터의 숫자합 = "+comNumAdd);
        System.out.println("=========================");
    }

    private static void userInputNums() {
        userPickNum1 = sc.nextInt();
        userPickNum2 = sc.nextInt();
    }

    private static String selectWinner(int userNum, int comNum ) {
        if(userNum>comNum){
            return userPickNum1 +" VS "+userPickNum2+" 사용자의 승리입니다.";
        }else if(userNum == comNum){
            return  "비겼습니다.";
        }
        return  comMax+" VS " +comSecondMax+" 컴퓨터의 승리입니다.";
    }

    private static int comNumberAdd() {
        for (int i : computerNum) {
            if(i > comMax){
                comSecondMax = comMax;
                comMax = i;
            }else if(i>comSecondMax && i != comMax){
                comSecondMax = i;
            }
        }
        System.out.println(comMax +" " +comSecondMax);
        return comMax + comSecondMax;
    }

    private static int userNumberAdd(int num1, int num2) {
        return num1 + num2;
    }

    private static void init(){
        System.out.println("카드가 분배됩니다");
        computerNum = new int[4];
        userNum = new int[4];

    }
    private static void makeNumber() {
        for (int i = 0; i < 4; i++) {
            computerNum[i] = random.nextInt(10) +1;
            userNum[i] = random.nextInt(10) +1;
            System.out.print(userNum[i]+" ");
        }
        System.out.println("중 두개의 카드를 선택해주세요.");
    }
}
