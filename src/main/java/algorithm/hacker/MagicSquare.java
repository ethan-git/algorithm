package algorithm.hacker

public class MagicSquare {
	public static int[][] test() {
		int size = 3;
		int maxIdx = size - 1;
		int[][] magic = new int[size][size];
		int number = 1;
		int rowIdx = 0;
		int colIdx = 1;
		magic[rowIdx][colIdx] = number;
		int maxCnt = size*size;
		while (number < maxCnt) {
			number++;
			rowIdx--;
			colIdx++;
			if (rowIdx < 0) {
				rowIdx = maxIdx;
			}
			if (colIdx > maxIdx) {
				colIdx = 0;
			}
			if (magic[rowIdx][colIdx] == 0) {
				magic[rowIdx][colIdx] = number;
			} else {
				rowIdx++;
				colIdx--;
				if (rowIdx > maxIdx) {
					rowIdx = 0;
				}
				if (colIdx < 0) {
					colIdx = maxIdx;
				}
				rowIdx++;
				magic[rowIdx][colIdx] = number;
			}
		}
		
		for(int[] row : magic) {
//			System.out.println(String.format("%d %d %d", row[0], row[1], row[2]));
		}
		return magic;
	}

	public static int[][][] test1(int[][] magic) {
		int size = 3;
		int maxPossible = ((size*((size^2)+1))/2)+1;
		int[][] baseMagic = magic;
		int[][][] possible = new int[maxPossible*2][size][size];
		possible[0] = magic;
		for(int i=1; i<maxPossible; i++) {
			for(int j=0; j<size; j++) {
				int rowIdx = size-1;
				for(int k=0; k<size; k++) {
					possible[i][j][k] = baseMagic[rowIdx][j];
					rowIdx--;
				}
			}
			baseMagic = possible[i];
		}
		baseMagic = test2(magic);
		possible[maxPossible] = baseMagic;
		for(int i=maxPossible+1; i<maxPossible*2; i++) {
			for(int j=0; j<size; j++) {
				int rowIdx = size-1;
				for(int k=0; k<size; k++) {
					possible[i][j][k] = baseMagic[rowIdx][j];
					rowIdx--;
				}
			}
			baseMagic = possible[i];
		}
		return possible;
	}
	
	public static int[][] test2(int[][] magic) {
		int size = 3;
		int[][] opp = new int[size][size];
		for(int i=0; i<size; i++) {
			int idx = 2;
			for(int j=0; j<size; j++) {
				opp[i][j] = magic[i][idx];
				idx--;
			}
		}
		return opp;
	}
	
	public static void main(String[] args) {
		int[][] magic = test();
		int[][][] possible = test1(magic);
		for(int i=0; i<possible.length; i++) {
			for(int j=0; j<3; j++) {
				int[] pos = possible[i][j];
				System.out.println(String.format("%d %d %d", pos[0], pos[1], pos[2]));
			}
			System.out.println();
		}
	}
}
