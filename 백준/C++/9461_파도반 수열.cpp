#include<iostream>
using namespace std;

long long ans[101] = { 0, };

long long Recursive(int n) {
	if (ans[n])
		return ans[n];
	return ans[n] = Recursive(n - 1) + Recursive(n - 5);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int T;
	cin >> T;
	ans[1] = ans[2] = ans[3] = 1;
	ans[4] = ans[5] = 2;
	ans[6] = 3;
	ans[7] = 4;
	ans[8] = 5;
	ans[9] = 7;
	ans[10] = 9;
	while (T--) {
		int N;
		cin >> N;

		cout << Recursive(N) << '\n';

	}
}