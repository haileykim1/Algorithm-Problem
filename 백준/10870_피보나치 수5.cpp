#include<iostream>
using namespace std;

int fib[21] = { 0, };

int Fib(int n) {
	if (n == 0)
		return fib[0];
	if (fib[n] != 0)
		return fib[n];
	else
		return fib[n] = Fib(n - 1) + Fib(n - 2);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	
	fib[0] = 0;
	fib[1] = 1;
	cout << Fib(n) << '\n';
	
}