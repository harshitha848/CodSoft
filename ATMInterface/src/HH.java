
public class HH {

	public static void main(String[] args) {
		        int row = 5;

		        // Top Half
		        for (int i = 1; i <= row; i++) {
		            // Print spaces
		            for (int j = 1; j <= row - i; j++) {
		                System.out.print("  ");
		            }

		            // Print descending numbers
		            for (int j = row; j > row - i; j--) {
		                System.out.print(j + " ");
		            }

		            // Print ascending numbers
		            for (int j = row - i + 2; j <= row; j++) {
		                System.out.print(j + " ");
		            }

		            System.out.println();
		        }

		        // Bottom Half
		        for (int i = row - 1; i >= 1; i--) {
		            // Print spaces
		            for (int j = 1; j <= row - i; j++) {
		                System.out.print("  ");
		            }

		            // Print descending numbers
		            for (int j = row; j > row - i; j--) {
		                System.out.print(j + " ");
		            }

		            // Print ascending numbers
		            for (int j = row - i + 2; j <= row; j++) {
		                System.out.print(j + " ");
		            }

		            System.out.println();
		        }
		    }
		}

		

