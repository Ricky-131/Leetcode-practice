class Solution {
    public int maximalRectangle(char[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxiArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                } 
                else{
                    heights[j] = 0;
                }
            }
            maxiArea = Math.max(maxiArea, largestRectangleArea(heights));
        }
        return maxiArea;
    }

    private int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int maxiArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++){
            int currHeight = (i==n)? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = (stack.isEmpty())? i : (i - stack.peek() - 1);
                maxiArea = Math.max(maxiArea, height * width);
            }
            stack.push(i);
        }
        return maxiArea;
    }
}
