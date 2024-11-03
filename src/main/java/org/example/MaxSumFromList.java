package org.example;

public class MaxSumFromList {

    public int SticklerThief(int[] arr, int n){
        if(n==0){
            return 0;
        }
        int[] ans = new int[n+1];
        ans[1] = arr[0];
        ans[2] = Math.max(arr[1], arr[0]);
        for(int i=3; i<=n; i++){
            ans[i] = Math.max(ans[i-1], ans[i-2]+arr[i-1]);
        }
        return ans[n];
    }
}
