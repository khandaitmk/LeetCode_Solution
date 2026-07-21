class Solution {
    static class Section{
        char ch;
        int len ;
        public Section(char c , int l){
            this.ch = c;
            this.len = l;
        }
    }
    public int maxActiveSectionsAfterTrade(String s) {
        ArrayList<Section> sections = new ArrayList<>();
        char prev = s.charAt(0);
        int count = 0;

        for(char ch : s.toCharArray()){
            if(prev == ch){
                count++;
            }else{
                sections.add(new Section(prev , count));
                count = 1;
                prev = ch;
            }
        }
        sections.add(new Section(prev , count));

        int totalOnes = 0;
        for (Section sec : sections) {
            if (sec.ch == '1') {
                totalOnes += sec.len;
            }
        }

        int ans = totalOnes;

        for (int i = 1; i < sections.size() - 1; i++) {

            if (sections.get(i).ch != '1')
                continue;

            if (sections.get(i - 1).ch != '0' || sections.get(i + 1).ch != '0')
                continue;

            int leftZero = sections.get(i - 1).len;
            int oneBlock = sections.get(i).len;
            int rightZero = sections.get(i + 1).len;

            ans = Math.max(ans, totalOnes + leftZero + rightZero);
        }

         return ans;
    }
}