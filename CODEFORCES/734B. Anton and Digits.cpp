#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	long long sum = 0;
	int k2, k3, k5, k6;
	cin >> k2 >> k3 >> k5 >> k6;
	int n256 = min(k2, k5);
	n256 = min(n256, k6);
	int n32 = min(k3, k2 - n256);
	sum = 256 * n256 + 32 * n32;
	cout << sum << '\n';
}