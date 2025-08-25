import java.util.Scanner;
public class SOF {

	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        System.out.print("Enter a number: ");
		        int num = sc.nextInt();

		        int sum = 0;

		        for (int i = num; i >= 1; i--) {
		            long fact = 1;
		            for (int j = 1; j <= i; j++) {
		                fact *= j;
		            }
		            sum += fact;
		        }

		        System.out.println("Sum of factorials from " + num + " to 1 is: " + sum);
		    }
		}
