#include<iostream>
#include<vector>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	int N, S, input, sum = 0, min = 100000;
	vector<int> arr;

	cin >> N >> S;
	for (int i = 0; i < N; i++) {
		cin >> input;
		arr.push_back(input);
	}

	int j = 0, i = 0;
	while (i < N) {
		if (sum >= S) {
			min = j - i < min ? j - i : min;
			sum -= arr.at(i++);
		}
		else if (j == N)
			break;
		else
			sum += arr.at(j++);
	}
	
	if (min == 100000)
		cout << 0;
	else
		cout << min;
}