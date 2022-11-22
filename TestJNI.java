import java.util.Scanner;
public class TestJNI
{
    static
    {
        System.loadLibrary("cal");
    }
    private native int add(int n1,int n2);
    private native int sub(int n1,int n2);
    private native int mul(int n1,int n2);
    private native int division(int n1,int n2);
    public static void main(String args[])
    {
        int n1,n2;
        TestJNI obj=new TestJNI();
        int ch=1;
        Scanner sc=new Scanner(System.in);
        
        do
        {
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.println("please enter your choice:");
            ch=sc.nextInt();
            if(ch>=5)
            {
                System.out.println("ERROR!!!");
                System.out.println("please enter valid choice:");
                ch=sc.nextInt();
            }
            System.out.println("please enter the n1:");
            n1=sc.nextInt();
            System.out.println("please enter the n2:");
            n2=sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("Addition is:"+obj.add(n1,n2));
                break;

                case 2:
                System.out.println("Subtraction is:"+obj.sub(n1,n2));
                break;

                case 3:
                System.out.println("Multiplication is:"+obj.mul(n1,n2));
                break;

                case 4:
                System.out.println("Division is:"+obj.division(n1,n2));
                break;
            }
        }while(ch<5);
    }
}