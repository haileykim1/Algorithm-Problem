#include<iostream>
#include<memory.h>
#include<queue>
using namespace std;

int map[9][9];
bool row[9][10];
bool col[9][10];
bool sqr[9][10];

void DFS(int cnt) {
	int x = cnt / 9;
	int y = cnt % 9;

	if (cnt == 81) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				cout << map[i][j] << " ";
			}
			cout << '\n';
		}
		exit(0);
	}

	if (!map[x][y]) {
		for (int i = 1; i <= 9; ++i) {
			if ((!row[x][i]) && (!col[y][i]) && (!sqr[(x / 3) * 3 + y / 3][i])) {
				row[x][i] = 1;
				col[y][i] = 1;
				sqr[(x / 3) * 3 + y / 3][i] = 1;
				map[x][y] = i;
				DFS(cnt + 1);
				map[x][y] = 0;
				row[x][i] = 0;
				col[y][i] = 0;
				sqr[(x / 3) * 3 + y / 3][i] = 0;

			}
		}
	}
	else
		DFS(cnt + 1);

}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	for (int i = 0; i < 9; ++i) {
		for (int j = 0; j < 9; ++j) {
			cin >> map[i][j];
			if (map[i][j]) {
				row[i][map[i][j]] = 1;
				col[j][map[i][j]] = 1;
				sqr[(i / 3) * 3 + j / 3][map[i][j]] = 1;
			}
		}
	}

	DFS(0);

}