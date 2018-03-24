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

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author ejpark
 *
 */
public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] numbers = { { -45, 22, 42, -16 }, { -41, -27, 56, 30 }, { -36, 53, -37, 77 }, { -36, 30, -75, -46 },
				{ 26, -38, -10, 62 }, { -32, -54, -6, 45 } };
		int n = numbers.length;
		long start = System.currentTimeMillis();

		// int n = 4000;
		// int[][] numbers = new int[n][4];
		// Random random = new Random();
		// int bounds = (int) Math.pow(2, 28);
		// for (int i = 0; i < n; i++) {
		// String number = random.nextInt(bounds) + " -" + random.nextInt(bounds) + " -"
		// + random.nextInt(bounds) + " "
		// + random.nextInt(bounds);
		// String[] numberArr = number.split(" ");
		// for (int j = 0; j < numberArr.length; j++) {
		// numbers[i][j] = Integer.parseInt(numberArr[j]);
		// }
		// }

		int cnt = 0;
		int totSize = n*n;
		int[] arr1 = new int[totSize];
		int[] arr2 = new int[totSize];
		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr1[index] = numbers[i][0] + numbers[j][1];
				arr2[index] = numbers[i][2] + numbers[j][3];
				index++;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
        
		int min = 0;
		int max = totSize - 1;
		int temp = 0;
		while (min < totSize && max >= 0) {
			if (arr1[min] + arr2[max] < 0) {
				min++;
			} else if (arr1[min] + arr2[max] > 0) {
				max--;
			} else {
				int count1 = 0;
				temp = arr1[min];
				for (; min < totSize; min++) {
					if (arr1[min] == temp) {
						count1++;
					} else {
						break;
					}
				}
				int count2 = 0;
				temp = arr2[max];
				for (; max >= 0; max--) {
					if (arr2[max] == temp) {
						count2++;
					} else {
						break;
					}
				}
				cnt += count1*count2;
			}
		}
		System.out.println(cnt);
		// 5
		System.out.println(String.format("%.3f", (System.currentTimeMillis() - start) / 1000.0));
	}
}
