#include<iostream>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int K, n, sum = 0;
	vector<int> s;
	cin >> K;
	for (int i = 0; i < K; ++i) {
		cin >> n;
		if (n == 0)
			s.pop_back();
		else
			s.push_back(n);
	}
	while (!s.empty()) {
		n = s.back();
		sum += n;
		s.pop_back();
	}
	cout << sum;
}