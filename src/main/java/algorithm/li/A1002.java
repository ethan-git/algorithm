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

package algorithm.li;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ejpark
 *
 */
public class A1002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String arrStr = br.readLine();
		String[] arr = arrStr.split(" ");
		String[] param = br.readLine().split(" ");
		int dest = Integer.parseInt(param[0]);
		int src = Integer.parseInt(param[1]);
		int size = Integer.parseInt(param[2]);
		if (size <= 0) {
			System.out.println(arrStr);
			return;
		}
		for (int i = 0; i < size; i++) {
			arr[dest + i] = arr[src + i];
		}
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < n; i++) {
			output.append(arr[i]).append(" ");
		}
		System.out.println(output.toString());
	}

}
