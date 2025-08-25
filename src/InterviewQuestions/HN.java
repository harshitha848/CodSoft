package InterviewQuestions;

public class HN {
	static int findHappy(int num) {
		int res=0;
		while(num!=0) {
			int rem=num%10;
			res = (rem*rem)+res;
			num =num/10;
		}
		return res;
	}

	public static void main(String[] args) {
		int num=19;
		int res=findHappy(num);
		while(res!=4 && res!=1) {
			res=findHappy(res);
		}
	if(res==4) {
		System.out.println("Not a Happy Number");
	}
	else {
		System.out.println("Happy Number");
	}
	}
}
