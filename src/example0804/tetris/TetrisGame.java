package example0804.tetris;

import example0801.CardGame_refactor.ComputerPlayer;

import java.util.Random;
import java.util.Scanner;


public class TetrisGame {
    private Board board;
    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();
    private final int MAX_SIZE = 5;

    private int userTry = 0;

    public TetrisGame() {

    }
     public void play(){
        init();
        game();
     }
     private void game(){
         boolean flag =true;
         while(flag){
             int randomNum =makeNumber(board.getLineCnt());
             int userNum = linePutNum(randomNum);
             removeCoupleNum(userNum,randomNum);
             userTry++;
             flag = checkMax();
             board.printBoard();
         }
     }

    private void init() {
        this.board = new Board(lineSize());
        board.makeBoard();
        board.printBoard();
    }
    private int lineSize(){
        System.out.println("블록이 들어갈 라인의 개수를 입력하세요");
        return sc.nextInt();
    }
    private int linePutNum(int makeNumber){
        System.out.println("\""+makeNumber+"\"" +" 블록이 들어갈 라인의 번호를 입력하세요");
        return sc.nextInt();
    }
    private int makeNumber(int lineCnt){
        return random.nextInt(lineCnt * 2) + 1;
    }

    private boolean checkMax(){
        for (int i = 0; i < board.getLineCnt(); i++) {
            if(board.getMap().get(i).size() == MAX_SIZE){
                System.out.println(userTry+"회 만에"+i+" 라인이 꽉찼습니다.");
                return false;
            }
        }
        return true;
    }
    private void removeCoupleNum(int userNum,int randomNum ){
        if(!board.getMap().get(userNum).empty() && board.getMap().get(userNum).peek() == randomNum){
            board.getMap().get(userNum).pop();
        }
        else{
            board.getMap().get(userNum).add(randomNum);
        }
    }
}
