#include<iostream>
using namespace std;

int N, M, K;
long long arr[1000000] = { 0, };
long long seg[4000000] = { 0, };

long long init(int node, int nodeL, int nodeR) {
	if (nodeL == nodeR)
		return seg[node] = arr[nodeL];
	int mid = (nodeL + nodeR) / 2;
	return seg[node] = init(node * 2 + 1, nodeL, mid) + init(node * 2 + 2, mid + 1, nodeR);
}

long long update(int idx, long long data, int node, int nodeL, int nodeR) {

	if (nodeL > idx || nodeR < idx)
		return seg[node];
	if (nodeL == nodeR)
		return seg[node] = arr[nodeL] = data;

	int mid = (nodeL + nodeR) / 2;
	return seg[node] = update(idx, data, node * 2 + 1, nodeL, mid) + update(idx, data, node * 2 + 2, mid + 1, nodeR);
	

}

long long retSum(int left, int right, int node, int nodeL, int nodeR) {

	
	if (nodeL > right || nodeR < left)
		return 0;
	if (left <= nodeL && right >= nodeR)
		return seg[node];

	int mid = (nodeL + nodeR) / 2;
	return retSum(left, right, node * 2 + 1, nodeL, mid) + retSum(left, right, node * 2 + 2, mid + 1, nodeR);
	
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> N >> M >> K;
	for (int i = 0; i < N; ++i)
		cin >> arr[i];

	init(0, 0, N - 1);

	for (int i = 0; i < M + K; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		if (a == 1)
			update(b - 1, c, 0, 0, N - 1);
		else
			cout << retSum(b - 1, c - 1, 0, 0, N - 1) << '\n';
	}

	
}