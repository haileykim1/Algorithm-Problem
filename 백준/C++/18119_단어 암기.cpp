#include<iostream>
#include<string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, M;
	cin >> N >> M;
	string input;
	int check[10000] = { 0, };
	for (int i = 0; i < N; ++i) {
		cin >> input;
		for (int j = 0; j < input.size(); ++j)
			check[i] |= 1 << (input[j] - 'a');
	}
	int mem = ~0;
	while (M--) {
		int a;
		char b;
		cin >> a >> b;

		if (a == 1)
			mem &= ~(1 << (b - 'a'));
		else
			mem |= (1 << (b - 'a'));

		int cnt = 0;
		for (int i = 0; i < N; ++i) {
			if ((check[i] & mem) == check[i])
				++cnt;
		}
		cout << cnt << '\n';
	}
}