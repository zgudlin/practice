import java.util.Scanner;

public class Tests {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a;
		int b;
		int d;
		int q;
		int r;
		int A;
		int B;
		
		//Division algorithm 
		/*System.out.print("Enter nonnegative value for a: ");
		a = scan.nextInt();
		System.out.print("Enter positive value for d: ");
		d = scan.nextInt();
		
		r = a;
		q = 0;
		while (r >= d) {
			r = r - d;
			q ++;
		}
		System.out.println("Division Algorithm Results \nThe value of r is: " + r + " and the value of q is: " + q);*/
		
		//Euclidean algorithm 
		System.out.println();
		System.out.print("Enter nonnegative value for B: ");
		B = scan.nextInt();
		System.out.print("Enter value greater than B for A: ");
		A = scan.nextInt();
		
		a = A;
		b = B;
		r = B;
		
		while (b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		System.out.println("Euclidean Algorithm Results \nThe Greatest Common Divisor is a: " + a);
		
		
		
		
		



	}

}
