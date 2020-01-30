#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int tile[30] = { 1, 1, 5, 11 };
	for (int i = 4; i <= 25; ++i)
		tile[i] = tile[i - 1] + 5 * tile[i - 2] + tile[i - 3] - tile[i - 4];
	
	int T;
	cin >> T;
	while(T--){
		int N;
		cin >> N;
		cout << tile[N] << '\n';
	}
}