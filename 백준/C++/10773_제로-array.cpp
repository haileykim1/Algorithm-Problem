#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int K, n, sum = 0;
	cin >> K;
	int s[100000];
	int top = 0;
	while (K--) {
		cin >> n;
		if (n)
			sum += s[top++] = n;
		else
			sum -= s[--top];
	}
	printf("%d",sum);
}