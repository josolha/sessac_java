/**
 * 
 */
package example0725;

import java.util.Scanner;

public class MyMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first =  sc.nextInt();
		int second = sc.nextInt();
		
		int temp = 0;
		
		if(first < second) {
			temp = first;
			first = second;
			second = temp;
		}
		
		GCD(first,second);
		
		
		System.out.println("hello");
		System.out.println(first +" "+second );
	}

	private static void GCD(int first, int second) {
		
		
	}

}
