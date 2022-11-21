class FIRST
{
    public static void main(String args[])
    {
        int blockSize[]={200,300,100,400,500};
        int processSize[]={21,45,36,78};
        int m=blockSize.length;
        int n=processSize.length;

        firstFit(blockSize,m,processSize,n);
    }
    static void firstFit(int blockSize[], int m, int processSize[],int n)
    {
        int allocation[]=new int[n];
        int occupied[]=new int[m];
        for(int i=0;i<allocation.length;i++)
            allocation[i]=-1;

        for(int i=0;i<m;i++){
            occupied[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if((occupied[i]<=0) && blockSize[j]>=processSize[i])
                {
                    allocation[i]=j;
                    occupied[j]=1;
                    break;
                }
            }
        }
        System.out.println("\nProcess no.\tprocess size\tBlock no\n");
        for(int i=0;i<n;i++)
        {
            System.out.println(i + 1 + "\t\t\t" + processSize[i] + "\t\t\t");
            if(allocation[i]!=-1)
                System.out.println(allocation[i]+1);
            else
                System.out.println("NOT ALLOCATED");
        }
    }
}