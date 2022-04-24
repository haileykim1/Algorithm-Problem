import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] S;
	static int[] start, link;
	static int ans = 80000;
	
	public static void Pick(int done, int startCur, int linkCur, int startSum, int linkSum) {
		
		if(done == N - 1) {
			ans = Math.min(ans, Math.abs(startSum - linkSum));
			return;
		}
		
		//스타트팀 배정
		if(startCur < (N / 2)) {
			start[startCur] = done + 1;
			int nStartSum = startSum;

			for(int i = 0; i < startCur; ++i) {
				nStartSum += S[start[i]][done + 1] + S[done + 1][start[i]];
			}
			Pick(done + 1, startCur + 1, linkCur, nStartSum, linkSum);
			
			
		}
		//링크 팀 배정
		if(linkCur < (N / 2)) {
			link[linkCur] = done + 1;
			int nLinkSum = linkSum;
			for(int i = 0; i < linkCur; ++i) {
				nLinkSum += S[link[i]][done + 1] + S[done + 1][link[i]];
			}
			Pick(done + 1, startCur, linkCur + 1, startSum, nLinkSum);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		S = new int[N + 1][N + 1];
		start = new int[N / 2];
		link = new int[N / 2];
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				S[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		Pick(-1, 0, 0, 0, 0);
		System.out.println(ans + "\n");
	}
	
}
