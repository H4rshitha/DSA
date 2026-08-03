class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        while(l<=r){
            long totalTime = 0 ;
            int k = (l+r)/2;
            for(int i : piles){
                totalTime += Math.ceil((double)i/k);
            }
            if(totalTime<=h){
                res = k;
                r = k-1;
            }
            else{
                l = k+1;
            }
        }
        return res;
    }
}