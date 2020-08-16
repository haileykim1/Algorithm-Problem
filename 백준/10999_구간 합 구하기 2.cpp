#include<iostream>
using namespace std;

int N, M, K;
long long arr[1000000] = { 0, };
long long seg[2100000] = { 0, };
long long updata[2100000] = { 0, };

long long init(int node, int nodeL, int nodeR) {

	if (nodeL == nodeR)
		return seg[node] = arr[nodeL];

	int mid = (nodeL + nodeR) / 2;
	return seg[node] = init(node * 2 + 1, nodeL, mid) + init(node * 2 + 2, mid + 1, nodeR);
}

void retUpdate(int node, int nodeL, int nodeR) {
	if (updata[node]) {
		seg[node] += (nodeR - nodeL + 1) * updata[node];
		if (nodeL != nodeR) {
			updata[node * 2 + 1] += updata[node];
			updata[node * 2 + 2] += updata[node];
		}
		updata[node] = 0;
	}
}

void update(int left, int right, long long upVal, int node, int nodeL, int nodeR) {

	retUpdate(node, nodeL, nodeR);
	if (right < nodeL || nodeR < left)
		return;
	if (left <= nodeL && nodeR <= right) {
		seg[node] += (nodeR - nodeL + 1) * upVal;
		if (nodeL != nodeR) {
			updata[node * 2 + 1] += upVal;
			updata[node * 2 + 2] += upVal;
		}
		return;
	}
	int mid = (nodeL + nodeR) / 2;
	update(left, right, upVal, node * 2 + 1, nodeL, mid);
	update(left, right, upVal, node * 2 + 2, mid + 1, nodeR);
	seg[node] = seg[node * 2 + 1] + seg[node * 2 + 2];
	
}

long long retSum(int left, int right, int node, int nodeL, int nodeR) {
	retUpdate(node, nodeL, nodeR);
	if (right < nodeL || nodeR < left)
		return 0;
	if (left <= nodeL && nodeR <= right)
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
		int a, b, c, d;
		cin >> a;
		if (a == 1) {
			cin >> b >> c >> d;
			update(b - 1, c - 1, d, 0, 0, N - 1);
		}
		else {
			cin >> b >> c;
			cout << retSum(b - 1, c - 1, 0, 0, N - 1) << '\n';
		}
		
	}
}