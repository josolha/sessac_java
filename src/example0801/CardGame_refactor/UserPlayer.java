package example0801.CardGame_refactor;

import java.util.Arrays;
import java.util.Random;

public class UserPlayer {
    private int[] nums;
    private int firstNum;
    private int secondNum;

    private static Random random = new Random();

    public UserPlayer(int numLength){
        nums = new int[numLength];
        for (int i = 0; i < numLength; i++) {
            nums[i]=random.nextInt(10) +1;
        }
    }
    public void pickNum(int num1,int num2) {
        this.firstNum = nums[num1];
        this.secondNum = nums[num2];
    }

    public int getAddNum(){
        return this.firstNum + this.secondNum;
    }

    @Override
    public String toString() {
        return Arrays.toString(nums).replace("[","").replace("]","");
    }

    public int getFirstNum() {
        return firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }
}
