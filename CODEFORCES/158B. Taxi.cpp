#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, input;
	cin >> n;
	int s[5] = { 0, };
	for (int i = 0; i < n; ++i) {
		cin >> input;
		s[input]++;
	}
	int ans = s[4];
	ans += s[3];
	s[1] -= s[3];
	ans += (s[2] + 1) / 2;
	if (s[2] % 2)
		s[1] -= 2;
	if (s[1] > 0)
		ans += (s[1] + 3) / 4;

	cout << ans << '\n';
}