/*

Smallest subarray with sum greater than x

Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.

Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).

*/

class Compute {

    public static long sb(long a[], long n, long x) {
        // Your code goes here 
        
        int left  = 0;
        long sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i = 0;i < a.length;i++){
            sum = sum + a[i];
            while(sum > x){
                minLength = Math.min(minLength,i - left + 1);
                //System.out.println(minLength + " " + left);
                sum = sum - a[left];
                left++;
            }
        }
        return minLength;
    }
}


