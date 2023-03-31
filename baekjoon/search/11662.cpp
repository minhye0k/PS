#include <iostream>
#include <cmath>
#define fastio cin.tie(0)->sync_with_stdio(0)

using namespace std;

int a[2], b[2], c[2], d[2];

typedef pair<double, double> POINT;

POINT minho(double p){
    return make_pair(a[0] + (b[0] - a[0]) * (p/100), a[1] + (b[1] - a[1]) * (p/100));
}

POINT gangho(double p){
    return make_pair(c[0] + (d[0] - c[0]) * (p/100), c[1] + (d[1] - c[1]) * (p/100));
}

int main(void) {
    fastio;

    cin >> a[0] >> a[1] >> b[0] >> b[1] >> c[0] >> c[1] >> d[0] >> d[1];

    double lo = 0, hi = 100, p, q, ans = 14150;

    while(hi - lo >= 1e-6) {
        p = (2 * lo+hi) / 3;
        q = (lo + 2*hi) / 3;

        POINT minho_p = minho(p);
        POINT minho_q = minho(q);
        
        POINT gangho_p = gangho(p);
        POINT gangho_q = gangho(q);

        double pDistance = sqrt(pow(minho_p.first - gangho_p.first, 2) + pow(minho_p.second - gangho_p.second, 2));
        double qDistance = sqrt(pow(minho_q.first - gangho_q.first, 2) + pow(minho_q.second - gangho_q.second, 2));
        
        ans = min(ans, min(pDistance, qDistance));

        if(pDistance > qDistance){
            lo = p;
        }else{
            hi = q;
        }
    }

    cout.precision(10);

    cout << ans << '\n';

}
