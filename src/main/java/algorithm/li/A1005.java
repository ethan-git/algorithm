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
import java.util.ArrayList;
import java.util.List;

/**
 * @author ejpark
 *
 */
public class A1005 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean isOperation = true;
		StringBuilder output = new StringBuilder();

		Storage data = new Storage();
		while (isOperation) {
			String input = br.readLine();
			String[] commands = input.split(" ");
			String command = commands[0];
			switch (command) {
			case "min":
				output.append(data.min()).append("\n");
				break;
			case "add":
				int param = Integer.parseInt(commands[1]);
				data.add(param);
				break;
			case "remove":
				output.append(data.remove()).append("\n");
				break;
			case "exit":
				isOperation = false;
				break;
			default:
			}
		}

		System.out.println(output.toString());
	}

	public static class Storage {
		private Integer min = null;
		private List<Integer> list = new ArrayList<Integer>();

		public int min() {
			if (list.isEmpty()) {
				return -1;
			}
			return min;
		}

		public void add(int value) {
			list.add(value);
			if (min == null) {
				min = value;
			}
			if (value < min) {
				min = value;
			}
		}

		public int remove() {
			if (list.isEmpty()) {
				return -1;
			}
			int value = list.get(0);
			list.remove(0);
			return value;
		}
	}
}
