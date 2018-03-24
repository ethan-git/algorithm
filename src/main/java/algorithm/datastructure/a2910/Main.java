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

package algorithm.datastructure.a2910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ejpark
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numArr = br.readLine().split(" ");
		int n = Integer.parseInt(numArr[0]);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			if(!list.contains(num)) {
				list.add(num);
			}
			if(map.containsKey(num)) {
				int value = map.get(num);
				map.put(num, ++value);
			}else {
				map.put(num, 1);
			}
		}
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
		});
		int size = list.size();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			int value = list.get(i);
			int count = map.get(value);
			for(int j=0; j<count; j++) {
				sb.append(value).append(" ");
			}
		}
		System.out.print(sb.toString());
	}
}
