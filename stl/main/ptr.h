#include <mem.h>
#include <iostream>
using namespace std;

template <class T>
ostream& operator<<(ostream& strm,const auto_ptr<T>& p)
{
    if(p.get()==NULL){
        strm<< "nullptr";
    }else{
        strm<<*p;
    }
    return strm;
}
