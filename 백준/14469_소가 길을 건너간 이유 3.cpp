#include<iostream>
#include<queue>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	//priority queue pair은 디폴트로 first로 정렬.
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> cow;

	for (int i = 1; i <= N; ++i) {
		int a, b;
		cin >> a >> b;
		cow.push({ a, b });
	}
	int nowtime = 0;
	while (!cow.empty()) {
		int arrival = cow.top().first;
		int check = cow.top().second;
		if (nowtime >= arrival)
			nowtime += check;
		else
			nowtime = arrival + check;

		cow.pop();
	}
	cout << nowtime << '\n';
}