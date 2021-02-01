#include<iostream>
using namespace std;
#define MOD 1000000007LL

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, K;
	//MOD가 소수 -> (K!)^MOD - 1 = 1(mod MOD)
	//(K!)^MOD - 2 = (K!)^-1 (mod MOD)
	//1/k!(n - k)! = (k!(n - k)!)^(MOD - 2)
	long long fac[4000001];
	long long inv[4000001];
	cin >> N >> K;
	fac[1] = 1;
	for (int i = 2; i <= N; ++i)
		fac[i] = (fac[i - 1] * i) % MOD;

	long long a, b, up = 1;
	a = fac[N];
	b = MOD - 2;
	//divide & conquer 이용 -> a^b구하기
	//b 짝수 : a^b = a^(b / 2) * a^(b / 2)
	//b 홀수 : a^b = a^(b / 2) * a^(b / 2) * a
	while (b) {
		if (b % 2) {
			up *= a;
			up %= MOD;
		}
		a *= a;
		a %= MOD;
		b /= 2;
	}
	inv[N] = up;

	//N, K 1일때 예외처리
	for (int i = N - 1; i; --i)
		inv[i] = (inv[i + 1] * (i + 1)) % MOD;

	long long first = fac[N] * inv[N - K] % MOD;
	if (N == K || !N || !K)
		cout << 1 << '\n';
	else
		cout << first * inv[K] % MOD << '\n';
}