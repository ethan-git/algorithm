/*******************************************************************************
 * Copyright (c) 2017 ejpark.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 * 
 * Contributors:
 *     eungjun11@gmail.com - initial API and implementation
 ******************************************************************************/

package psn.ej.study.algo.compete.a14650;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author ej.park
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
