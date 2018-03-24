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

package algorithm.datastructure.a7785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author ejpark
 *
 */
public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		int n = sc.nextInt();
//		sc.nextLine();
		int n= 4;
		String[] logs = {"Baha enter", "Askar enter", "Baha leave", "Artem enter"};
//		Askar
//		Artem
		List<String> crewlist = new ArrayList<String>();
		for(int i=0; i<n; i++) {
//			String log = sc.nextLine();
			String log = logs[i];
			String[] datas = log.split(" ");
			String name = datas[0];
			String type = datas[1];
			switch(type) {
			case "enter" :
				if(!crewlist.contains(name)) {
					crewlist.add(name);
				}
				break;
			case "leave" :
				crewlist.remove(name);
				break;
			default :
			}
		}

		Collections.sort(crewlist);
		for(int i=crewlist.size()-1; i>=0; i--) {
			System.out.println(crewlist.get(i));
		}
	}
}
