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

package algorithm.ka;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ejpark
 *
 */
public class A1000 {
	private static Scanner sc = new Scanner(System.in);
	
	private static int[] getInput(String input) {
		String[] inputArr = input.split(",");
		int[] arr = new int[inputArr.length];
		for(int i=0; i<inputArr.length; i++) {
			arr[i] = Integer.parseInt(inputArr[i].trim());
		}
		return arr;
	}

	private static String getBinaryString(int number, int lpadZeroCnt) {
		return String.format("%0"+lpadZeroCnt+"d", Integer.parseInt(Integer.toBinaryString(number)));
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		sc.nextLine();
		int[] arr1 = getInput(sc.nextLine());
		int[] arr2 = getInput(sc.nextLine()); 

		String[] map = new String[n];
		for(int i=0; i<n; i++) {
			int r = (arr1[i]|arr2[i]);
			map[i] = getBinaryString(r, n).replaceAll("1", "#").replaceAll("0", "v");
		}
		System.out.println(Arrays.toString(map));
/*
5
9,20,28,18,11
30,1,21,17,28
[#####, #v#v#, ###v#, #vv##, #####]

6
46,33,33,22,31,50
27,56,19,14,14,10
[######, ###vv#, ##vv##, v####v, v#####, ###v#v]
*/
	}
}
