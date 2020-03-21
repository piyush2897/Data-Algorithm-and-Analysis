#include<stdio.h>
#include<limits.h>
typedef struct activity{
    int start;
    int end;
}activity;
void select(activity arr[],int s,int n,int *k,int *c)
{
    int q=INT_MIN,p=0,i;
    if(s>n)
    return ;
    if(arr[s].start >= arr[(*k)].end)
       {
            (*c)++;
            (*k)=s;
       }
    select(arr,s+1,n,k,c);
    return ;
}
int main()
{
    
    int n,i,j,temp,a,b,q;
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
    int k=0,c=0;
    arr[0].start=-1;
    arr[0].end=-1;
    select(arr,1,n,&k,&c);
    printf("%d",c);
    return 0;
}
