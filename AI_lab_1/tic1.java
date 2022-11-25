package AI_lab_1;

import java.util.Arrays;
import java.util.Scanner;

public class tic1 {

	public static void main(String[] args) {
		int arr[] = new int[9];
		System.out.println("Enter data points:");
		Scanner obj = new Scanner(System.in);
		for (int i=0; i<arr.length; i++) {
			arr[i] = obj.nextInt();
		}
		System.out.println("V = " +Arrays.toString(arr));
		
		int count0=0, count1=0, count2=0;  // blank=0, X=1, O=2
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
		
		int diff = count1-count2;
		if (diff==0 | diff==1 | diff==-1) {
			System.out.println("valid board position");
		}
		else {
			System.out.println("Invalid board position");
			System.exit(0);
		}
		System.out.println("\n");
		System.out.println("No of moves possible:" +count0);
		
		int[][] arr2 = new int[count0][9];
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<9; j++) {
				arr2[i][j] = arr[j];
			}	
		}
		System.out.println("W = "+Arrays.deepToString(arr2).replace("]," , "],\n"));
		
		// assume O (2) plays a move
		// all possible moves O can play
		int step = -1;
		for (int i=0; i<arr2.length; i++) {
			for (int j=step+1; j<arr2[i].length; j++) {
				if (arr2[i][j]==0) {
					//step = j;
					arr2[i][j] = 2;
					step = j;
					break;
					}
				}
			}
		
		System.out.println("\n");
		System.out.println("W` = "+Arrays.deepToString(arr2).replace("]," , "],\n"));
		System.out.println("\n");
		
		for (int i=0; i<arr2.length; i++) {
			//winning move
			if ((arr2[i][0]==2 && arr2[i][1]==2 && arr2[i][2]==2) ||
					(arr2[i][3]==2 && arr2[i][4]==2 && arr2[i][5]==2) || 
					(arr2[i][6]==2 && arr2[i][7]==2 && arr2[i][8]==2) ||
					(arr2[i][0]==2 && arr2[i][3]==2 && arr2[i][6]==2) ||
					(arr2[i][1]==2 && arr2[i][4]==2 && arr2[i][7]==2) ||
					(arr2[i][2]==2 && arr2[i][5]==2 && arr2[i][8]==2) ||
					(arr2[i][0]==2 && arr2[i][4]==2 && arr2[i][8]==2) ||
					(arr2[i][2]==2 && arr2[i][4]==2 && arr2[i][6]==2)) { 
					
					System.out.println("Winning move found");
					System.out.println(Arrays.toString(arr2[i]));
					System.out.println("Score=100");
					System.exit(0);	
				}
			
			//blocking for rows
			if ((arr2[i][0]==1 && arr2[i][1]==1 && arr2[i][2]==2) ||
					(arr2[i][0]==1 && arr2[i][1]==2 && arr2[i][2]==1) ||
					(arr2[i][0]==2 && arr2[i][1]==1 && arr2[i][2]==1) ||
					(arr2[i][3]==1 && arr2[i][4]==1 && arr2[i][5]==2) ||
					(arr2[i][3]==1 && arr2[i][4]==2 && arr2[i][5]==1) ||
					(arr2[i][3]==2 && arr2[i][4]==1 && arr2[i][5]==1) ||
					(arr2[i][6]==1 && arr2[i][7]==1 && arr2[i][8]==2) ||
					(arr2[i][6]==1 && arr2[i][7]==2 && arr2[i][8]==1) ||
					(arr2[i][6]==2 && arr2[i][7]==1 && arr2[i][8]==1)) {
					System.out.println("block move found");
					System.out.println(Arrays.toString(arr2[i]));
					System.out.println("Score=50");
					System.exit(0);
					}
			
			//blocking condition for columns
			if ((arr2[i][0]==1 && arr2[i][3]==1 && arr2[i][6]==2) ||
					(arr2[i][0]==1 && arr2[i][3]==2 && arr2[i][6]==1) ||
					(arr2[i][0]==2 && arr2[i][3]==1 && arr2[i][6]==1) ||
					(arr2[i][1]==1 && arr2[i][4]==1 && arr2[i][7]==2) ||
					(arr2[i][1]==1 && arr2[i][4]==2 && arr2[i][7]==1) ||
					(arr2[i][1]==2 && arr2[i][4]==1 && arr2[i][7]==1) ||
					(arr2[i][2]==1 && arr2[i][5]==1 && arr2[i][8]==2) ||
					(arr2[i][2]==1 && arr2[i][5]==2 && arr2[i][8]==1) ||
					(arr2[i][2]==2 && arr2[i][5]==1 && arr2[i][8]==1)) {
					System.out.println("block move found");
					System.out.println(Arrays.toString(arr2[i]));
					System.out.println("Score=50");
					System.exit(0);
				}
			
			//blocking condition for diagonals
			if ((arr2[i][0]==1 && arr2[i][4]==1 && arr2[i][8]==2) ||
					(arr2[i][0]==1 && arr2[i][4]==2 && arr2[i][8]==1) ||
					(arr2[i][0]==2 && arr2[i][4]==1 && arr2[i][8]==1) ||
					(arr2[i][2]==1 && arr2[i][4]==1 && arr2[i][6]==2) ||
					(arr2[i][2]==1 && arr2[i][4]==2 && arr2[i][6]==1) ||
					(arr2[i][2]==2 && arr2[i][4]==1 && arr2[i][6]==1)) {
					System.out.println("block move found");
					System.out.println(Arrays.toString(arr2[i]));
					System.out.println("Score=50");
					System.exit(0);
				}	
		} 
		
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<arr2.length; j++) {
				if (arr2[i][j]==2 && j==4) {
					System.out.println("score=4");
					System.out.println(Arrays.toString(arr2[i]));
					System.exit(0);
				}
			}	
		}
		
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<arr2.length; j++) {
				if (arr2[i][j]==2 && j%2==0) {
					System.out.println("score=3");
					System.out.println(Arrays.toString(arr2[i]));
					System.exit(0);
				}
			}
		}
		for (int i=0; i<arr2.length; i++) {
			for (int j=0; j<arr2.length; j++) {
				if (arr2[i][j]==2 && j%2==1) {
					System.out.println("score=3");
					System.out.println(Arrays.toString(arr2[i]));
					System.exit(0);
				}
			}
		}
		
	}
}	


