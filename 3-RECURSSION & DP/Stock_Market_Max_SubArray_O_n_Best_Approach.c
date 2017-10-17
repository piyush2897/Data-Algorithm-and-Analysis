#include<stdio.h>
#include<limits.h>

typedef struct node{
    int start;
    int end;
    int total;
}node;

node maxArray(int arr[], int start, int end)
{
    int i=start,k=start;
    int cs=0,ms=INT_MIN;
    node point;
    point.start=start;
    point.end=start;
    point.total=arr[start];
    ms=arr[start];
    for(i=start;i<=end;i++)
    {
        cs=cs+arr[i];
        if(cs>=ms)
        {
            ms=cs;
            point.total=cs;
            point.start=i-k;
            point.end=i;
        }
        k++;
        if(cs<0)
        {
            cs=0;
            k=0;
        }
    }
    return point;
}

int main()
{
    int n,arr[1000],i;
    printf("Enter The Size Of Array\n");
    scanf("%d",&n);
    printf("Enter The Array\n");
    for(i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }
    node  res = maxArray(arr,0,n-1);

    printf("Starting Point =%d \n",res.start);
    printf("Ending Point =%d \n",res.end);
    printf("Total Sum =%d \n",res.total);

    return 0;
}
