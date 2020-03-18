#include<iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int A, B, C, result;
	int count[10] = { 0, };
	cin >> A >> B >> C;
	result = A * B * C;
	while (result >= 10) {
		count[result % 10]++;
		result /= 10;
	}
	count[result]++;

	for (int i = 0; i < 10; i++)
		cout << count[i] << '\n';
}