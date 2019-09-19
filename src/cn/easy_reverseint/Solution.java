package cn.easy_reverseint;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @author ziyunmuxu
 *
 */

class Solution {
	
	/**
	 * 设计错误，因为该方法没有考虑到反转之后的范围问题
	 * @param x
	 * @return
	 */
    public int reverse(int x) {
    	boolean positive_flag = true;
        if(x < 0){
        	positive_flag = false;
        	x = -x;
        }
        	
        String temp = Integer.toString(x);
        String temp_rev = new StringBuilder(temp).reverse().toString();
        
        int x_reverse = Integer.valueOf(temp_rev);
        
        if(positive_flag == false)
        	x_reverse = -x_reverse;
        
        return x_reverse;
        
    }
    
    /**
     * 针对越界问题优化
     * @param x
     * @return
     */
    public int reverse_1(int x) {
    	boolean positive_flag = true;
    	long x_temp = x;
        if(x_temp < 0){
        	positive_flag = false;
        	x_temp = -x_temp;
        }
        	
        String temp = Long.toString(x_temp);
        String temp_rev = new StringBuilder(temp).reverse().toString();
        
        long x_reverse = Long.valueOf(temp_rev);
        if(positive_flag == false)
        	x_reverse = -x_reverse;
        
        
        if(x_reverse > Integer.MAX_VALUE || x_reverse<Integer.MIN_VALUE)
        	return 0;
        
        return (int)x_reverse;
        
    }
    
    
    /**
     * 最优解
     * 可以联想到栈的实现
     *  int 的范围 [-2147483648, 2147483647] 
     *  
     * @param x
     * @return
     */
    public int reverse_2(int x) {
    	int res = 0;
    	while(x != 0){
    		int pop = x%10;
    		x /=10;
    		
    		if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop >7))
    			return 0;
    		if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < -8))
    			return 0;
    		
    		res = res*10 + pop;
    	}
    	return res;
    }
 
}
