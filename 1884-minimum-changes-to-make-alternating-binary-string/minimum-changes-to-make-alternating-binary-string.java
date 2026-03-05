class Solution {
    public int minOperations(String s) {
        char[] arr = s.toCharArray();
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0;i<arr.length;i++){
            if(i % 2 == 0){
                if(arr[i] == '0'){
                    continue;
                }else {
                    arr[i] = '1';
                    temp1++;
                }
            }else{
                if(arr[i] == '1'){
                    continue;
                }else {
                    arr[i] = '0';
                    temp1++;
                }
            }
        }

        for(int i = 0;i<arr.length;i++){
            if(i % 2 == 0){
                if(arr[i] == '1'){
                    continue;
                }else {
                    arr[i] = '0';
                    temp2++;
                }
            }else{
                if(arr[i] == '0'){
                    continue;
                }else {
                    arr[i] = '1';
                    temp2++;
                }
            }
        }
        return Math.min(temp1,temp2);
    }
}