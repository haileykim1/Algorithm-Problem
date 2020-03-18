#include<iostream>
using namespace std;

int bingo[5][5];
int nleft[12] = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
int lleft = 12;

void checkLine(int input) {
	int  i, j;
	for (i = 0; i < 5; ++i) {
		for (j = 0; j < 5; ++j) {
			if (bingo[i][j] == input) {
				if (!--nleft[i])
					lleft--;
				if (!--nleft[j + 5])
					lleft--;
				if (i == j) {
					if (!--nleft[10])
						lleft--;
				}
				if ((i + j) == 4) {
					if (!--nleft[11])
						lleft--;
				}
				break;
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int input, call = 0;
	for (int i = 0; i < 5; ++i) {
		for (int j = 0; j < 5; ++j) {
			cin >> input;
			bingo[i][j] = input;
		}
	}
	for (int i = 0; i < 5; ++i) {
		for (int j = 0; j < 5; ++j) {
			cin >> input;
			++call;
			checkLine(input);
			if (lleft < 10)
				break;
		}
		if (lleft < 10)
			break;
	}
	cout << call;
}