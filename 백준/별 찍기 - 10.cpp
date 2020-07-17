#include<iostream>
using namespace std;
bool stars[2200][2200] = { false };//¹é¸¸.

void Stamp(int n, int y, int x) {
	if (n == 3) {
		for (int i = y; i < y + 3; ++i) {
			for (int j = x; j < x + 3; ++j) {
				if ((i == y + 1) && (j == x + 1))
					stars[i][j] = 0;
				else
					stars[i][j] = 1;
			}
		}
	}
	else {
		int temp = n / 3;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if ((i == 1) && (j == 1))
					continue;
				Stamp(temp, y + i * temp, x + j * temp);
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	Stamp(N, 0, 0);

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (stars[i][j])
				cout << "*";
			else
				cout << " ";
			
		}
		cout << '\n';
	}

}