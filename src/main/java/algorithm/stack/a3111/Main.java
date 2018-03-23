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

package algorithm.stack.a3111;

import java.util.Scanner;

/**
 * 
 * T에 A가 없으면 알고리즘을 종료한다. T에서 처음 등장하는 A를 찾은 뒤, 삭제한다. T에 A가 없으면 알고리즘을 종료한다. T에서
 * 마지막으로 등장하는 A를 찾은 뒤, 삭제한다. 1번으로 돌아간다.
 * 
 * 첫째 줄에 단어 A가, 둘째 줄에 텍스트 T가 주어진다. A와 T는 알파벳 소문자로만 이루어져 있고, A는 최대 25자, T는 최대
 * 300,000자이다. aba ababacccababa bacccab
 * 
 * @author ej.park
 *
 */
public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		String a = sc.nextLine();
		String t = sc.nextLine();
		long start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder(t);
		int aSize = a.length();
		while (true) {
			int index = sb.indexOf(a);
			if (index==-1) {
				System.out.println(sb.toString());
				break;
			}
			sb.delete(index, index + aSize);
			index = sb.lastIndexOf(a);
			if(index>-1) {
				sb.delete(index, index + aSize);
			}
		}
		System.out.println(String.format("%.3f", (System.currentTimeMillis() - start)/1000.0));
	}
}
