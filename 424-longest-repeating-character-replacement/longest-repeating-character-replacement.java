class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int maxLen = 0;
        int maxFreq = 0 ;
        for(int right = 0;right<n;right++){
            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(right)-'A']);
            if((right-left+1)-maxFreq <=k) maxLen = Math.max(maxLen,right-left+1);
            else{
                while((right-left+1)-maxFreq>k){
                    freq[s.charAt(left++)-'A']--;
                }
            }
        }
        return maxLen;
    }
}