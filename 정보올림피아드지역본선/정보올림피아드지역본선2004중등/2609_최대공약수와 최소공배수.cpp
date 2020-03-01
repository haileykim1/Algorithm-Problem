#include<iostream>
using namespace std;

int EGCD(int A, int B) {
	if ((A % B) == 0) 
		return B;
	return EGCD(B, A % B);
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int A, B, gcd, lcm;
	cin >> A >> B;
	if (A >= B)
		gcd = EGCD(A, B);
	else
		gcd = EGCD(B, A);
	lcm = A * (B / gcd);
	cout << gcd << '\n' << lcm;
}