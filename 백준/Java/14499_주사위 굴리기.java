import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N, M, x, y, K;
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	static int[][] map;
	//up N W E S down 
	static int[] dice = {0, 0, 0, 0, 0, 0};
	static int[] NSIdx = {0, 1, 5, 4};
	static int[] WEIdx = {0, 2, 5, 3};

	public static void Roll(int direction) {
		if(direction == 1) {
			int temp = dice[WEIdx[3]];
			for(int i = 3; i >= 1; --i) {
				dice[WEIdx[i]] = dice[WEIdx[i - 1]];
			}
			dice[WEIdx[0]] = temp;
		}else if(direction == 2) {
			int temp = dice[WEIdx[0]];
			for(int i = 0; i < 3; ++i) {
				dice[WEIdx[i]] = dice[WEIdx[i + 1]];
			}
			dice[WEIdx[3]] = temp;
		}else if(direction == 3) {
			int temp = dice[NSIdx[0]];
			for(int i = 0; i < 3; ++i) {
				dice[NSIdx[i]] = dice[NSIdx[i + 1]];
			}
			dice[NSIdx[3]] = temp;
		}else {
			int temp = dice[NSIdx[3]];
			for(int i = 3; i >= 1; --i) {
				dice[NSIdx[i]] = dice[NSIdx[i - 1]];
			}
			dice[NSIdx[0]] = temp;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		x = Integer.parseInt(tok.nextToken());
		y = Integer.parseInt(tok.nextToken());
		K = Integer.parseInt(tok.nextToken());
		map = new int[N][M];
		
		for(int i = 0; i < N; ++i) {
			tok = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		tok = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; ++i) {
			int instruction = Integer.parseInt(tok.nextToken());
			int nx = x + dx[instruction];
			int ny = y + dy[instruction];
			if((nx < 0) || (nx >= N) || (ny < 0) || (ny >= N)) {
				continue;
			}
			x = nx;
			y = ny;
			
			Roll(instruction);
			
			if(map[x][y] == 0) {
				map[x][y] = dice[0];
			}else {
				dice[0] = map[x][y];
				map[x][y] = 0;
			}
			sb.append(dice[5] + "\n");
		}
		System.out.print(sb.toString());
		
	}
	
}
