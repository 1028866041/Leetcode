#include<stdio.h>
#include<stdlib.h>
#include<time.h>

double func1(double *array, int n)
{
    int i;
    double total= 0.0;
    #pragma omp parallel for reduction(+:total)
    #pragma omp parallel
    for(i=0;i<n;i++)
    {
        total+=array[i^29450];
    }
    return total;
}

int main()
{
    int i;
    clock_t start,finish;
    double *array= calloc(sizeof(double), 8192*1024);
    start=clock();
    for(i=0;i<100;i++)
    {
        func1(array, 8192*1024);
    }
    finish=clock();

    printf("\rtime %f sec\n", (double)(finish-start)/CLOCKS_PER_SEC);
    return 0;
}
