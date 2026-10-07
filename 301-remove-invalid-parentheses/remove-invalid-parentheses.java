class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum number of removals
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;
            }

            else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } else {
                    rightRemove++;
                }
            }
        }

        dfs(s, 0, 0, 0, leftRemove, rightRemove, new StringBuilder());

        return new ArrayList<>(result);
    }


    private void dfs(
            String s,
            int index,
            int leftCount,
            int rightCount,
            int leftRemove,
            int rightRemove,
            StringBuilder path) {

        // Reached the end
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                leftCount == rightCount) {

                result.add(path.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // Case 1: Remove current parenthesis
        if (c == '(' && leftRemove > 0) {

            dfs(
                s,
                index + 1,
                leftCount,
                rightCount,
                leftRemove - 1,
                rightRemove,
                path
            );
        }

        if (c == ')' && rightRemove > 0) {

            dfs(
                s,
                index + 1,
                leftCount,
                rightCount,
                leftRemove,
                rightRemove - 1,
                path
            );
        }


        // Case 2: Keep current character

        path.append(c);

        if (c != '(' && c != ')') {

            dfs(
                s,
                index + 1,
                leftCount,
                rightCount,
                leftRemove,
                rightRemove,
                path
            );

        }

        else if (c == '(') {

            dfs(
                s,
                index + 1,
                leftCount + 1,
                rightCount,
                leftRemove,
                rightRemove,
                path
            );

        }

        else if (c == ')' && rightCount < leftCount) {

            dfs(
                s,
                index + 1,
                leftCount,
                rightCount + 1,
                leftRemove,
                rightRemove,
                path
            );
        }

        path.deleteCharAt(path.length() - 1);
    }
}