# Minimum No. Days need to make m Bouqet
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

**C++**

```C++

class Solution {
public:
    int canMake(vector<int>& bloomDay, int mid, int k){
        int n = bloomDay.size();
        int bouqCount = 0;
        int consCount = 0;

        for(int i = 0; i < n; i++){
            if(bloomDay[i] <= mid){
                consCount++;
            }else{
                consCount = 0;
            }
            if(consCount == k){
                bouqCount++;
                consCount = 0;
            }
        }

        return bouqCount;
    }
    int minDays(vector<int>& bloomDay, int m, int k) {
        int start = 0;
        int n = bloomDay.size();
        int end = INT_MIN;
        for(int i = 0; i < n; i++){
            end = max(end,bloomDay[i]);
        }
        int minDays = -1;

        while(start <= end){
            int midDay = start + (end - start) / 2;

            if(canMake(bloomDay, midDay, k) >= m){
                minDays = midDay;
                end = midDay - 1;
            }else{
                start = midDay + 1; 
            }
        }
        return minDays;
    }
};

```

**Java**


```Java

import java.util.*;

class Solution {
    public int canMake(int[] bloomDay, int mid, int k) {
        int n = bloomDay.length;
        int bouqCount = 0;
        int consCount = 0;

        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= mid) {
                consCount++;
            } else {
                consCount = 0;
            }
            if (consCount == k) {
                bouqCount++;
                consCount = 0;
            }
        }

        return bouqCount;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int n = bloomDay.length;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            end = Math.max(end, bloomDay[i]);
        }

        int minDays = -1;

        while (start <= end) {
            int midDay = start + (end - start) / 2;

            if (canMake(bloomDay, midDay, k) >= m) {
                minDays = midDay;
                end = midDay - 1;
            } else {
                start = midDay + 1;
            }
        }

        return minDays;
    }
}

```