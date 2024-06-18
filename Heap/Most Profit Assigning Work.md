# Most Profit Assigning Work
You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:

difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
Return the maximum profit we can achieve after assigning the workers to the jobs.

 

Example 1:

Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100
Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get a profit of [20,20,30,30] separately.

**C++**

```C++

class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        int ans = 0;
        int n = worker.size();
        priority_queue<pair<int,int>> pq;
        int i = 0;
        for(int j = 0; j < difficulty.size(); j++){
            pq.push({profit[j],difficulty[j]});
        }
        sort(begin(worker), end(worker), greater<int>());
        while(i < n && !pq.empty()){
            if(worker[i] < pq.top().second){
                pq.pop();
            }else{
                ans += pq.top().first;
                i++;
            }
        }
        return ans;
    }
};

```

**Java**


```Java

import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        int n = worker.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int j = 0; j < difficulty.length; j++) {
            pq.offer(new int[]{profit[j], difficulty[j]});
        }
        
        Arrays.sort(worker);
        int i = n - 1;
        
        while (i >= 0 && !pq.isEmpty()) {
            if (worker[i] < pq.peek()[1]) {
                pq.poll();
            } else {
                ans += pq.peek()[0];
                i--;
            }
        }
        
        return ans;
    }
}

```