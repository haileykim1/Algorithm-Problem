#include<iostream>
#include<algorithm>
using namespace std;

int N;
int map[501][501];
int dp[501][501];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N;
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= i; ++j)
			cin >> map[i][j];
	}
	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= i; ++j) {
			dp[i][j] = max(dp[i - 1][j - 1] + map[i][j], dp[i - 1][j] + map[i][j]);
		}
	}
	int ans = 0;
	for (int i = 1; i <= N; ++i)
		ans = max(ans, dp[N][i]);

	cout << ans << '\n';
}