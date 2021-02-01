#include<iostream>
#include<memory.h>
#include<algorithm>
using namespace std;

int dp[1001][1001][2];
int card[1001];
bool turn = 0;

int DP(int start, int end, int turn) {
	if (start == end) {
		if (!turn)	
			return card[start];
		else
			return 0;
	}

	int& ret = dp[start][end][turn];
	if (ret != -1)
		return ret;

	if (!turn)
		return ret = max(DP(start + 1, end, !turn) + card[start], DP(start, end - 1, !turn) + card[end]);
	else
		return ret = min(DP( start + 1, end, !turn), DP( start, end - 1, !turn));
	
	
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int T;
	cin >> T;
	while (T--) {
		int N, input;
		cin >> N;
		memset(dp, -1, sizeof(dp));
		for (int i = 1; i <= N; ++i)
			cin >> card[i];

		cout << DP(1, N, turn) << '\n';

	}
}