import java.util.Scanner;

public class Patterns {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter rows");
		int rows=sc.nextInt();
		
		System.out.println("Enter columns");
		int columns=sc.nextInt();
		
		for(int i=1;i<=rows;i++) {
		    for(int j=1; j<= columns; j++) {
				System.out.print("*"+" ");
			                      }
				System.out.println();
				
		}
	}
}



