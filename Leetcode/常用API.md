# 常用API

## 数组

- 数组复制

`System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`

src:源数组;

srcPos:源数组要复制的起始位置;

dest:目的数组;

destPos:目的数组放置的起始位置;

length:复制的长度.



## HashMap

- `map.getOrDefalt(key,defaultValue);`  

  获取key的value，如果key不存在，则获取默认值 

- `map.put(key, map.getOrDefault(key,defaultValue)+1);`

  更新map里的值

- `map.keySet()`

- 