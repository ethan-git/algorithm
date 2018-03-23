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
import java.util.List;

/**
 * @author ejpark
 *
 */
public class A1005 {

	public static void main(String[] args) {
		int[] heights = {4, 6};
		int[] widths = {5, 6};
		String[][] boards = {{"CCBDE", "AAADE", "AAABF", "CCBBF"},{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}};

		for(int i=0; i<heights.length; i++) {
			int height = heights[i];
			int width = widths[i];
			String[] boardArr = boards[i];
			char[][] board = new char[height][width];
			for(int j=0; j<height; j++) {
				String line = boardArr[j];
				for(int k=0; k<width; k++) {
					board[j][k] = line.charAt(k);
				}
			}
			while(true) {
				List<Integer[]> matchedPoint = getMatchedPoint(board, height, width);
				if(matchedPoint.size()==0) {
					break;
				}
				removePoint(matchedPoint, board);
			}
			int cnt = 0;
			for(int j=0; j<height; j++) {
				for(int k=0; k<width; k++) {
					if(board[j][k] == '*') {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void removePoint(List<Integer[]> matchedPoint, char[][] board) {
		for(Integer[] points : matchedPoint) {
			int h = points[0];
			int w = points[1];
			board[h][w] = '*';
			board[h][w+1] = '*';
			board[h+1][w] = '*';
			board[h+1][w+1] = '*';
			if(h>0) {
				board[h+1][w] = board[h-1][w];
				board[h+1][w+1] = board[h-1][w+1];
				board[h-1][w] = '*';
				board[h-1][w+1] = '*';
			}
		}
	}

	private static List<Integer[]> getMatchedPoint(char[][] board, int height, int width) {
		List<Integer[]> matchedPoint = new ArrayList<Integer[]>();
		for(int j=0; j<height-1; j++) {
			for(int k=0; k<width-1; k++) {
				char first = board[j][k];
				char second = board[j][k+1];
				char third = board[j+1][k];
				char fourth = board[j+1][k+1];
				if(first!='*' && first==second && first==second && first==third && first==fourth) {
					Integer[] point = {j,k};
					matchedPoint.add(point);
				}
			}
		}
		return matchedPoint;
	}
}
/*
 * 14 15
 */
