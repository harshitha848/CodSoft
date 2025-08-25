
public class Star {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row=5;
		int k=1;
		for(int i=1;i<=row;i++) {
			
			
			for(int j=1;j<=(row-i);j++) {
				System.out.print(" "+" ");
				
			
			}
			
			for(int j=1;j<=i;j++) {
				System.out.print(k+" ");
			}
			System.out.println();
			k++;
			
			
			}
		}
}

	

