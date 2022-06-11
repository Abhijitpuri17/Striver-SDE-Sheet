import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> nums) {
        
        int n = nums.size() ;
        int i = n-2 ;
        
        while (i >=0 && nums.get(i) >= nums.get(i+1)) i-- ;
        
        if (i < 0) {
            reverse(nums, 0, n-1) ;
            return nums;
        }
        
        int j = n-1 ;
        
        while (nums.get(j) <= nums.get(i) && j > i) 
        {
            j-- ;
        }
        
        swap(nums, i, j) ;
        
        reverse(nums, i+1, n-1) ;
         
        return nums ;
    }
    
    
    static void swap(ArrayList<Integer> nums, int i, int j)
    {
        int temp = nums.get(i) ;
        nums.set(i, nums.get(j)) ;
        nums.set(j, temp) ;
    }
    
    static void reverse(ArrayList<Integer> nums, int s, int e)
    {
        while (s < e){
            swap(nums, s, e) ;
            s++ ;
            e-- ;
        }
    }
}
