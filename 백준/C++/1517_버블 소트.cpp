#include<iostream>
using namespace std;

int arr[500000], arr2[500000];

long long solve(int start, int end) {
	if (start == end)
		return 0;

	int mid = (start + end) / 2;
	long long result = solve(start, mid) + solve(mid + 1, end);
	int i = start;
	int j = mid + 1;
	int index = 0;
	while (i <= mid || j <= end) {
		if (i <= mid && (j > end || arr[i] <= arr[j]))
			arr2[index++] = arr[i++];
		else {
			result += (long long)(mid - i + 1);
			arr2[index++] = arr[j++];
		}
	}
	for (int k = start; k <= end; ++k)
		arr[k] = arr2[k - start];
	return result;
}


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	for (int i = 0; i < N; ++i)
		cin >> arr[i];
	long long ans = solve(0, N - 1);
	cout << ans;
}