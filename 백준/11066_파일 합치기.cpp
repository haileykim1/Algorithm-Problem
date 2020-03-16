#include<iostream>
#define MAX 987654321;
using namespace std;

int T, K;
int DP[501][501];
int cost[501];
int sum[501];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> T;
	while (T--) {
		cin >> K;
		for (int i = 1; i <= K; ++i) {
			cin >> cost[i];
			sum[i] = sum[i - 1] + cost[i];
		}

		for (int s = 1; s < K; ++s) {
			for (int i = 1; s + i <= K; ++i) {
				int j = i + s;
				DP[i][j] = MAX;

				for (int mid = i; mid < j; ++mid) {
					int div = DP[i][mid] + DP[mid + 1][j] + sum[j] - sum[i - 1];
					DP[i][j] = DP[i][j] > div ? div : DP[i][j];
				}
			}

		}
		cout << DP[1][K] << '\n';
	}
}