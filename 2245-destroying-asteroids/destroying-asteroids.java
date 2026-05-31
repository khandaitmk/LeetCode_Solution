class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long temp = mass;
        for(int i=0;i<n;i++){
            long astroid = asteroids[i];
            if(temp >= astroid){
                temp += astroid;
            }else{
                temp -= astroid;
            }
        }
        if(temp > 0){
            return true;
        }
        return false;
    }
}