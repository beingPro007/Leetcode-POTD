# Patching Array
The minimum patches algorithm is designed to determine the minimum number of patches (additional numbers) required to make the range [1, n] inclusive using elements from a given array or list. This document provides implementations of the algorithm in both C++ and Java.

**C++**

```C++

class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        long maxReach = 0;
        int patch = 0;
        int i = 0;
        while(maxReach < n){
            if(i < nums.size() && nums[i] <= maxReach + 1){
                maxReach += nums[i];
                i++;
            }else{
                maxReach += maxReach + 1;
                patch++;
            }
        }
        return patch;
    }
};

```
**Java**
```Java
public class Solution {
    public int minPatches(List<Integer> nums, int n) {
        long maxReach = 0;
        int patch = 0;
        int i = 0;
        
        while (maxReach < n) {
            if (i < nums.size() && nums.get(i) <= maxReach + 1) {
                maxReach += nums.get(i);
                i++;
            } else {
                maxReach += maxReach + 1;
                patch++;
            }
        }
        
        return patch;
    }
}
```
	