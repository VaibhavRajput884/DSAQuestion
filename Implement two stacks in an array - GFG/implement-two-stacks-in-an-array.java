//{ Driver Code Starts
import java.util.*;

class TwoStack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		while(T>0)
		{
			twoStacks g = new twoStacks();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int stack_no = sc.nextInt();
				int QueryType = sc.nextInt();
				
				
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					if(stack_no == 1)
					 g.push1(a);
					else if(stack_no ==2)
					 g.push2(a);
				}else if(QueryType == 2)
				{
					if(stack_no==1)
					System.out.print(g.pop1()+" ");
					else if(stack_no==2)
					System.out.print(g.pop2()+" ");
				}
			
				Q--;
			}
				System.out.println();
		  T--;
		}
	}
}


// } Driver Code Ends



class twoStacks
{
    
    ArrayList<Integer> s1;
    ArrayList<Integer> s2;

    public twoStacks() {
        s1 = new ArrayList<>();
        s2 = new ArrayList<>();
    }

    // Function to push an integer into stack1.
    void push1(int x) {
        s1.add(x);
    }

    // Function to push an integer into stack2.
    void push2(int x) {
        s2.add(x);
    }

    // Function to remove an element from the top of stack1.
    int pop1() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.remove(s1.size() - 1);
    }

    // Function to remove an element from the top of stack2.
    int pop2() {
        if (s2.isEmpty()) {
            return -1;
        }
        return s2.remove(s2.size() - 1);
    }
}

 