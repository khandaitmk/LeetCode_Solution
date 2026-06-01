class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        int first = 0;
        int second = 1;
        int minDiff = Integer.MAX_VALUE;
        while(second < n){
            minDiff = Math.min(minDiff , arr[second] - arr[first]);
            first = second;
            second++;
        }
        first = 0 ;
        second = 1;
        while(second < n){
            List<Integer> temp = new ArrayList<>();
            if(arr[second] - arr[first] == minDiff){
                temp.add(arr[first]);
                temp.add(arr[second]);
                res.add(new ArrayList(temp));
            }
            first = second;
            second++;
        }
        return res;
    }
}