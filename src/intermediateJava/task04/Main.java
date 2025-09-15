package intermediateJava.task04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 수: ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 수: ");
		int num2 = sc.nextInt();
		System.out.print("연산자(+, -, *, /): ");
		String op = sc.next();

		try {
			int result = 0;
			switch (op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				if (num2 == 0) {
					throw new ArithmeticException("0으로 나눌 수 없음");
				}
				result = num1 / num2;
				break;
			default:
				throw new IllegalArgumentException("잘못된 연산자 입력");
			}
			System.out.println("결과: " + result);
		} catch (ArithmeticException e) {
			System.out.println("에러: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("에러: " + e.getMessage());
		}
	}
}
