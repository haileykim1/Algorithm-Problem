import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static char[][][] cube;
	static char[] color = {'w', 'g', 'r', 'o', 'b', 'y'};
	static Character[] mapColor = {'U', 'L', 'F', 'B', 'R', 'D'};
	static int[][] side = {{3, 1, 2, 4}, {0, 3, 5, 2}, {0, 1, 5, 4},
			{5, 1, 0, 4}, {0, 2, 5, 3}, {2, 1, 3, 4}};
	static int[][] sideRow = {{4, 0, 0, 0}, {2, 2, 2, 2}, {4, 3, 0, 6},
			{1, 2, 5, 7}, {3, 3, 3, 3}, {1, 1, 5, 1}};
	static int[][] rowX = {{0, 0, 0}, {2, 2, 2}, {0, 1, 2}, {0, 1, 2}, 
			{2, 2, 2}, {0, 0, 0}, {2, 1, 0}, {2, 1, 0}};
	static int[][] rowY = {{0, 1, 2}, {0, 1, 2}, {0, 0, 0}, {2, 2, 2},
			{2, 1, 0}, {2, 1, 0}, {0, 0, 0}, {2, 2, 2}};
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();   
	
	public static void Turn(int face, int clock) {
		if(clock == 1) {
			char[] temp = new char[3];
			for(int i = 0; i < 3; ++i) {
				temp[i] = cube[side[face][0]][rowX[sideRow[face][0]][i]][rowY[sideRow[face][0]][i]];
			}
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					cube[side[face][i]][rowX[sideRow[face][i]][j]][rowY[sideRow[face][i]][j]] = cube[side[face][i + 1]][rowX[sideRow[face][i + 1]][j]][rowY[sideRow[face][i + 1]][j]];
				}
			}
			for(int i = 0; i < 3; ++i) {
				cube[side[face][3]][rowX[sideRow[face][3]][i]][rowY[sideRow[face][3]][i]] = temp[i];
			}
			char[][] temp2 = new char[3][3];
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp2[i][j] = cube[face][i][j];
				}
			}
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					cube[face][j][2 - i] = temp2[i][j];
				}
			}
			
		}else {
			char[] temp = new char[3];
			for(int i = 0; i < 3; ++i) {
				temp[i] = cube[side[face][3]][rowX[sideRow[face][3]][i]][rowY[sideRow[face][3]][i]];
			}
			for(int i = 3; i > 0; --i) {
				for(int j = 0; j < 3; ++j) {
					cube[side[face][i]][rowX[sideRow[face][i]][j]][rowY[sideRow[face][i]][j]] = cube[side[face][i - 1]][rowX[sideRow[face][i - 1]][j]][rowY[sideRow[face][i - 1]][j]];
					
				}
			}
			for(int i = 0; i < 3; ++i) {
				cube[side[face][0]][rowX[sideRow[face][0]][i]][rowY[sideRow[face][0]][i]] = temp[i];
			}
			char[][] temp2 = new char[3][3];
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					temp2[i][j] = cube[face][i][j];
				}
			}
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					cube[face][2 - j][i] = temp2[i][j];
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		cube = new char[6][3][3];
		
		for(int i = 0; i < 6; ++i) {
			map.put(mapColor[i], i);
		}
		
		for(int t = 0; t < T; ++t) {
			//ÃÊ±âÈ­
			for(int i = 0; i < 6; ++i) {
				for(int m = 0; m < 3; ++m) {
					for(int n = 0; n < 3; ++n) {
						cube[i][m][n] = color[i];
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for(int i = 1; i <= n; ++i) {
				String input = tok.nextToken();
				int face = map.get(input.charAt(0));
				int clock = 1;
				if(input.charAt(1) == '-') {
					clock = -1;
				}
				Turn(face, clock);

			}
			
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					sb.append(cube[0][i][j]);
				}
				sb.append('\n');
			}
			
		}
		
		System.out.print(sb.toString());
	}
}
