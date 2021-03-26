# 出现次数的TopK问题

输入字符串，根据频率次数输出前K个

```
["1","2","3","4"],2
```

输出：每行：<字符串，频率>

```
[["1","1"],["2","1"]]
```



## 堆排序(重写比较器) + hash

~~~java
public class Solution {
    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:strings){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        
        // 按频率从大到小 选K个，小根堆
        PriorityQueue<Node> heap = new PriorityQueue<>(new TopComparator());
        for(String s:map.keySet()){
            Node node = new Node(s,map.get(s));
            if(heap.size()<k){
                heap.offer(node);
            }else{
                // 注意，相等的先进去排序，再出来
               if(node.num>=heap.peek().num){
                   heap.offer(node);
                   heap.poll();
               } 
            }
        }
        
        // 输出
        String[][] res = new String[k][2];
        for(int i=heap.size()-1;i>=0;i--){
            Node node = heap.poll();
            res[i][0] = node.val;
            res[i][1] = String.valueOf(node.num);
        }
        
        return res;
    }
    
    class Node{
        String val;
        int num;
        Node(String val, int num){
            this.num=num;
            this.val=val;
        }
    }
    
    // 重写比较器
    class TopComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1,Node o2){
            // 注意:相等时，返回字典序小的字符串，字典序小的大
            if(o1.num==o2.num){
                return o2.val.compareTo(o1.val);
            }else{
                return o1.num-o2.num;
            }
        }
    }
}
~~~

