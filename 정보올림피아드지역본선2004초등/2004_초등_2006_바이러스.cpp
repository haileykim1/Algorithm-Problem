#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int computer, connection;
	cin >> computer;
	cin >> connection;
	int isinfected[101] = { 0, };
	int connect[101][101] = { 0, };
	int a, b, virus = 0;

	for (int i = 0; i < connection; i++) {
		cin >> a >> b;
		connect[a][b] = 1;
	}
	int infection, index = 1,index2 = 0, temp;
	connect[0][0] = 1;
	while (index2 < index) {
		temp = connect[0][index2];
		if (isinfected[temp] != 1) {
			isinfected[temp] = 1;
			infection = temp;
			for (int i = 1; i < computer + 1; i++) {
				if ((connect[infection][i] == 1) || (connect[i][infection] == 1)) {
					connect[0][index++] = i;
				}
			}
		}
		index2++;
	}

	for (int i = 2; i < computer + 1; i++) {
		if (isinfected[i] == 1)
			virus++;
	}
	cout << virus;
}