#include<stdio.h>
#include<limits.h>

typedef struct node{
    int start;
    int end;
    int total;
}node;

typedef struct node2{
    int value;
    int point;
}node2;

node maxArray(int arr[],int start, int end)
{
    int i=end,j=0,val1=INT_MIN,val2=0;
    node2 hold_max[1000];
    hold_max[0].value=INT_MIN;
    node point;
    for(i=end;i>=start;i--)
    {
        if(arr[i]>val1)
        {
            hold_max[j].value=arr[i];
            hold_max[j].point=i;
            val1=arr[i];
            val2=i;
        }
        else
        {
             hold_max[j].value=val1;
             hold_max[j].point=val2;
        }
        j++;
    }
    val1=0;
    for(i=start;i<=end;i++)
    {
        printf("%d ",hold_max[i].value);
        if(hold_max[end-i].value - arr[i] > val1)
        {
            point.start=i;
            point.end=hold_max[end-i].point;
            point.total=hold_max[end-i].value - arr[i];
            val1=hold_max[end-i].value - arr[i];
        }
    }
    printf("\n");
    return point;
}
int main()
{
    int n,arr[1000],i,val;
    printf("Enter The Size Of Array\n");
    scanf("%d",&n);
    printf("Enter The Array\n");
    for(i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }

    node  res = maxArray(arr,0,n-1);
    for(i=res.start;i<=res.end;i++)
        val=val+arr[i];
    printf("Starting Point =%d \n",res.start);
    printf("Ending Point =%d \n",res.end);
    printf("Total Prifit =%d \n",res.total);
     printf("Total Sum =%d \n",val);
    return 0;
}
