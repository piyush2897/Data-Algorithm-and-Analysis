#include<stdio.h>
#include<limits.h>
typedef struct activity{
    int start;
    int end;
}activity;
int select(activity arr[],int s,int n)
{
    int i,c=0,end=INT_MIN,k=0;
    arr[0].start=-1;
    arr[0].end=-1;
    if(s>n)
    return 0;
    for(i=s;i<=n;i++)
    {
       if(arr[i].start >= arr[k].end)
       {
            c++;
            k=i;
       }
    }
    return c;
}
int main()
{
    int n,i,j,a,b,q,temp;
    activity arr[1000];
    printf("Enter The number of Activities\n");
    scanf("%d",&n);
    printf("Enter The Start and End Time of Activity\n");
    for(i=1;i<=n;i++)
    {
        scanf("%d",&a);
        scanf("%d",&b);
        arr[i].start=a;
        arr[i].end=b;
    }
    for(i=1;i<=n;i++)
    {
        for(j=i+1;j<=n;j++)
        {
            if(arr[i].end > arr[j].end)
            {
                temp=arr[i].end;
                arr[i].end=arr[j].end;
                arr[j].end=temp;


                temp=arr[i].start;
                arr[i].start=arr[j].start;
                arr[j].start=temp;
            }
        }
    }
    q=select(arr,1,n);
    printf("%d",q);
    return 0;
}

