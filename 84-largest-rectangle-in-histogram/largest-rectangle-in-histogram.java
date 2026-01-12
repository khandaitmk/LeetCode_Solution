class Solution {
    public int largestRectangleArea(int[] heights) {
        // int[] heights = {2,4};
        // int [] temp = heights.clone();
        int[] nextSmall = nextSmaller(heights);
        int[] prevSmall = prevSmaller(heights);
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int i1 = nextSmall[i];
            int i2 = prevSmall[i];
            int diff = 0;
            // if(i1<0 && i2<0){
            //     i1 = heights.length-i;
            //     i2 = i-0;
            //     diff = i1+i2;
            //     int tem = diff*heights[i];
            //     maxArea = Math.max(tem,maxArea);
            //     continue;
            // }
            if(i1<0){
                i1 = heights.length;
            }
            if(i2<0){
                i2 =-1 ;
            }
            diff = i1-i2-1;
            int tem= diff*heights[i];
            maxArea = Math.max(maxArea,tem);
        }
        return maxArea;
    }
    public static int[] nextSmaller(int[] arr){
        Stack<Integer> sc = new Stack<>();
        int[] nextSmaller = new int[arr.length];
        for(int i=arr.length-1;i>=0 ;i--){
            while(!sc.isEmpty() && arr[sc.peek()]>=arr[i]){
                sc.pop();
            }
            if(sc.isEmpty()){
                nextSmaller[i] = -1;
            }else {
                nextSmaller[i] = sc.peek();
            }
            sc.push(i);
        }
        return nextSmaller;
    }

    public static int[] prevSmaller(int[] arr){
        Stack<Integer> sc = new Stack<>();
        int[] nextSmaller = new int[arr.length];
        for(int i=0;i< arr.length ;i++){
            while(!sc.isEmpty() && arr[sc.peek()]>=arr[i]){
                sc.pop();
            }
            if(sc.isEmpty()){
                nextSmaller[i] = -1;
            }else {
                nextSmaller[i] = sc.peek();
            }
            sc.push(i);
        }
        return nextSmaller;
    }
}