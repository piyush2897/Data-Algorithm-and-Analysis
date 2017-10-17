#include<stdio.h>
int max(int a,int b)
{
    if(a>b)
    return a;
    return b;
}
int LCS(char str1[],char str2[], int n, int m)
{
    if(m==0 || n==0)
        return 0;
    if(str1[n] == str2[m])
        return (1+LCS(str1,str2,n-1,m-1));
    else
        return max(LCS(str1,str2,n-1,m) , LCS(str1,str2,n,m-1));
}
int main()
{
    char str1[1000],str2[1000];
    int n,m;
    printf("Enter The length of 1st String\n");
    scanf("%d",&n);
    printf("Enter the first String\n");
    scanf("%s", str1);
    printf("Enter The length of 2nd String\n");
    scanf("%d",&m);
    printf("Enter the first String\n");
    scanf("%s", str2);
    int maximum=LCS(str1,str2,n,m);
    printf("Maximum Common Subsequence = %d",maximum);
}
