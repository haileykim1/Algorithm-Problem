#include<iostream>
#include<algorithm>
using namespace std;

int n;
long long a[100001] = { 0, };
long long DP[100001] = { 0, };	//index ������ �� �̶����� ���� �� �ִ�.

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> n;
	int input, maxVal = 0;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		++a[input];
		maxVal = input > maxVal ? input : maxVal;
	}
	DP[0] = 0;
	DP[1] = 1 * a[1];
	DP[2] = 2 * a[2];
	for (int i = 3; i <= maxVal; ++i) {
		//i - 1�� ���� ����. 
		//1).i - 2, i - 3 ��� �����ϴ� ��� -> (����) 
		//2).i - 2, i - 3 ��� ���þ��ϴ� ��� -> (i - 4 �� �����ϸ� i - 2 �����ϴ°� �� �̵�, i - 4 ���þ��ϸ� i - 3 �����ϴ°� �� �̵�. ���� �� �� �ϳ��� �����ؾ���.)
		DP[i] = max(DP[i - 2], DP[i - 3]) + i * a[i];
	}
	long long temp = max(DP[maxVal], DP[maxVal - 1]);
	cout << temp << '\n';
}