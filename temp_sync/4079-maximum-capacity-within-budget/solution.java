import java.util.*;

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] machines = new int[n][2];
        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }
        Arrays.sort(machines, (a, b) -> Integer.compare(a[0], b[0]));
        int maxCap = 0;
        int[] prefixMax = new int[n];
        prefixMax[0] = machines[0][1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], machines[i][1]);
        }
        for (int i = 0; i < n; i++) {
            if (machines[i][0] < budget) {
                maxCap = Math.max(maxCap, machines[i][1]);
            }
        }
        for (int j = 1; j < n; j++) {
            int remaining = budget - machines[j][0];
            if (remaining <= 0) continue;
            int idx = upperBound(machines, remaining - 1, j - 1);
            if (idx != -1) {
                maxCap = Math.max(maxCap,
                        machines[j][1] + prefixMax[idx]);
            }
        }
        return maxCap;
    }
    private int upperBound(int[][] machines, int target, int hi) {
        int left = 0, right = hi;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (machines[mid][0] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
