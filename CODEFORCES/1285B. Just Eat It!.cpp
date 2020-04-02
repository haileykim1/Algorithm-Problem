#include<iostream>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t;
	cin >> t;
	while (t--) {
		int n, input, maxidx = 0, minidx = 0;
		long long max = -1000000001, min = 0;
		cin >> n;
		vector<long long> psum;
		psum.push_back(0);
		for (int i = 1; i <= n; ++i) {
			cin >> input;
			psum.push_back(psum[i - 1] + input);
			if (psum[i] > max) {
				max = psum[i];
				maxidx = i;
			}
			if (psum[i] <= min) {
				min = psum[i];
				minidx = i;
			}
		}
		if ((max - min < psum[n]) || (maxidx - minidx == n))
			cout << "YES\n";
		else
			cout << "NO\n";

	}
}