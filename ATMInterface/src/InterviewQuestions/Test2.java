package InterviewQuestions;

public class Test2 {
	static int m(int num, int reverse ) { { //Tracing -Assignment(way1)
	if(num==0) {
		return reverse;
	}
	else {
		reverse=(reverse*10)+(num%10);
		return m(num/10,reverse);
	}
	}
}

	public static void main(String[] args) {
		int num=1234;
		int res=m(num,0);
		System.out.println(res);
	}
}

