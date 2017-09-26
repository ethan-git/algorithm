package psn.ej.study.algo.compete.a14650;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 입력 N을 입력 (1 <= N <= 9)
 * 출력 0, 1, 2만 가지고 만들 수 있는 N자리 3의 배수의 개수를 출력.
 * 
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);

	static String combine(int[] numbers, int digit, String number, int quot, List<String> numberList) {
		String allNumber = "";
		if (number.length() == digit) {
			int n = Integer.parseInt(number);
			if (n % quot == 0 && numLength(n) == digit && n > 0) {
				numberList.add(number);
			}
			return "";
		} else {
			for (int i = 0; i < numbers.length; i++) {
				allNumber = number + numbers[i];
				allNumber = allNumber + combine(numbers, digit, allNumber, quot, numberList);
			}
		}
		return allNumber;
	}

	public static int numLength(int number) {
		if (number == 0) {
			return 1;
		}
		return ((int) Math.log10(number > 0 ? number : -number)) + 1;
	}

	public static void main(String args[]) {
		int digit = sc.nextInt();
		int quot = 3;
		int[] numbers = { 0, 1, 2 };
		List<String> numberList = new ArrayList<String>();
		combine(numbers, digit, "", quot, numberList);
		System.out.println(numberList.size());
	}
}
