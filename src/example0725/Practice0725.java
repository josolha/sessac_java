package example0725;

import java.util.Scanner;

public class Practice0725 {

	public static void main(String[] args) {
		//문제 1번
		double x = 10.1;
		int y = 2;
		System.out.println((int)x*y);
		
		
		//문제 2번
		Scanner sc = new Scanner(System.in);
		System.out.print("변환할 초를 정수로 입력하세요:");
		int time = sc.nextInt();
		System.out.printf("변환된 포맷은 시간: %d분 %d초: %d 입니다.",(time/60)/60,(time/60)%60,time%60); 
		

	}

}
