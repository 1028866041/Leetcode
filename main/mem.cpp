#include<iostream>
#include<complex>
using namespace std;

void overload_operator();
int mem(){
    void* p=malloc(2);
    free(p);
    complex<int>* p2=new complex<int>;
    delete p2;
    void* p3=::operator new(2);
    ::operator delete(p3);
    int *p4= allocator<int>().allocate(5);
    allocator<int>().deallocate(p4,5);
    overload_operator();
    return 0;
}

class Mem
{
public:
    int id;
    long data;
    string str;
public:
    static void* operator new(size_t size);
    static void operator delete(void* object,size_t size);
    static void* operator new[](size_t size);
    static void operator delete[](void* object,size_t size);
    Mem(): id(0){cout<<"default ctor. this="<<this<<" id="<<id<<endl;}
    Mem(int i): id(i){cout<<"ctor. this="<<this<<" id="<<id<<endl;}
    ~Mem(){cout<<"dtor. this="<<this<<" id="<<id<<endl;}
};
void* Mem::operator new(size_t size)
{
    Mem* p=(Mem *)malloc(size);
    cout<<"operator new(),size="<<size<<" return "<<p<<endl;
    return p;
}
void Mem::operator delete(void* phead,size_t size)
{
    cout<<"operator delete(),phead="<<phead<<" size="<<size<<endl;
    free(phead);
}
void* Mem::operator new[](size_t size)
{
    Mem* p=(Mem *)malloc(size);
    cout<<"operator new(),size="<<size<<" return "<<p<<endl;
    return p;
}
void Mem::operator delete[](void* phead,size_t size)
{
    cout<<"operator delete[](),phead="<<phead<<" size="<<size<<endl;
    free(phead);
}
void overload_operator()
{
    cout<<"overload_operator sizeof "<<sizeof(Mem)<<endl;
    {
        Mem* p= new Mem(2);
        delete p;
        //Mem* arry= new Mem[3];
        //delete[] arry;
    }
    cout<<"overload_operator sizeof "<<sizeof(Mem)<<endl;
    {
        Mem* p= ::new Mem(2);
        ::delete p;
        //Mem* arry= ::new Mem(3);
        //::delete[] arry;
    }
}
