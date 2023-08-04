package example0804.tetris;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Board {

    private List<Stack<Integer>> map = new ArrayList<>();

    private final int lineCnt;



    public Board(int lineCnt) {
        this.lineCnt = lineCnt;
    }
    public List<Stack<Integer>> getMap() {
        return map;
    }
    public void makeBoard(){
        for (int i = 0; i < this.lineCnt; i++) {
            this.map.add(new Stack<Integer>());
        }
    }
    public void printBoard(){
        System.out.println("-----------------------------");
        for (int i = 0; i < this.lineCnt; i++) {
            Stack<Integer> stack = map.get(i);
            for(Integer item : stack) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
    public int getLineCnt() {
        return lineCnt;
    }

}
