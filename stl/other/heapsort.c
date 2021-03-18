#include<stdio.h>

#define LEN 10

void adjust(int array[], int i, int length)
{
    int j, k;
    
    for(k=array[i];2*i+1<length;i=j)
    {
        j=2*i+1;
        if(j!=length-1 && array[j+1]>array[j])
            j++;
        
        if(k<array[j])
        {
            array[i]= array[j]; //exchange
        }else{
            break;
        }      
    }
    array[i]= k;
}

void sort(int array[], int length)
{
    int i=0, tmp;

    for(i=length/2-1;i>=0;i--)
    {
        adjust(array, i, length);
    }

    for(i=length-1;i>=0;i--)
    {
        tmp=array[0];
        array[0]=array[i];
        array[i]=tmp;
        adjust(array, 0, i);    
    }
}

int main()
{
    int arr[LEN]={ 8, 4, 2, 3, 5, 1, 6, 9, 0, 7}, i=0;
    
    sort(arr,LEN);
    for(i=0;i<LEN;i++)
    {
        printf("%d ", arr[i]);
    }

    return 0;
}
