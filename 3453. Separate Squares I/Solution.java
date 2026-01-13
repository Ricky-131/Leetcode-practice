class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        for (int[] square : squares) {
            double y = square[1];
            double l = square[2];
            totalArea+=(l*l);
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }
        double target = totalArea/2;
        for (int i = 0; i < 47; i++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;
            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];
                double top = y + l;
                if (mid <= y) 
                continue;
                else if (mid >= top) 
                areaBelow += l*l;
                else 
                areaBelow += (mid - y) * l;
            }
            if (areaBelow >= target) 
            high = mid;
            else 
            low = mid;
        }
        return high;
    }
}
