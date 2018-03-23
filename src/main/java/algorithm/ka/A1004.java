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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @author ejpark
 *
 */
public class A1004 {

	public static void main(String[] args) {
		String[] str1Arr = {"FRANCE", "handshake", "aa1+aa2", "E=M*C^2"};
		String[] str2Arr = {"french", "shake hands", "AAAA12", "e=m*c^2"};
		int eNum = 65536;
		for (int i = 0; i < str1Arr.length; i++) {
			String str1 = str1Arr[i];
			String str2 = str2Arr[i];

			List<String> str1List = getSplitList(str1);
			List<String> str2List = getSplitList(str2);
			List<String> rList = new ArrayList<String>();
			List<String> uList = new ArrayList<String>(str2List);
			for(int j=0; j<str1List.size(); j++) {
				String value1 = str1List.get(j);
				if(str2List.contains(value1)) {
					rList.add(value1);
				}
				if(!uList.contains(value1)) {
					uList.add(value1);
				}
			}
			BigDecimal result = new BigDecimal(rList.size());
			int uSize = uList.size();
			if(uSize==0) {
				result = new BigDecimal(eNum);
			}else {
				result = result.multiply(new BigDecimal(eNum)).divide(new BigDecimal(uSize), BigDecimal.ROUND_DOWN);
			}
			System.out.println(result.intValue());
		}
	}

	private static List<String> getSplitList(String value){
		List<String> strList = new ArrayList<String>();
		int size = value.length();
		for(int j=0; j<size; j++) {
			if(j==size-1) {
				break;
			}
			String str = value.substring(j, j+2);
			if(isAlphaChar(str)) {
				strList.add(str.toLowerCase(Locale.ENGLISH));
			}
		}
		return strList;
	}

	private static boolean isAlphaChar(String str) {
		return Pattern.matches("^[a-zA-Z]+", str);
	}
}
/*
 *   16384
 *   65536
 *   43690
 *   65536
 * 
 */
