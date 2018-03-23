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

import java.util.ArrayList;

/**
 * @author ejpark
 *
 */
public class A1005 {

	public static void main(String[] args) {
		int[] heights = { 4, 6 };
		int[] widths = { 5, 6 };
		String[][] boards = { { "CCBDE", "AAADE", "AAABF", "CCBBF" },
				{ "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" } };
		for (int i = 0; i < heights.length; i++) {
			int height = heights[i];
			int width = widths[i];
			String[] boardArr = boards[i];
			char[][] board = new char[height][width];
			for (int j = 0; j < height; j++) {
				char[] lines = boardArr[j].toCharArray();
				for (int k = 0; k < width; k++) {
					board[j][k] = lines[k];
				}
			}
			Object[] listBoard = new Object[width];
			for (int k = 0; k < width; k++) {
				listBoard[k] = new ArrayList<Object>();
				for (int j = 0; j < height; j++) {

				}
			}
			while (true) {
				char[][] remove = scan(board, height, width);
				if (remove == null) {
					break;
				}
				for (int j = 0; j < height; j++) {
					for (int k = 0; k < width; k++) {
						if (remove[j][k] == '*') {
							if (j == 0) {
								board[j][k] = '*';
							} else {
								board[j][k] = board[j - 1][k];
								board[j - 1][k] = '*';
							}
						}
					}
				}
			}
			int cnt = 0;
			for (int j = 0; j < height; j++) {
				for (int k = 0; k < width; k++) {
					if(board[j][k] == '*') {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static char[][] scan(char[][] board, int height, int width) {
		char[][] remove = new char[height][width];
		boolean isRemoved = false;
		for (int j = 0; j < height-1; j++) {
			for (int k = 0; k < width-1; k++) {
				char first = board[j][k];
				char second = board[j][k + 1];
				char third = board[j + 1][k];
				char fourth = board[j + 1][k + 1];
				if (first != '*' && first == second && first == second && first == third && first == fourth) {
					remove[j][k] = '*';
					remove[j][k + 1] = '*';
					remove[j + 1][k] = '*';
					remove[j + 1][k + 1] = '*';
					isRemoved = true;
				}
			}
		}
		if (!isRemoved) {
			return null;
		}
		return remove;
	}
}
/*
 * 14 15
 */
