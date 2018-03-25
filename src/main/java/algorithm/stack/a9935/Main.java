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

package algorithm.stack.a9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;

/**
 * 
 * 상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.
 * 
 * 폭발은 다음과 같은 과정으로 진행된다.
 * 
 * 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을
 * 만든다. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다. 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다. 상근이는 모든
 * 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 남아있는 문자가 없는 경우가 있다. 이 때는 "FRULA"를 출력한다.
 * 
 * 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다. 입력 첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고,
 * 1,000,000보다 작거나 같다. 둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다. 두 문자열은
 * 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.
 * 
 * 출력 첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.
 * 
 * mirkovC4nizCC44 C4 mirkovniz
 * 
 * @author ej.park
 *
 */
public class Main {

	public static void main(String args[]) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String t = br.readLine();
		 String bomb = br.readLine();
//		String t = "mirkovC4nizCC44";
//		String bomb = "C4";
		long start = System.currentTimeMillis();

		Stack stack = new Stack();
		for (int i = 0; i < t.length(); i++) {
			stack.push(t.charAt(i));
			if (t.charAt(i) == bomb.charAt(bomb.length() - 1)) {
				stack.check(bomb);
			}
		}
		stack.print();
		System.out.println(String.format("%.3f", (System.currentTimeMillis() - start) / 1000.0));
	}

	public static class Stack {
		private int top = 0;
		private char[] stack = new char[1000003];

		public void push(char chr) {
			stack[top++] = chr;
		}

		public void check(String bomb) {
			if (top < bomb.length()) {
				return;
			}

			int index = top - 1;
			boolean isBomb = true;
			for (int i = bomb.length() - 1; i >= 0; i--) {
				if (stack[index] != bomb.charAt(i)) {
					isBomb = false;
				}
				index--;
			}

			if (isBomb) {
				top = top - bomb.length();
			}
		}

		public void print() {
			if (top == 0) {
				System.out.println("FRULA");
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < top; i++) {
					sb.append(stack[i]);
				}
				System.out.println(sb.toString());
			}
		}
	}
}
