# Asteroid Collision
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

**C++**

```C++

class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> st;
        for (int &a : asteroids) {
            while (!st.empty() && a < 0 && st.top() > 0) {
                int sum = a + st.top();
                if (sum < 0) {
                    st.pop();
                } else if (sum > 0) {
                    a = 0;
                    break;
                } else {
                    st.pop();
                    a = 0;
                    break;
                }
            }
            if (a != 0) {
                st.push(a);
            }
        }
        vector<int> result(st.size());
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.top();
            st.pop();
        }
        return result;
    }
};

```

**Java**


```Java
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int sum = a + stack.peek();
                if (sum < 0) {
                    stack.pop();
                } else if (sum > 0) {
                    a = 0;
                    break;
                } else {
                    stack.pop();
                    a = 0;
                    break;
                }
            }
            if (a != 0) {
                stack.push(a);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

```