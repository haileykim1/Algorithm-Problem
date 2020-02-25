#include<iostream>
#include<stack>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int K, n, sum = 0;
	stack<int> s;
	cin >> K;
	for (int i = 0; i < K; ++i) {
		cin >> n;
		if (n == 0)
			s.pop();
		else
			s.push(n);
	}
	while (!s.empty()) {
		n = s.top();
		sum += n;
		s.pop();
	}
	cout << sum;
}