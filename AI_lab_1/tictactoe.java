package AI_lab_1;

import java.util.Arrays;
import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {
		int arr[] = new int[9];
		System.out.println("Enter data points:");
		Scanner obj = new Scanner(System.in);
		for (int i=0; i<arr.length; i++) {
			arr[i] = obj.nextInt();
		}
		System.out.println("V = " +Arrays.toString(arr));
		
		int count0=0, count1=0, count2=0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]==0) {
				count0+=1;
			}
			else if (arr[i]==1) {
				count1+=1;
			}
			else if (arr[i]==2) {
				count2+=1;
			}
			else {
				System.out.println("Wrong input data");
				System.exit(0); 
			}
		}
		
		System.out.println("Blank = "+count0);
		System.out.println("X = "+count1);
		System.out.println("O = "+count2);
		
		int diff = count1-count2;
		int mult=1, sum=0;
		if (diff==0 | diff==1 | diff==-1) {
			System.out.println("valid board position");
			for (int i=8; i>0; i--) {
					sum += arr[i] * mult;
					mult *= 3;
				}
				System.out.println("I = "+sum);
			}
		else {
			System.out.println("Invalid board position");
			}
		
	
	}
}
