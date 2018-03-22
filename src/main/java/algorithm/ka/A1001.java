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

/**
 * @author ejpark
 *
 */
public class A1001 {

	public static int getScore(String score, String bonusStr) {
		double bonus = 1;
		switch(bonusStr) {
		case "T" :
			bonus = 3;
			break;
		case "D" :
			bonus = 2;
			break;
		case "S" :
		default :
		}
		return (int) Math.pow(Double.parseDouble(score), bonus);
	}
	public static void main(String[] args) {
		String[] strArr = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
		for(String str : strArr) {
			String[] scores = str.split("\\D+");
			String[] options = str.split("\\d+");

			int score1 = getScore(scores[0], options[1].substring(0, 1));
			int score2 = getScore(scores[1], options[2].substring(0, 1));
			int score3 = getScore(scores[2], options[3].substring(0, 1));

			if(options[1].contains("*")) {
				score1 = score1 * 2;
			}else if(options[1].contains("#")) {
				score1 = score1 * -1;
			}

			if(options[2].contains("*")) {
				score1 = score1 * 2;
				score2 = score2 * 2;
			}else if(options[2].contains("#")) {
				score2 = score2 * -1;
			}

			if(options[3].contains("*")) {
				score2 = score2 * 2;
				score3 = score3 * 2;
			}else if(options[3].contains("#")) {
				score3 = score3 * -1;
			}
			int total = score1+score2+score3;
			System.out.println(total);
		}
	}
}
/*
1S2D*3T 37
1D2S#10S 9
1D2S0T 3
1S*2T*3S 23
1D#2S*3S 5
1T2D3D# -4
1D2S3T* 59
*/