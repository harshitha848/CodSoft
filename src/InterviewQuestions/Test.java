package InterviewQuestions;

public class Test {
	static int m(int num) {
		if(num==0) {
			return 0;
		}
		else {
			return (num%10)+m(num/10);
		}
	}

	public static void main(String[] args) {
		int number=1234;
		int res=m(number);
		System.out.println(res);

	}

}
