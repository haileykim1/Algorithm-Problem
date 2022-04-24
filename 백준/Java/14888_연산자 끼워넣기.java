import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int mini = 1000000000, maxi = -1000000000;
	static int N;
	static int[] A, op;
	
	public static void Operate(int result, int done, int operator) {
		int nResult = result;
		
		if(operator == 0) {
			nResult += A[done + 1];
		}else if(operator == 1) {
			nResult -= A[done + 1];
		}else if(operator == 2) {
			nResult *= A[done + 1];
		}else {
			nResult /= A[done + 1];
		}
		
		for(int i = 0; i < 4; ++i) {
			if(op[i] > 0) {
				--op[i];
				Operate(nResult, done + 1, i);
				++op[i];
			}
		}

		if(done == N - 2) {
			mini = Math.min(mini, nResult);
			maxi = Math.max(maxi, nResult);
			return;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		op = new int[4];
		

		StringTokenizer tok = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(tok.nextToken());
		}
		tok = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; ++i) {
			op[i] = Integer.parseInt(tok.nextToken());
		}
		
		Operate(0, -1, 0);
		
		System.out.print(maxi + "\n" + mini + "\n");
	}

}
