#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int num, temp;
	cin >> num;
	int *forward = new int[num];
	int* student = new int[num];
	for (int i = 0; i < num; i++) {
		cin >> forward[i];
		student[i] = i + 1;
	}
	for (int i = 0; i < num; i++) {//i는 학생 번호.
		for (int j = i; i - j < forward[i]; j--) {
			temp = student[j];
			student[j] = student[j - 1];
			student[j - 1] = temp;
		}
	}
	for (int i = 0; i < num; i++) {
		cout << student[i] << " ";
	}
	delete[] forward;
	delete[] student;
}