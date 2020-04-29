#include<iostream>
#include<algorithm>
using namespace std;

int n;
long long a[100001] = { 0, };
long long DP[100001] = { 0, };	//index 지웠을 때 이때까지 지운 값 최대.

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
		//i - 1는 선택 못함. 
		//1).i - 2, i - 3 모두 선택하는 경우 -> (없음) 
		//2).i - 2, i - 3 모두 선택안하는 경우 -> (i - 4 를 선택하면 i - 2 선택하는게 더 이득, i - 4 선택안하면 i - 3 선택하는게 더 이득. 따라서 둘 중 하나는 선택해야함.)
		DP[i] = max(DP[i - 2], DP[i - 3]) + i * a[i];
	}
	long long temp = max(DP[maxVal], DP[maxVal - 1]);
	cout << temp << '\n';
}