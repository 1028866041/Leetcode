#include<boost/timer.hpp>
#include<boost/progress.hpp>
#include<boost/date_time/gregorian/gregorian.hpp>
#include<iostream>
#include<fstream>
#include<vector>

using namespace boost;
using namespace boost::gregorian;
using namespace std;

int time()
{
    timer t;
    progress_timer pt;

    cout << "max timespan :" << t.elapsed_max() << endl;
    cout << "min timespan :" << t.elapsed_min() << endl;
    cout << "now time elapsed :" << t.elapsed() << "s" << endl;
    cout << "now time elapsed :" << pt.elapsed() << "s" << endl;
    vector<string> v(100);
    ofstream fs("./test.txt");
    progress_display pd(v.size());
    for (auto& x:v) {
       fs << x << endl;
       ++pd;
    }

    date d(2020,2,1);
    tm td= to_tm(d);
    d += days(10);
    cout << d.year()<<" "<<d.month()<<" "<<d.day()<<" "<< endl;
    cout << td.tm_mday<<" "<<td.tm_hour<<" "<<td.tm_min<<" "<< endl;
    date_period dp(d, days(2));
    dp.shift(days(3));

    // todo
    date_iterator d_iter(d);
    ++d_iter;
    cout<< dp<<" "<< *d_iter<< endl;
    return 0;
}