import java.util.*;
class schedule
{
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[])
    {
        int choice=0;
        do
        {
            System.out.println("1.Priority");
            System.out.println("2.FCFS");
            System.out.println("3.EXIT");
            System.out.println("please enter your choice:");
            choice=sc.nextInt();

            switch(choice)
            {
                case 1:
                priority();
                break;
 
                case 2:
                fcfs();
                break;
         
            }
        }while(choice!=3);
    }
    static void priority()
    {
        Scanner s=new Scanner(System.in);
        int x,n,i,p[],pp[],bt[],w[],t[],awt,atat;
        p=new int[10];
        pp=new int[10];
        bt=new int[10];
        w=new int[10];
        t=new int[10];
        
        System.out.print("Enter the number of process:");
        n=s.nextInt();

        for(i=0;i<n;i++)
        {
            System.out.print("\nProcess["+(i+1)+"]:");
            System.out.print("\t Enter Burst time:");
            bt[i]=s.nextInt();
            System.out.print("\t Time priorities:");
            pp[i]=s.nextInt();
            p[i]=i+1;
        }

        for(i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(pp[i]>pp[j])
                {
                    x=pp[i];
                    pp[i]=pp[j];
                    pp[j]=x;
                    x=bt[i];
                    bt[i]=bt[j];
                    bt[j]=x;
                    x=p[i];
                    p[i]=p[j];
                    p[j]=x;
                }
            }
        }
        w[0]=0;
        awt=0;
        t[0]=bt[0];
        atat=t[0];
        
        for(i=1;i<n;i++)
        {
            w[i]=t[i-1];
            awt+=w[i];
            t[i]=w[i]+bt[i];
            atat+=t[i];
        }
        System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
        for(i=0;i<n;i++)
        System.out.print("\n   "+p[i]+"\t\t   "+bt[i]+"\t\t     "+w[i]+"\t\t     "+t[i]+"\t\t     "+pp[i]+"\n");
        awt/=n;
        atat/=n;
        System.out.print("\n Average Wait Time : "+awt);
        System.out.print("\n Average Turn Around Time : "+atat);
    }
    

    static void fcfs()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter no of process:");
        int n=sc.nextInt();
        int pid[]=new int[n];
        int bt[]=new int[n];
        int wt[]=new int[n];
        int ta[]=new int[n];
        int ct[]=new int[n];
        int ar[]=new int[n];
  
        int temp;
        float avgwt=0,avgta=0;

        for(int i=0;i<n;i++)
        {
            System.out.println("enter process"+(i+1)+"Arrival time:");
            ar[i]=sc.nextInt();
            System.out.println("enter process"+(i+1)+"Burst time:");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-(i+1);j++)
            {
                if(ar[j]>ar[j+1])
                {
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;
                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                ct[i]=ar[i]+bt[i];
            }
            else
            {
                if(ar[i]>ct[i-1])
                {
                    ct[i]=ar[i]+bt[i];
                }
                else
                    ct[i]=ct[i-1]+bt[i];
            }
            ta[i]=ct[i]-ar[i];
        	 wt[i]=ta[i]-bt[i];
        	 avgwt+=wt[i];
        	 avgta+=ta[i];
        }
        System.out.println("\n pid \tArrival time \tBurst time \tComplete time \tTurnAround time \tWaiting time ");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"\t\t  "+ar[i]+"\t\t  "+bt[i]+"\t\t  "+ct[i]+"\t\t  "+ta[i]+"\t\t  "+wt[i]+"\n");
        }
        System.out.println("Average waiting time:"+(avgwt/n));
        System.out.println("Average TurnAround time:"+(avgta/n));
    }
    }