class Solution {
    int t[][] = new int[101][101];
    public int countSteps(int ringIdx , int kidx , int length){
        int antiClock = Math.abs(ringIdx-kidx);
        int clock = Math.abs(length - antiClock);
        return Math.min(antiClock , clock);
    }
    public int solve(int ringIdx,int kidx ,String ring ,String key){
        
        if(kidx == key.length()){
            return 0;
        }

        int result = Integer.MAX_VALUE;
        
        if(t[ringIdx][kidx] != -1){
            return t[ringIdx][kidx];
        }

        for(int i = 0;i< ring.length(); i++){
            if(ring.charAt(i) == key.charAt(kidx)){
                int steps = countSteps(ringIdx,i,ring.length()) + 1 + solve(i,kidx+1,ring,key);
                result = Math.min(result,steps);
            }
        }
        return t[ringIdx][kidx] = result;
    }
    public int findRotateSteps(String ring, String key) {
        for(int i =0;i<101;i++){
            for(int j =0;j<101;j++){
                t[i][j] = -1;
            }
        }
        return solve(0,0,ring,key);
    }
}