import java.util.*;
class SegmentTree {
    int[] cnt, cover, xs;
    int n;

    SegmentTree(int[] xs) {
        this.xs = xs;
        n = xs.length - 1;
        cnt = new int[4 * n];
        cover = new int[4 * n];
    }

    void update(int l, int r, int v) {
        update(l, r, v, 0, n - 1, 0);
    }

    void update(int l, int r, int v, int s, int e, int i) {
        if (xs[e + 1] <= l || xs[s] >= r) return;

        if (l <= xs[s] && xs[e + 1] <= r) {
            cnt[i] += v;
        } else {
            int m = (s + e) >> 1;
            update(l, r, v, s, m, i * 2 + 1);
            update(l, r, v, m + 1, e, i * 2 + 2);
        }

        if (cnt[i] > 0) {
            cover[i] = xs[e + 1] - xs[s];
        } else {
            cover[i] = (s == e) ? 0 : cover[i * 2 + 1] + cover[i * 2 + 2];
        }
    }

    int query() {
        return cover[0];
    }
}

class Solution {

    public double separateSquares(int[][] squares) {
        List<int[]> events = new ArrayList<>();
        TreeSet<Integer> xsSet = new TreeSet<>();

        for (int[] s : squares) {
            int x = s[0], y = s[1], l = s[2];
            events.add(new int[]{y, 1, x, x + l});
            events.add(new int[]{y + l, -1, x, x + l});
            xsSet.add(x);
            xsSet.add(x + l);
        }

        events.sort(Comparator.comparingInt(a -> a[0]));
        int[] xs = xsSet.stream().mapToInt(i -> i).toArray();
        SegmentTree st = new SegmentTree(xs);

        List<Long> prefix = new ArrayList<>();
        List<Integer> widths = new ArrayList<>();

        long total = 0;
        int prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0];
            total += (long) st.query() * (y - prevY);
            st.update(e[2], e[3], e[1]);
            prefix.add(total);
            widths.add(st.query());
            prevY = y;
        }

        long target = (total + 1) / 2;
        int idx = lowerBound(prefix, target);

        long area = prefix.get(idx);
        int w = widths.get(idx);
        int h = events.get(idx)[0];

        return h + (total - area * 2) / (w * 2.0);
    }

    int lowerBound(List<Long> a, long t) {
        int l = 0, r = a.size() - 1, res = 0;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (a.get(m) < t) {
                res = m;
                l = m + 1;
            } else r = m - 1;
        }
        return res;
    }
}
