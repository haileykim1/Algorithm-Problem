#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int m;
	cin >> m;

	long long dp[500001][22];

	for (int i = 1; i <= m; ++i)
		cin >> dp[i][0];
	
	for (int j = 1; j < 19; ++j) {
		for (int i = 1; i <= m; ++i)
			dp[i][j] = dp[dp[i][j - 1]][j - 1];
	}

	int Q;
	cin >> Q;
	while (Q--) {
		long long n, x;
		cin >> n >> x;
		
		for (int i = 0; n; i++) {
			if (n & 1)
				x = dp[x][i];
			n >>= 1;
		}
		cout << x << '\n';
	}

}