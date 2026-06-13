class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length, zeroCount = 0;
        int[] zeroList = new int[len];
        Set<Integer> zeroIndexSet = new HashSet<>();
        int prefixProd = 1, prefixProdWithoutZero = 1;
        for(int i = 0; i < len; i++){
            if(nums[i] == 0) {
                zeroList[i] = 1;
                zeroCount++;
                zeroIndexSet.add(i);
            }
            
            if(nums[i] != 0){
                prefixProdWithoutZero *= nums[i];
            }
            
            if(prefixProd == 0) {
                continue;
            }

            prefixProd *= nums[i];
        }

        int res[] = new int[len];
        for(int i = 0; i < len; i++){
            if(prefixProd != 0){
                res[i] = prefixProd / nums[i];
            } else if (zeroIndexSet.contains(i) && zeroCount == 1) {
                res[i] = prefixProdWithoutZero;
            } else if(zeroIndexSet.contains(i) && zeroCount > 1){
                res [i] = 0;
            }
        }
        return res;
    }
}  
