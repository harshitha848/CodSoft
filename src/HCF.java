
public class HCF {

	public static void main(String[] args) {
		int a=10;
		int b=20;
		int smallest=0;
		int count =0;
		int hcf=1;
		if(a<b) {
			smallest =a;
		}
		else {
			smallest=b;
		}
		for(int i=1;i<=smallest;i++) {
			if(a%i==0 && b%i==0) {
				hcf=i;
				System.out.println(i); 
				count++;
			}
		}
		System.out.println("The number of common factors are:"+ count);
	System.out.println("HCF "+"is "+ hcf);
}
}

