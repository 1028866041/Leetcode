#include<iostream>
#include<stdexcept>
#include<string>
#include<cstdlib>
#include<cstdio>
#include<complex>
#include<ctime>
#include<list>
#include<set>
#include<algorithm>
#include<ext\array_allocator.h>
#include<ext\mt_allocator.h>
#include<ext\debug_allocator.h>
#include<ext\pool_allocator.h>
#include<ext\bitmap_allocator.h>
#include<ext\malloc_allocator.h>
#include<ext\new_allocator.h>
using namespace std;
using namespace std;

void overload_operator();
int alloc(){
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
    /*FILE* f[60];
    char buffer[20];
    for(int i=0;i<60;i++)
    {
        f[i]= fopen(_itoa(i, buffer,10), "wb");
        cout<<f[i]->_file<<endl;
    }*/
    remove("mem.dat");
    return 0;
}

int mem()
{
    list<string, allocator<string>> c;
    list<string, __gnu_cxx::malloc_allocator<string>> c2;
    list<string, __gnu_cxx::new_allocator<string>> c3;
    list<string, __gnu_cxx::__pool_alloc<string>> c4;
    list<string, __gnu_cxx::__mt_alloc<string>> c5;
    list<string, __gnu_cxx::bitmap_allocator<string>> c6;
    int ch;
    long value;
	cout<< "select: "<<endl
		<< "(1) std::allocator"
	    << "(2) malloc_allocator"
	    << "(3) new_allocator"
	    << "(4) __pool_alloc"
	    << "(5) __mt_alloc"
		<< "(6) bitmap_allocator";
    cin>>ch;
    if(ch!=0){
        cout<<"number:";
        cin>>value;
    }
    char buf[10];
    clock_t time=clock();
    for(int i=0;i<value;i++){
        try{
            snprintf(buf,10,"%d",i);
            switch(ch){
                case 1:
                    c.push_back(string(buf));
                    break;
                case 2:
                    c2.push_back(string(buf));
                    break;
                case 3:
                    c3.push_back(string(buf));
                    break;
                case 4:
                    c4.push_back(string(buf));
                    break;
                case 5:
                    c5.push_back(string(buf));
                    break;
                case 6:
                    c6.push_back(string(buf));
                    break;
                default:
                    break;
            }
        }catch(exception& e){
            cout<<i<<" "<<e.what()<<endl;
            abort();
        }
        cout<<"push_back time:"<<(clock()-time)<<endl;
        int* p;
        allocator<int> a;
        p= a.allocate(1);
        a.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a2;
        p= a2.allocate(1);
        a2.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a3;
        p= a3.allocate(1);
        a3.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a4;
        p= a4.allocate(1);
        a4.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a5;
        p= a5.allocate(1);
        a5.deallocate(p,1);
        __gnu_cxx::malloc_allocator<int> a6;
        p= a6.allocate(1);
        a6.deallocate(p,1);
    }
    return 0;
}

int rb_trees()
{
    _Rb_tree<int,int,_Identity<int>,less<int>> itree;
    itree._M_insert_unique(1);
    itree._M_insert_unique(2);
    itree._M_insert_unique(3);
    itree._M_insert_unique(4);
    itree._M_insert_unique(5);
    cout<<itree.empty()<<endl;
    cout<<itree.size()<<" "<<itree.count(2)<<endl;
    itree._M_insert_equal(2);
    itree._M_insert_equal(2);
    cout<<itree.size()<<" "<<itree.count(2)<<endl;
    return 0;
}
