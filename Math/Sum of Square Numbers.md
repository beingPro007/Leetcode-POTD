# Sum of Square Numbers
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5


****Approach OneTc:[sqrt(c*logc)]****


**C++**

```C++

class Solution {
public:
    bool judgeSquareSum(int c) {
        for(long a = 0; a*a <=c; a++){
            double b = sqrt(c - a*a);
            if(b == (int)b){
                return true;
            }
        }
        return false;
    }
};

```

**Java**


```Java

class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}

```

****Approach Two(Using Binary Search Algorithm (Tc:[sqrt(c)*logc]))****


**C++**

```C++

class Solution {
public:
    bool judgeSquareSum(int c) {
        for(long a = 0; a*a <= c; a++){
            int x = c - (int)a*a;
            int start = 0;
            int end = x;

            while(start <= end){
                long mid = start + (end - start) / 2;
                if(mid*mid == x){
                    return true;
                }else if(mid * mid < x){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            } 
        }
        return false;
    }
};
```

**Java**


```Java

class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int x = c - (int)(a * a);
            if (binarySearch(0, x, x)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int start, int end, int target) {
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;
            if (square == target) {
                return true;
            } else if (square < target) {
                start = (int)(mid + 1);
            } else {
                end = (int)(mid - 1);
            }
        }
        return false;
    }
}


```