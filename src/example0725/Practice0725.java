package example0725;

import java.util.Scanner;

public class Practice0725 {

	public static void main(String[] args) {
		//���� 1��
		double x = 10.1;
		int y = 2;
		System.out.println((int)x*y);
		
		
		//���� 2��
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȯ�� �ʸ� ������ �Է��ϼ���:");
		int time = sc.nextInt();
		System.out.printf("��ȯ�� ������ �ð�: %d�� %d��: %d �Դϴ�.",(time/60)/60,(time/60)%60,time%60); 
		

	}

}
