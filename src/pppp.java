public class pppp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int row=5;
		
		for(int i=1;i<=row;i++) {
			int k=5;
			for(int j=1;j<=(row-i);j++) {
				
				System.out.print(" "+" ");
			}
			for(int j=5;j>=(row+1-i);j--) {
			System.out.print( j +" ");
			
		}
		System.out.println();
	}
}
}
