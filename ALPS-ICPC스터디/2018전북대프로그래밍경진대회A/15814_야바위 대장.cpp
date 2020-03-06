#include<iostream>
#include<string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	string S;
	int T, A, B, temp;
	cin >> S;
	cin >> T;
	for (int i = 0; i < T; ++i) {
		cin >> A >> B;
		temp = S[A];
		S[A] = S[B];
		S[B] = temp;
	}
	cout << S;
}