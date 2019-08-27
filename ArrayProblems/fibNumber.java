class Solution {
    public int fib(int N) {
        int[] result = new int[]{0,1};
        int i = 3;
        while(i <= N){
            int next = result[0] + result[1];
            result[0] = result[1];
            result[1] = next;
            i++;
        }
        if(N > 1){return result[1];}
        else{return result[0];}
    }
}
