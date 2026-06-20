class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
if(restrictions.length == 0){
            return n - 1;
        }

        Arrays.sort(restrictions, (a,b) -> a[0] - b[0]);

        // Left to Right Pass
        for(int i = 0; i < restrictions.length; i++){

            int pos = restrictions[i][0];
            int value = restrictions[i][1];

            if(i == 0){

                int valid = pos - 1;

                restrictions[i][1] =
                        Math.min(value, valid);

            }else{

                int prevPos = restrictions[i-1][0];

                int valid =
                        restrictions[i-1][1]
                                + (pos - prevPos);

                restrictions[i][1] =
                        Math.min(value, valid);
            }
        }
        for(int i = restrictions.length-2; i >= 0; i--){
            restrictions[i][1] =
                    Math.min(
                            restrictions[i][1],
                            restrictions[i+1][1] +
                                    (restrictions[i+1][0] - restrictions[i][0])
                    );
        }
        
        int max = 0;

        // First segment : Building 1 -> First Restriction
        int firstPeak = (0 + restrictions[0][1] + (restrictions[0][0] - 1)) / 2;

        max = Math.max(max, firstPeak);

        // Between Restrictions
        for(int i = 0; i < restrictions.length - 1; i++){

            int h1 = restrictions[i][1];
            int h2 = restrictions[i+1][1];

            int distance =
                    restrictions[i+1][0]
                            - restrictions[i][0];

            int peak =
                    (h1 + h2 + distance)
                            / 2;

            max = Math.max(max, peak);
        }

        // Last Restriction -> Building n
        int lastIndex =
                restrictions[restrictions.length - 1][0];

        int lastHeight =
                restrictions[restrictions.length - 1][1];

        max = Math.max(
                max,
                lastHeight + (n - lastIndex)
        );

        return max;
    }
}