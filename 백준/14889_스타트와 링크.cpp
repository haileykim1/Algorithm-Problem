#include<iostream>
#include<vector>
using namespace std;

int N;
int S[20][20];
int mindiff = 200;
vector<int> startmem, linkmem;

void DFS(int now, int startsum, int linksum) {
	if (now == N) {
		if (startsum >= linksum)
			mindiff = startsum - linksum < mindiff ? startsum - linksum : mindiff;
		else
			mindiff = linksum - startsum < mindiff ? linksum - startsum : mindiff;

		return;
	}
	if (startmem.size() < N / 2) {
		int temp1 = 0;
		for (int i = 0; i < startmem.size(); ++i) {
			temp1 += S[startmem[i]][now] + S[now][startmem[i]];
		}
		startmem.push_back(now);
		DFS(now + 1, startsum + temp1, linksum);
		startmem.pop_back();
	}
	if (linkmem.size() < N / 2) {
		int temp2 = 0;
		for (int i = 0; i < linkmem.size(); ++i)
			temp2 += S[linkmem[i]][now] + S[now][linkmem[i]];
		linkmem.push_back(now);
		DFS(now + 1, startsum, linksum + temp2);
		linkmem.pop_back();
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N;
	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j)
			cin >> S[i][j];
	}
	startmem.push_back(0);
	DFS(1, 0, 0);	//1번째 멤버까지 결정한 상태.
	cout << mindiff << '\n';
}