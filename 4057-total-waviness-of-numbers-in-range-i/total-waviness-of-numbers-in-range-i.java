class Solution {
    public int totalWaviness(int num1, int num2) {
      int res = 0;
        for(int i = num1; i<=num2;i++){
            if(i < 100){
                continue;
            }
            int temp = i;
            ArrayList<Integer> list = new ArrayList<>();
            while(temp > 0){
                int curr = temp % 10;
                list.add(curr);
                temp /=10;
            }
            int n = list.size();
            int prev = -1;
            int next = -1;
            for(int j = n-1 ; j >= 0 ; j--){
                int curr = list.get(j);
                if(prev == -1){
                    prev = curr;
                    continue;
                }
                if(j-1 >= 0){
                    next = list.get(j-1);
                }
                if(curr > prev && curr > next){
                    res++;
                }else if(curr < prev && curr < next){
                    res++;
                }
                prev = curr;
            }
        }
        return res;
      
    }
}