#include<iostream>
#include<queue>
#include<vector>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int N, input;
	cin >> N;
	priority_queue<int> smaller;	//max heap
	priority_queue<int, vector<int>, greater<int>> bigger;	//min heap
	cin >> input;
	bigger.push(input);	//pivot이 bigger에 있다고 가정.
	cout << input << '\n';
	for (int i = 1; i < N; ++i) {
		cin >> input;
		if (input < bigger.top())
			smaller.push(input);
		else
			bigger.push(input);

		//bigger크기가 smaller과 같거나 하나 더 크게
		if (smaller.size() > bigger.size()) {
			bigger.push(smaller.top());
			smaller.pop();
		}
		else if (bigger.size() > smaller.size() + 1) {
			smaller.push(bigger.top());
			bigger.pop();
		}

		if (smaller.size() == bigger.size())
			cout << smaller.top() << '\n';
		else
			cout << bigger.top() << '\n';
	}

}