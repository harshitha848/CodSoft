package InterviewQuestions;

public class testt2 {    //Assignment - tracing(way2 ),but way1 is easy)
	static int m1(int num) {
		return m2(num,0);
	}
	static int m2(int num,int r) {
		if(num==0) {
			return r;
		}
		else {
			return m2(num/10,(r*10)+(num%10));
		}
	}

		public static void main(String[] args) {
			int num=1234;
			int res=m1(num);
			System.out.println(res);
		}
	}

		