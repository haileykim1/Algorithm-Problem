#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	vector<int> input;
	int put, sum = 0;
	for (int i = 0; i < 5; ++i) {
		cin >> put;
		sum += put;
		input.push_back(put);
	}
	sort(input.begin(),input.end());
	cout << sum / 5 << '\n' << input[2];

}