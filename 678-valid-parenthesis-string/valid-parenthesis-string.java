class Solution {
    public boolean checkValidString(String s) {

        int n = s.length();

        // dp[i][open]
        // Can we make the string valid from index i
        // when 'open' '(' are currently unmatched?
        Boolean[][] dp = new Boolean[n][n + 1];

        return helper(s, 0, 0, dp);
    }

    public boolean helper(String s, int i, int open, Boolean[][] dp) {

        // More ')' than '('
        if (open < 0) {
            return false;
        }

        // End of string
        if (i == s.length()) {
            return open == 0;
        }

        // Already calculated
        if (dp[i][open] != null) {
            return dp[i][open];
        }

        char ch = s.charAt(i);

        boolean result;

        if (ch == '(') {

            // '(' must be used as '('
            result = helper(s, i + 1, open + 1, dp);

        } else if (ch == ')') {

            // ')' must close an existing '('
            result = helper(s, i + 1, open - 1, dp);

        } else {

            // '*' can be empty
            boolean empty = helper(s, i + 1, open, dp);

            // '*' can be '('
            boolean openBracket =
                    helper(s, i + 1, open + 1, dp);

            // '*' can be ')'
            boolean closeBracket = false;

            if (open > 0) {
                closeBracket =
                        helper(s, i + 1, open - 1, dp);
            }

            result = empty || openBracket || closeBracket;
        }

        dp[i][open] = result;

        return result;
    }
}