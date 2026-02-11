package LC3721_Longest_Balanced_Subarray_II;
import java.util.*;
class Solution {
    int[] l, r, mn, mx, lazy;

    private void build(int u, int left, int right) {
        l[u] = left;
        r[u] = right;
        if (left == right) return;
        int mid = (left + right) >> 1;
        build(u << 1, left, mid);
        build(u << 1 | 1, mid + 1, right);
    }

    private void apply(int u, int v) {
        mn[u] += v;
        mx[u] += v;
        lazy[u] += v;
    }

    private void pushdown(int u) {
        if (lazy[u] != 0) {
            apply(u << 1, lazy[u]);
            apply(u << 1 | 1, lazy[u]);
            lazy[u] = 0;
        }
    }

    private void pushup(int u) {
        mn[u] = Math.min(mn[u << 1], mn[u << 1 | 1]);
        mx[u] = Math.max(mx[u << 1], mx[u << 1 | 1]);
    }

    private void modify(int u, int left, int right, int v) {
        if (l[u] >= left && r[u] <= right) {
            apply(u, v);
            return;
        }
        pushdown(u);
        int mid = (l[u] + r[u]) >> 1;
        if (left <= mid) modify(u << 1, left, right, v);
        if (right > mid) modify(u << 1 | 1, left, right, v);
        pushup(u);
    }

    private int query(int u, int target) {
        if (l[u] == r[u]) return l[u];
        pushdown(u);
        if (mn[u << 1] <= target && target <= mx[u << 1]) {
            return query(u << 1, target);
        }
        return query(u << 1 | 1, target);
    }

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int size = (n + 1) * 4;
        l = new int[size];
        r = new int[size];
        mn = new int[size];
        mx = new int[size];
        lazy = new int[size];
        
        build(1, 0, n);

        Map<Integer, Integer> last = new HashMap<>();
        int now = 0, ans = 0;

        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            int det = (x & 1) == 1 ? 1 : -1;
            
            if (last.containsKey(x)) {
                modify(1, last.get(x), n, -det);
                now -= det;
            }
            last.put(x, i);
            modify(1, i, n, det);
            now += det;

            int pos = query(1, now);
            ans = Math.max(ans, i - pos);
        }

        return ans;
    }
}