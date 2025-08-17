package InterviewQuestions;

public class PN {

	public static void main(String[] args) {
		int num=12;
		int sum=0;
		for(int i=1;i<=num/2;i++) {
			if(num%i==0) {
				sum += i;
			}
		}
		System.out.println("Sum of it's factors is=>"+sum);
		if(sum==num) {
			System.out.println(num+"is a Perfect number.");
		}
		else {
			System.out.println(num +" is not a perfect number");
		}
		}
}
