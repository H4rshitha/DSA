class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        int maxLen = Integer.MAX_VALUE;
        int l =0;
        int[] ans = {-1,-1};
        HashMap<Character,Integer> tMap = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(int i=0;i<t.length();i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int have = 0 ;
        int need = tMap.size();
        for(int r = 0;r<s.length();r++){
            char c = s.charAt(r);
            window.put(c,window.getOrDefault(c,0)+1);
            if(tMap.containsKey(c) && tMap.get(c).equals(window.get(c))){
                have++;
            }
            while(have==need){
                if((r-l+1)<maxLen){
                    maxLen = (r-l+1);
                    ans[0]=l;
                    ans[1]=r;
                }
                char left = s.charAt(l);
                window.put(left,window.getOrDefault(left,0)-1);
                if(tMap.containsKey(left) && tMap.get(left)>window.get(left)){
                    have--;
                }
                l++;
            }
        }
        return maxLen == Integer.MAX_VALUE ? "" : s.substring(ans[0],ans[1]+1);
    }
}