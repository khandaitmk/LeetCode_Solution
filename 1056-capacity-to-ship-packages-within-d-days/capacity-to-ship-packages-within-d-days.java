class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        int res = 0;
        for(int num : weights){
            start = Math.max(start , num);
            end += num;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            int d = countDays(weights,mid);
            if(d <= days){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }
    public static int countDays(int[] arr , int mid){
        int n = arr.length;
        int total = 0;
        int count = 1;
        for(int num : arr){
            if(total+num <= mid){
                total += num;
            }else{
                count++;
                total = num;
            }
        }
        return count;
    }
}