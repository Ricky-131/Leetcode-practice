class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        long mul = 1;
        char arr[] = columnTitle.toCharArray();
        for(int i=arr.length-1 ; i>=0 ; i-- , mul*=26){
            sum+=(arr[i] - 64)*mul;
        }
        return sum;
    }
}
