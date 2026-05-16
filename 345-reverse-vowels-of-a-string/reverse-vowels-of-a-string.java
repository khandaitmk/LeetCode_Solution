class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int start = 0;
        int end = n-1;  
        ArrayList<Character> vl = new ArrayList<>();
        vl.add('a');
        vl.add('e');
        vl.add('i');
        vl.add('o');
        vl.add('u');
        vl.add('A');
        vl.add('E');
        vl.add('I');
        vl.add('O');
        vl.add('U');      
        while(start < end){
            if(vl.contains(arr[start]) && vl.contains(arr[end])){
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }else if(vl.contains(arr[start])){
                end--;
            }else if(vl.contains(arr[end])){
                start++;
            }else{
                start++;
                end--;
            }
        }
        return new String(arr);
    }
}