# geekbang-beauty-of-structure-and-algorithm
极客时间-数据结构与算法之美笔记以及代码实现

## Day01
 数组和链表
 
### 数组
#### 实现
1. 实现一个支持动态扩容的数组
   1. Type parameter 'T' cannot be instantiated directly
      1. https://blog.csdn.net/tongkongyu/article/details/122920051
   2. 实现时注意边界条件
   3. 待实现缩容
2. 实现一个大小固定的有序数组，支持动态增删改查操作
   1. 保持有序要在插入时进行排序
   2. 可以用二分的方法优化其中的内容
3. 实现两个有序数组合并成为一个有序数组

#### 练习题
1. 三数之和
   1. 暴力枚举
      1.判重 
   2. 双指针
      1. 推导公式
2. 多数元素
   1. 排序取中间
   2. 摩尔投票
   3. 分治
3. 缺失的第一个正数
   1. 用标记法来处理
