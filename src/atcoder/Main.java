package atcoder;
//atcoder ABC038A
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
	
		if (s.charAt(s.length()-1) == "T") {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
