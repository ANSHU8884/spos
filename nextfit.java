import java.util.Arrays;
class NEXT
{
    public static void main(String args[])
    {
        int blockSize[]={20,40,60};
        int processSize[]={43,21,18};
        int m=blockSize.length;
        int n=processSize.length;

        nextFit(blockSize,m,processSize,n);
    }
    static void nextFit(int blockSize[],int m,int processSize[],int n)
    {
        int allocation[]=new int[n], j=0;
        Arrays.fill(allocation,-1);
        for(int i=0;i<n;i++)
        {
            int count=0;
            while(j<m)
            {
                count++;
                if(blockSize[j]>=processSize[i])
                {
                    allocation[i]=j;
                    blockSize[j] -=processSize[i];
                    break;
                }
                j=(j+1)%m;
            }
        }
        System.out.print("\nProcess No.\tProcess Size\tBlock no.\n");
		for (int i = 0; i < n; i++) 
               {
			    System.out.print( i + 1 + "\t\t" + processSize[i]+ "\t\t");
			    if (allocation[i] != -1) {
			        System.out.print(allocation[i] + 1);
			    } 
                    else
                    {
				   System.out.print("Not Allocated");
			    }
			    System.out.println("");
		    }
   
    }
}