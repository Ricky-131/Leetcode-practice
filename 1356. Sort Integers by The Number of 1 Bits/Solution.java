class Solution {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr.length-i-1; j++){
                int b1 = Integer.bitCount(arr[j]);
                int b2 = Integer.bitCount(arr[j + 1]);
                if (b1>b2 || (b1==b2 && arr[j] > arr[j+1])){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}