#include<stdio.h>
int partition(int arr[],int s,int e)
{
    int i=s-1;
    int k,t;
    int pivot= arr[e];

    for(k=s;k<=e;k++)
    {
        if(arr[k] < pivot)
        {
            i++;
            t=arr[i];
            arr[i]=arr[k];
            arr[k]=t;
        }
    }
    i++;
    t=arr[i];
    arr[i]=arr[e];
    arr[e]=t;
    return i;
}
void quickSort(int arr[],int s,int e)
{
    if(s>=e)
        return ;

    int point = partition(arr,s,e);
    quickSort(arr,s,point-1);
    quickSort(arr,point+1,e);

    return ;
}
int main()
{
    int n,i,j;
    printf("Enter the Length Of Array\n");
    scanf("%d",&n);
    printf("Enter The Array\n");
    int arr[1000];
    for(i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    quickSort(arr,0,n-1);
    printf("Sorted Array is\n");
    for(i=0;i<n;i++)
    {
        printf("%d ",arr[i]);
    }
}
