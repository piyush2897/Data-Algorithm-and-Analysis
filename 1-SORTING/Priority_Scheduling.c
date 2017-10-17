#include<stdio.h>
void swap(int arr[],int a,int b)
{
    int t;
    t=arr[a];
    arr[a]=arr[b];
    arr[b]=t;
}
int find_max(int arr[],int s,int e)
{
    int k=(s+e)/2;
    int i,max=0;
    for(i=e;i>=s;i--)
    {
        max=0;
        if(2*i <= e && arr[2*i]>arr[i])
        max=2*i;
        if(2*i +1 <= e && arr[2*i+1]>arr[i])
        max=2*i+1;
        if(max!=0)
        swap(arr,i,max);
    }
    return arr[s];
}
/*void heapSort(int arr[],int s,int e, int n)
{
    if(s>=e)
        return ;
    int t;
    max_heap(arr,s,e,n);
    swap(arr,1,e);
    heapSort(arr,s,e-1,n);
}*/
void Percolate_up(int arr[],int i)
{
    if(i<=1)
        return ;
    int max=0;
       if(arr[i/2]<arr[i])
       {
            swap(arr,i,i/2);
            Percolate_up(arr,i/2);
       }
    return ;
}
void heapify(int arr[],int s,int n)
{
    if(s>=n)
        return ;
    int max=0;
    if(2*s<=n && arr[2*s]>arr[s])
        max=2*s;
    if(2*s+1<=n && arr[2*s+1]>arr[s])
        max=2*s+1;
    if(max!=0)
        heapify(arr,max,n);
}
int main()
{
    int n,i,j,c,k1,k2;
    printf("Enter the Number of Processes\n");
    scanf("%d",&n);
    printf("Enter The Priority Of the Processes\n");
    int arr[1000]={0};
    for(i=1;i<=n;i++)
    {
        scanf("%d",&arr[i]);
    }
    //heapSort(arr,1,n,n);
    printf("Enter Your Choice\n0 for Exit \n1 for Printing\n2 for finding Max\n3 for Removing the max Element\n4 for Increasing Priority\n5 for Inserting New Job\n");
    scanf("%d",&c);
    while(c!=0)
    {
        switch(c)
        {
        case 1:
            printf("Priority of Processes are\n");
            for(i=1;i<=n;i++)
            {
                printf("%d ",arr[i]);
            }
            printf("\n");
            break;
        case 2:
            printf("Maximum Element Is\n");
            int t=find_max(arr,1,n);
            printf("%d \n",t);
            break;
        case 3:
            printf("Element Has Been removed\n");
            t=find_max(arr,1,n);
            swap(arr,1,n);
            n--;
            heapify(arr,1,n);
            break;
        case 4:
            printf("Enter Index and Increment of Process\n");
            scanf("%d%d",&k1,&k2);
            arr[k1]=arr[k1]+k2;
            Percolate_up(arr,k1);
            break;
        case 5:
            printf("Enter The Value to be inserted\n");
            scanf("%d",&k1);
            n++;
            arr[n]=k1;
            Percolate_up(arr,n);
            break;
        default:
            printf("Exit\n");
            break;
        }
        printf("Enter Choice\n");
        scanf("%d",&c);
    }
    return 0;
}

