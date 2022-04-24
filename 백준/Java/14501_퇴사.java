import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int maxi = 0;
	static int N;
	static int[] T, P;
	
	public static void Reservation(int profit, int day) {
		
		maxi = Math.max(maxi, profit);
		
		for(int i = day + 1; i < N; ++i) {
			if(i + T[i] <= N) {
				Reservation(profit + P[i], i + T[i] - 1);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(tok.nextToken());
			P[i] = Integer.parseInt(tok.nextToken());
		}
		
		Reservation(0, -1);
		System.out.print(maxi + "\n");
	}

}
