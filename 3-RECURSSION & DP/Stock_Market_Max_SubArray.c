#include<stdio.h>
#include<limits.h>
typedef struct node{
    int start;
    int end;
    int total;
}node;
int max(int a,int b,int c)
{
    if(a>b && a>c)
    return a;
    else if(b>c && b>a)
    return b;
    else
    return c;
}
node crossArray(int arr[],int start,int mid ,int end)
{
    node option1;
    option1.start=-1;
    option1.end=-1;
    option1.total=-1;
    int cs1=INT_MIN,ms1=INT_MIN,cs2=INT_MIN,ms2=INT_MIN,total=INT_MIN,i;
    if(start>end || start>mid)
    return option1 ;
    option1.start=mid;
    option1.end=mid;
    for(i=mid;i>=start;i--)
    {
        if(cs1==INT_MIN)
        {
            cs1=arr[i];
            option1.start=i;
        }
        else
        cs1+=arr[i];
        if(cs1>ms1)
        {
            ms1=cs1;
            option1.start=i;
        }
    }
    for(i=mid+1;i<=end;i++)
    {
        if(cs2==INT_MIN)
        {
            cs2=arr[i];
            option1.end=i;
        }
        else
        cs2+=arr[i];
        if(cs2>ms2)
        {
            ms2=cs2;
            option1.end=i;
        }
    }
    if(ms1!=INT_MIN && ms2!=INT_MIN)
        option1.total = ms1+ms2;
    else if(ms1!=INT_MIN )
        option1.total = ms1;
    else
        option1.total = ms2;
    return option1;
}
node maxArray(int arr[],int start,int end)
{
    node option1,option2,option3;
    option1.start=-1;
    option1.end=-1;
    option1.total=INT_MIN;
    if(start>end)
        return option1;
    if(start==end)
    {
        option1.start=start;
        option1.end=start;
        option1.total=arr[start];
        return option1;
    }
    int mid = (start+end)/2;
    option1 = maxArray(arr,start,mid);
    option2 = maxArray(arr,mid+1,end);
    option3 = crossArray(arr,start,mid,end);

    int k =  max(option1.total,option2.total,option3.total);
    if(option1.total == k)
        return option1;
    else if(option2.total == k)
        return option2;
    else
        return option3;
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
