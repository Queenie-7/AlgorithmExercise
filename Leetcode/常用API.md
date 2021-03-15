# 常用API

## 数组

- 数组复制

`System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`

src:源数组;

srcPos:源数组要复制的起始位置;

dest:目的数组;

destPos:目的数组放置的起始位置;

length:复制的长度.



## 字符串

- 字符串截取

  `str.substring(startIndex,endIndex)`

  注意，左闭右开[start,end) 最后一个位置不包括
  
- 字符串反转

  `String r = new StringBuffer(str).reverse().toString();`

- 字符串 字符数组之间转化

  - `char [] arr = str.toCharArray();`
  - `String str = new String(arr);`

## HashMap

- 获取key的value，如果key不存在，则获取默认值

  - `map.getOrDefalt(key,defaultValue);`  

   

- 更新map里的值,原有起初上加1

  - `map.put(key, map.getOrDefault(key,defaultValue)+1);`

  

- 获取Set 集合

  - `map.keySet()`

- `map.containsKey()`



## HashSet

- 添加元素：

  `hashset.add(E e)`：返回boolean型，如果此 set 中尚未包含指定元素，则添加指定元素；如果此 set 已包含该元素，则该调用不更改 set 并返回 false。

- 删除元素：

  `hashset.clear()`：从此 set 中移除所有元素。

  `hashset.remove(Object o)`：如果指定元素存在于此 set 中，则将其移除。

  `hashset.isEmpty()`：如果此 set 不包含任何元素，则返回 true。

  `hashset.contains(Object o)`：如果此 set 包含指定元素，则返回 true。

  `hashset.size()`：返回此 set 中的元素的数量（set 的容量）



## 逆序

- List

`Collections.reverse(list)`

- String

  字符串不能直接逆序，先变成`StringBuilder`

  ~~~java
  String string="runoob";
  String reverse = new StringBuffer(string).reverse().toString();
  ~~~

  

## ArrayList

`list.add(e);`

`list.add(index,e);`在某个位置插入，其他后移

从头开始添加元素 `list.add(0,e)`