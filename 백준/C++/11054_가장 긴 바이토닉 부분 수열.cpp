#include<iostream>
#include<algorithm>
using namespace std;

int A[1000];
int inc[1002], bestInc[1002];
int desc[1002], bestDec[1002];
int length = 0, revLen = 0;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	for (int i = 1; i <= N; ++i) {
		cin >> A[i];
	}
	inc[1] = 1;
	bestInc[1] = A[1];
	length = 1;
	desc[1] = 1;
	bestDec[1] = A[N];
	revLen = 1;
	// LIS와 ReverseLIS 합이 가장 큰것
	for (int i = 2; i <= N; ++i) {
		if (A[i] > bestInc[length]) {
			inc[i] = ++length;
			bestInc[length] = A[i];
		}
		else {

			int temp = lower_bound(bestInc + 1, bestInc + length, A[i]) - bestInc;
			inc[i] = temp;
			if (A[i] < bestInc[temp])
				bestInc[temp] = A[i];
		}

		int rev = N - i + 1; // (1, N), (2, N - 1), ..
		if (A[rev] > bestDec[revLen]) {
			desc[i] = ++revLen;
			bestDec[revLen] = A[rev];

		}
		else {
			int temp = lower_bound(bestDec + 1, bestDec + revLen, A[rev]) - bestDec;
			desc[i] = temp;
			if (A[rev] < bestDec[temp])
				bestDec[temp] = A[rev];
		}
		
		
	}

	int maxLen = 0;
	for (int i = 1; i <= N; ++i) {
		int sum = inc[i] + desc[N - i + 1] - 1;
		maxLen = maxLen > sum ? maxLen : sum;
	}
	cout << maxLen << '\n';

}