#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int n, m;
int sq[1001][1001];
int map[1001][1001];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int ans = 0;
	cin >> n >> m;
	string input;
	for (int i = 1; i <= n; ++i) {

		cin >> input;
		for (int j = 1; j <= m; ++j) {
			map[i][j] = input[j - 1] - 48;
			if (map[i][j]) {
				sq[i][j] = 1;
				ans = 1;
			}
		}
	}

	for (int i = 2; i <= n; ++i) {
		for (int j = 2; j <= m; ++j) {
			if (map[i][j]) {
				sq[i][j] = min(sq[i - 1][j - 1], sq[i - 1][j]);
				sq[i][j] = min(sq[i][j], sq[i][j - 1]) + 1;
			}
			ans = max(ans, sq[i][j]);
		}
	}
	cout << ans * ans << '\n';
}