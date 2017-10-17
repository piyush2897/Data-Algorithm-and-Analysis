#include<stdio.h>
void merge(int arr[],int s,int mid, int e)
{
    int i,j,k=s;
    int l[mid-s+1];
    int r[e-mid];
    for(i=0;i<mid-s+1;i++)
        l[i]=arr[k++];
        k=mid+1;
    for(i=0;i<e-mid;i++)
        r[i]=arr[k++];
    i=s;j=0;k=0;
    while(j<mid-s+1 && k<e-mid)
    {
        if(l[j]<=r[k])
        {
            arr[i]=l[j];
            j++;
        }
        else
        {
            arr[i]=r[k];
            k++;
        }
        i++;
    }
    while(j<mid-s+1)
    {
        arr[i]=l[j];
            j++;
            i++;
    }
    while(k<e-mid)
    {
        arr[i]=l[k];
            k++;
            i++;
    }
    return ;
}
void mergeSort(int arr[],int s,int e)
{
    if(s>=e)
        return;

    int mid=(s+e)/2;
    mergeSort(arr,s,mid);
    mergeSort(arr,mid+1,e);
    merge(arr,s,mid,e);

    //return;
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
    mergeSort(arr,0,n-1);
    printf("Sorted Array is\n");
    for(i=0;i<n;i++)
    {
        printf("%d ",arr[i]);
    }
    return 0;
}
