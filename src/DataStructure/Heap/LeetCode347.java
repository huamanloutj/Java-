package DataStructure.Heap;

import java.util.*;

public class LeetCode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        System.out.println(map.keySet().size());
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            //pq.add(key);
            if (pq.size() < k) {
                pq.add(key);
                //peek是自动的
                System.out.println(pq);
                System.out.println(pq.peek());

            } else if (map.get(key) > map.get(pq.peek())) {
                //remove的是哪一个
                int re = pq.remove();
                //System.out.println(re);
                pq.add(key);
                //System.out.println(pq.peek());
            }
        }
        //System.out.println(pq);
//        System.out.println(pq.peek());

        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        //System.out.println(res);
        return res;
    }
    public static void  main(String[] args){
        int[] nums = new int[]{3,3,3,3,3,4,4,4,2,1,1};
        new LeetCode347().topKFrequent(nums,2);
    }

}
