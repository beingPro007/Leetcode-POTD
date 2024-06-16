# Sum of Subarray Minimum


Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

Example 1:

Input: arr = [3,1,2,4]
Output: 17
Explanation: 
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

**C++**

```C++

class Solution {
public:
    vector<int> getNsl(vector<int> &arr, int n){
        vector<int> result(n);
        stack<int> st;
        for(int i = 0; i < n; i++){
            if(st.empty()){
                result[i] = -1;
            }else{
                while(!st.empty() && arr[st.top()] >= arr[i]){
                    st.pop();
                }
                result[i] = (st.empty()) ? -1 : st.top();
            }
            st.push(i);
        }
        return result;
    }
    vector<int> getNsr(vector<int> &arr, int n){
        vector<int> result(n);
        stack<int> st;
        for(int i = n - 1; i >= 0; i--){
            if(st.empty()){
                result[i] = n;
            }else{
                while(!st.empty() && arr[i] < arr[st.top()]){
                    st.pop();
                }
                result[i] = (st.empty()) ? n : st.top();
            }
            st.push(i);
        }
        return result;
    }
    int sumSubarrayMins(vector<int>& arr) {
        int n = arr.size();
        vector<int> nsl = getNsl(arr,n);
        vector<int> nsr = getNsr(arr,n);

        long long sum = 0;
        int M = 1e9 + 7;
        
        for(int i = 0; i < n; i++){
            long long ls = i - nsl[i];
            long long rs = nsr[i] - i;
            long long totalWays = ls * rs;
            long long totalSum = totalWays * arr[i];
            sum = (sum + totalSum) % M; 
        }
        return sum;
    }
};

```

**Java**


```Java

class Solution {
    public int[] getNsl(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            result[i] = (st.empty()) ? -1 : st.peek();
            st.push(i);
        }
        return result;
    }

    public int[] getNsr(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            result[i] = (st.empty()) ? n : st.peek();
            st.push(i);
        }
        return result;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nsl = getNsl(arr, n);
        int[] nsr = getNsr(arr, n);

        long sum = 0;
        int M = 1000000007;

        for (int i = 0; i < n; i++) {
            long ls = i - nsl[i];
            long rs = nsr[i] - i;
            long totalWays = ls * rs;
            long totalSum = totalWays * arr[i];
            sum = (sum + totalSum) % M;
        }
        return (int) sum;
    }
}
```
