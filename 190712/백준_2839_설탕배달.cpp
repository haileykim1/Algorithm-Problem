#include<iostream>
using namespace std;

int main() {
	int N;//¼³ÅÁÀÇ ¹«°Ô
	int bag5 = 0, bag3 = 0;//5,3°¹¼ö
	cin >> N;
	for (; N>= 3;bag3++) {
		if (N % 5 == 0) {
			bag5 = N / 5;
			N = 0;
			break;
		}
		N = N - 3;
	}
	
	if (N == 0) {
		cout << bag3 + bag5 << endl;
	}
	else {
		cout << -1 << endl;
	}
}