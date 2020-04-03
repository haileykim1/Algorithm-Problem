#include<iostream>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, input;
	cin >> n;
	vector<long long> psum;
	psum.push_back(0);

	for (int i = 1; i <= n; ++i) {
		cin >> input;
		psum.push_back(psum[i - 1] + input);
	}

	if (psum[n] % 3) {
		cout << "0\n";
		return 0;
	}

	long long ans = 0;
	long long oneThird = psum[n] / 3, twoThird = oneThird * 2;
	int first = 0;
	for (int i = 1; i < n; ++i) {
		if (psum[i] == twoThird)
			ans += first;
		if (psum[i] == oneThird)
			++first;
	}
	
	cout << ans << '\n';
}