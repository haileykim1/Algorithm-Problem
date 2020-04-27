#include<iostream>
#include<algorithm>
using namespace std;

int height[5002];
int n;

int solve(int start, int end, int minheight) {
	if (start >= end)
		return 0;


	int minidx = start;
	for (int i = start; i < end; ++i) {
		if (height[i] < height[minidx])
			minidx = i;
	}
	return min(end - start , solve(start, minidx, height[minidx]) + solve(minidx + 1, end, height[minidx]) + height[minidx] - minheight);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> height[i];
	
	cout << solve(0, n , 0) << '\n';

}