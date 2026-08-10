class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer> hm = new HashMap<>();
        int start = 0;
        int end = 0;
        int mainRes = 0;
        int res = 0;
        while(end < fruits.length ){
            if(hm.isEmpty() || hm.containsKey(fruits[end]) || hm.size() < 2){
                hm.put(fruits[end] , hm.getOrDefault(fruits[end] , 0)+1);
                end++;
                res++;
                mainRes = Math.max(res , mainRes);
            }else {
                while(hm.size() == 2){
                    hm.put(fruits[start] , hm.get(fruits[start])-1);
                    if(hm.get(fruits[start]) == 0){
                        hm.remove(fruits[start]);
                    }
                    res--;
                    start++;
                }
            }
        }
        return mainRes;
    }
}