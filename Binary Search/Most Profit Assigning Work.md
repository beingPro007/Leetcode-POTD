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
        int n = difficulty.size();
        int m = worker.size();
        vector<pair<int,int>> vec;
        
        for(int i = 0; i < n; i++) {
            vec.push_back({difficulty[i], profit[i]});
        }
        
        sort(begin(vec), end(vec));
        
        for(int i = 1; i < vec.size(); i++) {
            vec[i].second = max(vec[i].second, vec[i - 1].second);
        }
        
        int totalProfit = 0;

        for(int i = 0; i < m; i++) {
            int workDiffLevel = worker[i];

            int l = 0;
            int r = vec.size() - 1;
            int maxProfit = 0;
            
            while(l <= r) {
                int mid = l + (r - l) / 2;
                if(vec[mid].first <= workDiffLevel) {
                    maxProfit = vec[mid].second;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            
            totalProfit += maxProfit;
        }
        
        return totalProfit;
    }
};


```

**Java**


```Java

import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        List<int[]> jobs = new ArrayList<>();

        // Pair the difficulty with profit
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{difficulty[i], profit[i]});
        }

        // Sort pairs based on difficulty
        Collections.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        // Adjust profits to ensure that for any difficulty, we have the maximum possible profit so far
        for (int i = 1; i < jobs.size(); i++) {
            jobs.get(i)[1] = Math.max(jobs.get(i)[1], jobs.get(i - 1)[1]);
        }

        int totalProfit = 0;

        // For each worker, find the maximum profit they can earn
        for (int i = 0; i < m; i++) {
            int workDiffLevel = worker[i];

            int l = 0;
            int r = jobs.size() - 1;
            int maxProfit = 0;

            // Binary search to find the maximum profit for the current worker
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (jobs.get(mid)[0] <= workDiffLevel) {
                    maxProfit = jobs.get(mid)[1];
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(solution.maxProfitAssignment(difficulty, profit, worker)); // Output: 100
    }
}


```