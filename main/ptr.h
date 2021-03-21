#include<memory>
#include<iostream>
using namespace std;

template <class T>
ostream& operator<<(ostream& strm, auto_ptr<T>& p)
{
    if(p.get()==NULL){
        strm<< "nullptr";
    }else{
        strm<<*p;
    }
    return strm;
}
