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

import java.util.LinkedList;
import java.util.Locale;

/**
 * @author ejpark
 *
 */
public class A1002 {

	public static void main(String[] args) {
		int[] caches = { 3, 3, 2, 5, 2, 0 };
		String[][] cities = {
				{ "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" },
				{ "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" },
				{ "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
						"NewYork", "Rome" },
				{ "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju",
						"NewYork", "Rome" },
				{ "Jeju", "Pangyo", "NewYork", "newyork" }, { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" } };

		for (int i = 0; i < caches.length; i++) {
			int cacheSize = caches[i];
			String[] citiesArr = cities[i];
			LinkedList<String> lruList = new LinkedList<String>();
			int execTime = 0;
			for (String city : citiesArr) {
				city = city.toLowerCase(Locale.getDefault()).trim();
				if (lruList.contains(city)) {
					execTime += 1;
					lruList.remove(city);
				} else {
					if (lruList.size() >= cacheSize && !lruList.isEmpty()) {
						lruList.removeLast();
					}
					execTime += 5;
				}
				lruList.addFirst(city);
			}
			System.out.println(execTime);
		}
	}
}
/*
 * 50, 21, 60, 52, 16, 25
 */