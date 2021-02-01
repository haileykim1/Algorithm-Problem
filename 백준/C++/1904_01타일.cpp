#include<iostream>
using namespace std;

long long ans[1000000] = { 0, };

long long Recursive(int n) {
	if (n == 0)
		return 0;
	if (ans[n] != 0)
		return ans[n];

	return ans[n] = (Recursive(n - 1) + Recursive(n - 2)) % 15746;

}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	ans[0] = 0;
	ans[1] = 1;
	ans[2] = 2;


	cout << Recursive(N) % 15746 << '\n';


}
