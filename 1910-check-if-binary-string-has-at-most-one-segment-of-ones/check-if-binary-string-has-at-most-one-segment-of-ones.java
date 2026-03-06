class Solution {
    public boolean checkOnesSegment(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        boolean active = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '0'){
                active = false;
            }else if(arr[i] == '1' && active == false){
            count++;
            active = true;
           }
        }
        return count == 1;
    }
}