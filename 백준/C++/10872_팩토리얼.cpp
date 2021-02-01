#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	long long ans = 1;
	while (N) {
		ans *= N--;
	}
	cout << ans << '\n';
}