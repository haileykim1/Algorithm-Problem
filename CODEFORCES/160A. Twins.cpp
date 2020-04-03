#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	vector<int> coins(n);
	int sum = 0;
	for (int i = 0; i < n; ++i) {
		cin >> coins[i];
		sum += coins[i];
	}
	sort(coins.begin(), coins.end());
	int cnt = 1, split = coins[n - 1];
	while (split <= sum / 2) {
		split += coins[n - ++cnt];
	}
	cout << cnt << '\n';
}