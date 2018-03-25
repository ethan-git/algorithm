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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ejpark
 *
 */
public class A1004 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean isOperation = true;
		StringBuilder output = new StringBuilder();
		Storage storage = new Storage();
		while (isOperation) {
			String input = br.readLine();
			String[] commands = input.split(" ");
			String command = commands[0];
			switch (command) {
			case "evict":
				storage.evict();
				break;
			case "add":
				storage.add(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
				break;
			case "get":
				output.append(storage.get(Integer.parseInt(commands[1]))).append("\n");
				break;
			case "remove":
				output.append(storage.remove(Integer.parseInt(commands[1]))).append("\n");
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
		private List<Integer> list = new ArrayList<Integer>();
		private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		public void evict() {
			if (!list.isEmpty()) {
				map.remove(list.get(0));
			}
		}

		public void add(int key, int value) {
			map.put(key, value);
			orderKey(key);
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				orderKey(key);
				return map.get(key);
			}
			return -1;
		}

		public int remove(int key) {
			if (map.containsKey(key)) {
				int value = map.get(key);
				map.remove(key);
				list.remove(list.indexOf(key));
				return value;
			}
			return -1;
		}

		private void orderKey(int key) {
			int index = list.indexOf(key);
			if (index > -1) {
				list.remove(index);
			}
			list.add(key);
		}
	}
}