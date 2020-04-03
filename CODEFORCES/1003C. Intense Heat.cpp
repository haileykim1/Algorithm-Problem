#include<iostream>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, k, input;
	cin >> n >> k;
	vector<long long> psum;
	psum.push_back(0);
	for (int i = 1; i <= n; ++i) {
		cin >> input;
		psum.push_back(psum[i - 1] + input);
	}
	double max = 0;
	for (int i = 0; i <= n - k; ++i) {
		for (int j = i + k; j <= n; ++j) {
			double temp = (double)(psum[j] - psum[i]) / (j - i);
			max = temp > max ? temp : max;
		}
	}
	cout.precision(16);
	cout << max << '\n';
}