/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
       
        int celebrity = 0 ;
        
        for (int i = 1; i < n; i++)
        {
            if (!Runner.knows(i, celebrity)){
                celebrity = i ;
            }
        }
        
        int knowHim = 0 ;
        int heKnows = 0 ;
        for (int i = 0 ; i < n; i++)
        {
            if (Runner.knows(i, celebrity)) knowHim++ ;
            if (Runner.knows(celebrity, i)) heKnows++ ;
        }
        
        if (knowHim == n-1 && heKnows == 0) return celebrity ;
        return -1 ;
        
    }
}
