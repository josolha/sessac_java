package example0801.CardGame_refactor;

import java.util.Arrays;
import java.util.Random;

public class ComputerPlayer {
    private int[] nums;

    private int maxNum;
    private int secondNum;

    private static Random random = new Random();

    public ComputerPlayer(int numLength){

        nums = new int[numLength];

        for (int i = 0; i <numLength ; i++) {
            nums[i] = random.nextInt(10) +1;
        }
    }
    public void makeMaxSecondNum(){
        this.maxNum =0;
        this.secondNum = 0;
        for (int i : nums){
            if(i > maxNum){
                secondNum = maxNum;
                maxNum = i;
            } else if (i >secondNum && i != maxNum) {
                secondNum = i;
            }
        }
    }
    public int getAddNum(){
        return this.maxNum + this.secondNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public int getSecondNum() {
        return secondNum;
    }
    @Override
    public String toString() {
        return Arrays.toString(nums).replace("[","").replace("]","");
    }
}
