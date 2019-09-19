package cn.easy_sumofnum_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @author ziyunmuxu
 *
 */

public class SumofNumber {
	
	
	/**
	 * 方案1：排序后通过双坐标移动，找到解
	 * 问题：
	 * 1、由于需要返回数组下标，但是排序后，下标信息丢失，因此需要使用一个类存放下标和对应value
	 * 2、排序后，输出的下标不能按照从小到大的顺序输出
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		List<NodeNum> array = new ArrayList<NodeNum>();
		for(int i=0; i<nums.length; i++){
			array.add(new NodeNum(i, nums[i]));
		}
		Collections.sort(array, new Comparator<NodeNum>() {
            @Override
            public int compare(NodeNum o1, NodeNum o2) {
                return o1.value-o2.value;
            }
        });

		int begin_index = 0;
        int end_index = array.size()-1;
        
        if(nums.length < 2)
            return null;
        
        while(begin_index < end_index){
            if(array.get(begin_index).value + array.get(end_index).value > target){
                end_index--;
            }else if(array.get(begin_index).value + array.get(end_index).value  < target){
                begin_index++;
            }else{
                return new int[]{array.get(begin_index).index, array.get(end_index).index};
            }    
        }
		
        return null;
		
    }
	
	
	
	/**
	 * 最优解：哈希表
	 * 存放entry的key是value值；value是index的值
	 * 直接判定是否存在target-nums[i]，来返回结果
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum_1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
	
	public static void main(String[] args) {
		
	}
	
	
}

class NodeNum{
	int index;
	int value;
	
	public NodeNum(int index, int value) {
		super();
		this.index = index;
		this.value = value;
	}
}