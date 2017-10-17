#include<stdio.h>
void swap(int arr[],int a,int b)
{
    int t;
    t=arr[a];
    arr[a]=arr[b];
    arr[b]=t;
}
void max_heap(int arr[],int s,int e,int n)
{
    int k=(s+e)/2;
    int i,max=0;
    for(i=e;i>=s;i--)
    {
        max=0;
        if(2*i <= e && arr[2*i]>arr[i])
        max=2*i;
        if(2*i +1 <= e &&arr[2*i+1]>arr[i])
        max=2*i+1;
        if(max!=0)
        swap(arr,i,max);
    }
    return ;
}
void heapSort(int arr[],int s,int e, int n)
{
    if(s>=e)
        return ;
    int t;
    max_heap(arr,s,e,n);
    swap(arr,1,e);
    heapSort(arr,s,e-1,n);
}
int main()
{
    int n,i,j;
    printf("Enter the Length Of Array\n");
    scanf("%d",&n);
    printf("Enter The Array\n");
    int arr[1000]={0};
    for(i=1;i<=n;i++)
    {
        scanf("%d",&arr[i]);
    }
    heapSort(arr,1,n,n);
    printf("Sorted Array is\n");
    for(i=1;i<=n;i++)
    {
        printf("%d ",arr[i]);
    }
    return 0;
}
