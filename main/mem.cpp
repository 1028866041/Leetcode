#include<iostream>
#include<complex>
#include<cstdio>
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

int file_handle()
{
    cout<<stdin<<" "<<stdout<<" "<<stderr<<endl;
    cout<<stdin->_file<<" "<<stdout->_file<<" "<<stderr->_file<<endl;

    FILE* fp= fopen("mem.dat", "wb");
    if(fp== NULL)
        return -1;
    cout<<fp<<" "<<fp->_file<<endl;
    fwrite("abcde", 5,1,fp);
    fclose(fp);
    cout<<fp<<" "<<fp->_file<<endl;
    fp= fopen("mem.dat", "wb");
    if(fp== NULL)
        return -1;
    cout<<fp<<" "<<fp->_file<<endl;
    fwrite("fghij", 5,1,fp);
    fclose(fp);
    cout<<fp<<" "<<fp->_file<<endl;
    FILE* f[60];
    char buffer[20];
    /*for(int i=0;i<60;i++)
    {
        f[i]= fopen(_itoa(i, buffer,10), "wb");
        cout<<f[i]->_file<<endl;
    }*/
    remove("mem.dat");
    return 0;
}
