class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        PriorityQueue<Character> pq = new PriorityQueue<>();

        if(n % 2 == 0){
            for(int i = 0;i<n/2;i++){
                pq.add(s.charAt(i));
            }
            char[] arr = new char[n];
            int start = 0;
            int end = n-1;
            while(start < end){
                arr[start] = arr[end] = pq.remove();
                start++;
                end--;
            }
            return new String(arr);
        }else{
            char mid = s.charAt(n/2);
            for(int i = 0;i<n/2;i++){
                pq.add(s.charAt(i));
            }
            char[] arr = new char[n];
            int start = 0;
            int end = n-1;
            while(start <= end){
                if(start == end){
                    arr[start] = mid;
                }else{
                    char ch = pq.remove();
                    arr[start] = ch;
                    arr[end] = ch;
                }
                start++;
                end--;
            }
            return new String(arr);
        }
    }
}