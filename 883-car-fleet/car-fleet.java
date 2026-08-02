class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pair = new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]=position[i] ;
            pair[i][1]=speed[i] ;
        }
        Arrays.sort(pair,(a,b)-> Integer.compare(b[0],a[0]));
        Stack<Double> stack = new Stack<>();
        for(int[] thing : pair){ 
            stack.push((double)(target - thing[0])/thing[1]);
            if(stack.size()>=2 && stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }
}