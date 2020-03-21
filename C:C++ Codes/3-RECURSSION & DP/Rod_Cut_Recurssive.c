#include<stdio.h>
#include<limits.h>
int rod_cut(int arr[],int n)
{
    if(n==0)
    return 0;
    int max=INT_MIN;
    int i,var;
    for(i=1;i<n;i++)
    {
        var= arr[i] + rod_cut(arr,n-i);
        if((max)<var)
            (max)=var;
    }
    if((max) < arr[n])
        (max)= arr[n];
    return  (max);
}
int main()
{
    int n,p[1000],i;
    printf("Enter The Length of Rod\n");
    scanf("%d",&n);
    printf("Enter The Cost array\n");
    for(i=1;i<=n;i++)
    {
        scanf("%d",&p[i]);
    }
    int max=rod_cut(p,n);
    printf("Maximum Cost Of Rod Cutting = %d ",max);
}
