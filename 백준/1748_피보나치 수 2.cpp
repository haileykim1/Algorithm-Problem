#include<iostream>
using namespace std;

long long F[91];
int N;

long long DP(int n) {
	if (n == 0)
		return F[0] = 0;
	if (n == 1)
		return F[1] = 1;

	if (F[n])
		return F[n];
	else
		return F[n] = DP(n - 1) + DP(n - 2);

}

int main() {
	cin >> N;
	cout << DP(N) << '\n';

}