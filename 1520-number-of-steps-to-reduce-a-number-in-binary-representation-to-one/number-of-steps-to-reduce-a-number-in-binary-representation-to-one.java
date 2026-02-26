class Solution {
    public int numSteps(String s) {
        int steps = 0;
        StringBuilder str = new StringBuilder(s);
        while(!str.toString().equals("1")){
            if(str.charAt(str.length()-1) == '0'){
                str.deleteCharAt(str.length()-1);
            }else{
                addOne(str);
            }
            steps++;
        }
        return steps;
    }
    public static void addOne(StringBuilder str){
        int i = str.length()-1;
        while( i >= 0 && str.charAt(i) == '1'){
            str.setCharAt(i,'0');
            i--;
        }
//        as we found the 0 so convert it to 1
        if(i>=0){
            str.setCharAt(i,'1');
        }else{
            str.insert(0,'1');
        }
    }
}