#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, input, ans = 0;
	cin >> N;
	priority_queue<int, vector<int>, greater<int>> min_heap;
	//�ּ� �ΰ� ������ ���ļ� �� �ּ� ���� �־��ش�.
	for (int i = 0; i < N; ++i) {
		cin >> input;
		min_heap.push(input);
	}

	for (int i = 0; i < N - 1; ++i) {
		input = min_heap.top();
		min_heap.pop();
		input += min_heap.top();
		min_heap.pop();

		ans += input;
		min_heap.push(input);
	}
	cout << ans << '\n';
}