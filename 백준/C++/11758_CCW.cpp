#include<iostream>
using namespace std;

int a1, a2, a3, b1, b2, b3;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);


	//벡터의 외적 이용
	cin >> a1 >> b1;
	cin >> a2 >> b2;
	cin >> a3 >> b3;

	int temp = (a1 - a2) * (b3 - b2) - (a3 - a2) * (b1 - b2);
	if (temp > 0) {
		cout << -1 << '\n';
	}
	else if (temp == 0)
		cout << 0 << '\n';
	else
		cout << 1 << '\n';
	return 0;


}