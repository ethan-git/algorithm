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

package algorithm.datastructure.a7453;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ejpark
 *
 */
public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		 int[][] numbers = { { -45, 22, 42, -16 }, { -41, -27, 56, 30 }, { -36, 53,
//		 -37, 77 }, { -36, 30, -75, -46 },
//		 { 26, -38, -10, 62 }, { -32, -54, -6, 45 } };
//		 int n = numbers.length;
		long start = System.currentTimeMillis();

		int n = 4000;
		int[][] numbers = new int[n][4];
		Random random = new Random();
		int bounds = (int) Math.pow(2, 28);
		for (int i = 0; i < n; i++) {
			String number = random.nextInt(bounds) + " -" + random.nextInt(bounds) + " -" + random.nextInt(bounds) + " "
					+ random.nextInt(bounds);
			String[] numberArr = number.split(" ");
			for (int j = 0; j < numberArr.length; j++) {
				numbers[i][j] = Integer.parseInt(numberArr[j]);
			}
		}
		System.out.println(String.format("%.3f", (System.currentTimeMillis() - start) / 1000.0));
		int cnt = 0;
		Stack<Integer> list = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				list.push((+numbers[i][0] + numbers[j][1]) * -1);
			}
		}
		System.out.println(String.format("%.3f", (System.currentTimeMillis() - start) / 1000.0));
		Collections.sort(list);
		int len = list.size() - 1;
		System.out.println(String.format("%.3f", (System.currentTimeMillis() - start) / 1000.0));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int startIdx = 0;
				int endIdx = len;
				int num = numbers[i][2] + numbers[j][3];
				while (endIdx - startIdx >= 0) {
					int mid = (startIdx + endIdx) / 2;
					int target = list.get(mid);
					if (target > num) {
						endIdx = mid - 1;
					} else if (target < num) {
						startIdx = mid + 1;
					} else {
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
		// 5
		System.out.println(String.format("%.3f", (System.currentTimeMillis() - start) / 1000.0));
	}
}
