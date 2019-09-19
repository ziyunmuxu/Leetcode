package cn.easy_sumofnum_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ�����������������������ǵ������±ꡣ
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء�
 * @author ziyunmuxu
 *
 */

public class SumofNumber {
	
	
	/**
	 * ����1�������ͨ��˫�����ƶ����ҵ���
	 * ���⣺
	 * 1��������Ҫ���������±꣬����������±���Ϣ��ʧ�������Ҫʹ��һ�������±�Ͷ�Ӧvalue
	 * 2�������������±겻�ܰ��մ�С�����˳�����
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
	 * ���Ž⣺��ϣ��
	 * ���entry��key��valueֵ��value��index��ֵ
	 * ֱ���ж��Ƿ����target-nums[i]�������ؽ��
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