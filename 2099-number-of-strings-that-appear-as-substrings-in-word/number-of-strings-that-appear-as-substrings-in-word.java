class Solution {
    public int numOfStrings(String[] patterns, String word) {
        // int n = word.length();
        // ArrayList<String> list = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     for(int j = i+1 ; j < n+1 ; j++){
        //         list.add(word.substring(i,j));
        //     }
        // }
        // int count = 0;
        // for(int i = 0;i<patterns.length;i++){
        //     if(list.contains(patterns[i])){
        //         count++;
        //     }
        // }
        // return count ;
        int count = 0;
        for(int i=0;i<patterns.length;i++){
            if(word.contains(patterns[i])){
                count++;
            }
        }
        return count;
    }
}