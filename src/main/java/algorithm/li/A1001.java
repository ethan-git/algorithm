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
public class A1001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int width = Integer.parseInt(arr[0]);
		int height = Integer.parseInt(arr[1]);
		int area = width * height;
		System.out.println(area);
	}
}
