#include<iostream>
#include<string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n, score = 0;
	string name;
	cin >> n;
	cin >> name;
	for (int i = 0; i < n; ++i)
		score += name[i] - 'A' + 1;
	cout << score;
}