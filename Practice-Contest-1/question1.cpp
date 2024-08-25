#include<iostream>
using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        string n;
        int k;
        cin >> n >> k;
        int count = 0;
        for(int i=0;i<n.length();i++){
            if(n[i]-'0' == k) count++;
        }
        cout<<count<<endl;
    }
    return 0;
}
