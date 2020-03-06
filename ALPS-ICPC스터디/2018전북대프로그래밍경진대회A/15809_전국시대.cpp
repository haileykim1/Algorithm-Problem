#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;


int parent[100001];
int force[100001];

int getParent(int n) {
	if (parent[n] == n)
		return n;
	return parent[n] = getParent(parent[n]);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, M, input, O, P, Q;
	cin >> N >> M;
	parent[0] = 0;
	for (int i = 1; i <= N; ++i) {
		cin >> input;
		force[i] = input;
		parent[i] = i;
	}
	for (int i = 0; i < M; ++i) {
		cin >> O >> P >> Q;
		int p = getParent(P);
		int q = getParent(Q);
		if (O == 1) { //µ¿¸Í
			parent[q] = p;
			force[p] += force[q];
		}
		else { //ÀüÀï
			if (force[p] == force[q]) {
				force[p] = force[q] = 0;
				parent[p] = parent[q] = 0;
			}
			else if (force[p] > force[q]) {
				force[p] -= force[q];
				parent[q] = p;
			}
			else {
				force[q] -= force[p];
				parent[p] = q;
			}
		}
	}
	vector<int> leftpow;
	for (int i = 1; i <= N; ++i) {
		if (parent[i] == i)
			leftpow.push_back(force[i]);
	}
	sort(leftpow.begin(), leftpow.end());
	cout << leftpow.size() << '\n';
	for (int i = 0; i < leftpow.size(); ++i)
		cout << leftpow[i] << " ";
}