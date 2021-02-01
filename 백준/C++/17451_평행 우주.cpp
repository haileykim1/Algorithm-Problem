#include<iostream>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, input;
	vector<int> v;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		v.push_back(input);
	}
	long long max = 0;
	for (int i = n - 1; i >= 0; --i) {
		if (v[i] >= max) {
			max = v[i];
		}
		else {
			max = ((max + v[i] - 1) / v[i]) * v[i];
		}
	}
	cout << max << '\n';
}