#include<iostream>
#include<vector>
#include<queue>
#include<functional>
#define INF 987654321
using namespace std;

int n, m, dep, des;
vector<pair<int, int>> e[1001];
int trace[1001];


vector<int> dijkstra() {
	vector<int> dist(n, INF);
	dist[dep] = 0;
	//최솟값이 root인 priority queue <가중치, 현재vertex>
	priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, dep });

	while (!pq.empty()) {
		int cost = pq.top().first;
		int cur = pq.top().second;
		pq.pop();
		if (dist[cur] < cost)
			continue;
		for (int i = 0; i < e[cur].size(); ++i) {
			int neighbor = e[cur][i].first;
			int neicost = cost + e[cur][i].second;

			if (dist[neighbor] > neicost) {
				dist[neighbor] = neicost;
				trace[neighbor] = cur;
				pq.push({ neicost, neighbor });
			}
		}

	}
	return dist;

}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int a, b, c;
	cin >> n >> m;
	++n;
	for (int i = 0; i < m; ++i) {
		cin >> a >> b >> c;
		e[a].push_back({ b, c });
	}
	cin >> dep >> des;
	vector<int> result = dijkstra();
	cout << result[des] << '\n';
	vector<int> route;
	int node = des;
	while (node) {
		route.push_back(node);
		node = trace[node];
	}
	cout << route.size() << '\n';
	for (int i = route.size() - 1; i >= 0; --i)
		cout << route[i] << " ";
}