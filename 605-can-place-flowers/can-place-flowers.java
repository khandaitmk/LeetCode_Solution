class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;

        for(int i=0;i<len;i++){
            if(i == 0 ){
                if(flowerbed[i] == 0 && (len == 1 || flowerbed[i+1] == 0)){
                    count++;
                    flowerbed[i] = 1;
                }
            }else if(i == len - 1 ){
                if(flowerbed[i] != 1 && flowerbed[i-1] != 1){
                    count++;
                    flowerbed[i] = 1;
                }
            }
            else{
                if(flowerbed[i] != 1){
                    if(flowerbed[i-1] != 1 && flowerbed[i+1] != 1){
                        count++;
                        flowerbed[i] = 1;
                    }
                }
            }
        }
        return count >= n;
    }
}