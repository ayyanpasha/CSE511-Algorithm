#include<bits/stdc++.h>
#include<cmath>
using namespace std;

int main(){
    double r;
    double k;
    cin>>r>>k;

    if(ceil(k) == k) k++;
    else k = ceil(k);

    double y = r;
    if(floor(y) == y) y--;
    else y = floor(y);

    long long int count = 0;
    long long x = 0;
    for(;y>=0 && y>=k;y--){
        while(y*y + x*x < r*r) x++;
        count += 2*x-1;
    }
    for(;y>-r && y>=k;y--){
        while(y*y + x*x >= r*r) x--;
        count += 2*x+1;
    }
    cout<<count<<endl;
    return 0;
}