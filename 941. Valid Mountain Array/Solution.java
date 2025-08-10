class Solution {
    public boolean validMountainArray(int[] arr) {
        int i, mlen = arr.length;
        boolean cond = true;
        
        if(mlen < 3){
            return false;
        }
        else if(arr[mlen-2]<arr[mlen-1] || arr[0]>arr[1]){
            return false;
        }

        for(i=0; i<mlen-1 ; i++){
            if(cond && arr[i]<arr[i+1]){
            }
            else{
                cond = false;
                if(arr[i]>arr[i+1]){
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
