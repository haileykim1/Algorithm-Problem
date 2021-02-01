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
	bigger.push(input);	//pivot�� bigger�� �ִٰ� ����.
	cout << input << '\n';
	for (int i = 1; i < N; ++i) {
		cin >> input;
		if (input < bigger.top())
			smaller.push(input);
		else
			bigger.push(input);

		//biggerũ�Ⱑ smaller�� ���ų� �ϳ� �� ũ��
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