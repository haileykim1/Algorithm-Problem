#include<iostream>
#include<queue>
using namespace std;

int josephus(int n, int k) {
	queue<int> survivors;

	for (int i = 1; i <= n; ++i)
		survivors.push(i);
	while (survivors.size() != 2) {
		survivors.pop();
		int pass;
		for (int i = 0; i < k - 1; ++i) {
			pass = survivors.front();
			survivors.pop();
			survivors.push(pass);
		}
	}
	int a = survivors.front(), b = survivors.back();
	if (a < b)
		cout << a << " " << b << endl;
	else
		cout << b << " " << a << endl;
}

int main() {
	ios::sync_with_stdio(false);
	int C, N, K;
	cin >> C;
	while (C--) {
		cin >> N >> K;
		josephus(N, K);
	}
}