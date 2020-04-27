#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<pair<int, int>> beacon;
int DP[100001];	//�ش� ��ȣ���� ������ �� activate�Ǵ� beacon ����
int maxActivated = 1;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	beacon.push_back({ -1000001, 0 });
	for (int i = 1; i <= n; ++i) {
		int a, b;
		cin >> a >> b;
		beacon.push_back({ a, b });
	}
	sort(beacon.begin(), beacon.end());

	DP[0] = 0;
	DP[1] = 1;
	
	for (int i = 2; i <= n; ++i) {
		int temp = i;
		while (beacon[temp].first >= beacon[i].first - beacon[i].second)
			--temp;
		DP[i] = DP[temp] + 1;
		maxActivated = DP[i] >= maxActivated ? DP[i] : maxActivated;
	}
	
	cout << n - maxActivated << '\n';
}