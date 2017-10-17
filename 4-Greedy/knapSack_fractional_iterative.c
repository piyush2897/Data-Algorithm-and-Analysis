#include<stdio.h>
int main()
{
    int n,i,j;
    float W,temp;
    float price[1000],wt[1000];
    float ratio[1000];
    printf("Enter The number of Products\n");
    scanf("%d",&n);
    printf("Enter The price and weight of eah products\n");
    for(i=0;i<n;i++)
    {
        scanf("%f",&price[i]);
        scanf("%f",&wt[i]);
        ratio[i]=price[i]/wt[i];
    }
    printf("Enter The weight That theif can carry\n");
    scanf("%f",&W);
    for(i=0;i<n;i++)
    {
        for(j=i+1;j<n;j++)
        {
            if(ratio[i]<ratio[j])
            {
                temp=price[i];
                price[i]=price[j];
                price[j]=temp;

                temp=wt[i];
                wt[i]=wt[j];
                wt[j]=temp;

                temp=ratio[i];
                ratio[i]=ratio[j];
                ratio[j]=temp;
            }
        }
    }
    float p=0;
    i=0;
    while(W!=0)
    {
        if(wt[i] <= W)
        {
            p=p+price[i];
            W=W-wt[i];
        }
        else
        {
            p=p+(W/wt[i])*price[i];
            break;
        }
        i++;
    }
    for(i=0;i<n;i++)
    {
        printf("%f : %f : %f \n",price[i],wt[i],ratio[i]);
    }
    printf("Maximum Profit = %f ",p);
}
