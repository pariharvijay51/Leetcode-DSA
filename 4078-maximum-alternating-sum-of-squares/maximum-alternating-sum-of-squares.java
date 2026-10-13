
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        for (int i = 0; i < n; i++) {
            squares[i] = 1L * nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long ans = 0;
        int k = (n + 1) / 2;

        for (int i = 0; i < n - k; i++) {
            ans -= squares[i];
        }

        for (int i = n - k; i < n; i++) {
            ans += squares[i];
        }

        return ans;
    }
}
