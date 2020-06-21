# 学习笔记 第二周

## 第五课 哈希表、映射、集合

### Hash table

<p>哈希表（Hash table），也叫散列表，是根据关键码值（key value）而直接进行访问的数据结构。</p>

<p>它通过吧关键码值映射到表中一个位置来访问记录，以加快查找的速度。</p>

<p>这个映射函数叫做散列函数（Hash Function），存放记录的数组叫做哈希表（或散列表）。</p>


### Hash Function 哈希函数

value --> hashing function --> hash code --> value

### Hash Collisions  哈希碰撞

不同的要存储的值通过Hash Function得出同一个值（hash code）。

链表解决冲突，效率退化。

### 复杂度分析

Hash Table 
- 查询 O(1)
- 添加 O(1)
- 删除 O(1)

退化-->最坏（查询O(n)）

### Java Code
- Map: key-value对，key不重复
  new hashMap() / new TreeMap()

- Set：不重复元素的集合
  new HashSet() / new TreeSet()


## 第六课 树、二叉树、二叉搜索树

### 第一节 树、二叉树、二叉搜索树的实现和特征

- 树 Tree

Root 根节点
Parent Node 父节点
Child Node 子节点
Sub-tree 子树 左子树 右子树
level 层


- 二叉树 Binary Tree

只有左节点和右节点

- 图 Graph
有环

Linked List 是特殊化的 Tree
Tree 树特殊化的 Graph

#### 二叉树遍历 Pre-order/In-order/Post-order

1. 前序（Pre-order）：根-左-右
2. 中序（In-order）：左-根-右
3. 后续（Post-order）：左-右-根

树的遍历一般用递归。

```python
def preorder(self, root):

	if root:
		self.traverse_path.append(root.val)
		self.preorder(root, left)
		self.preorder(root, right)

def inorder(self, root):
	
	if root:
		self.inorder(root, left)
		self.traverse_path.append(root.val)
		self.inorder(root, right)

def postorder(self, root):
	
	if root:
		self.postorder(root, left)
		self.postorder(root, right)
		self.traverse_path.append(roo.val)

```

#### 二叉搜索树 Binary Search Tree


##### 二叉搜索树定义
二叉搜索树，也称二叉排序树、有序二叉树（Ordered Binary Tree)、排序二叉树（Sorted Binary Tree），是指一个孔数或者具有下列性质的二叉树：

1. 左子树上**所有节点**的值均小于它的根节点的值；
2. 右子树上**所有节点**的值均大于它的根节点的值；
3. 以此类推：左、右子树也分别为二叉搜索树（这就是重复性！）

中序遍历：升序排列

##### 二叉搜索树常见操作

1. 查询
2. 插入新节点（创建）
3. 删除

时间复杂度都是O(log n)


--- 

## 第6课 堆和二叉堆、图

### 堆和二叉堆的实现和特征

#### 堆 Heap

Heap：可以迅速找到一堆数中的**最大或者最小值**的数据结构。

将根节点最大的堆叫做大顶堆或大根堆，根节点最小的堆叫做小顶堆或小根堆。常见的堆有二叉堆、斐波那契堆等。

假设是大顶堆，则常见操作（API）：

find-max：		O(1)
delete-max:		O(log n)
insert (create):O(log n) or O(1)


#### 二叉堆的性质

通过完全二叉树来实现（注意：不是二叉搜索树）

二叉堆（大顶）他满足下列性质：

[性质一] 是一颗完全树
[性质二] 树种任意节点的值总是>=其子节点的值；

0. 根节点（顶堆元素）是：a[0]
1. 索引为i的左孩子的索引是(2*i+1)；
2. 索引为i的右孩子的索引是(2*i+2)；
3. 索引为i的父节点的索引是floor((i-1)/2)。

##### insert 插入操作

1. 新元素一律先插入到堆的尾部
2. 依次向上调整整个堆的结构（一直到根即可）
3. HeapifyUp


时间复杂度-O(logN)


##### Delete Max  删除堆顶元素

1. 将对位元素替换到顶部（即堆顶被替代删除掉）
2. 依次从根部乡下调整整个堆的结构（一直到堆尾即可）
3. HeapifyDown


时间复杂堆-O(logN）


**注意：二叉堆是堆（优先队列priority_queue）的一一种常见且简单的实现；但是并不是最优的实现。**



### 图的实现和特征

#### 图的属性和分类

有点、有边

- Graph(V, E)
- V - vertex：点
	1. 度 - 入度和出度
	2. 点与点之间：连通与否
- E - edge：边
	1. 有向和无向（单行线）
	2. 权重（边长）

##### 图的表示方法和分类

邻接矩阵和邻接表，
见课件图：
无向无权图
有向无权图

 
#### 基于图的相关算法

##### DFS代码 - 递归写法

~~~
visited = set() **# 和树中的DFS最大区别**

def dfs(node, visited):
	if node in visited: # terminator
		# already visited
		return
	
	visited.add(node)
	
	# process current node here.
	...
	for next_node in node.children():
		if not next_node in visited: 
			dfs(next_node, visited)
~~~

##### BFS

~~~
def BFS(graph, start, end):
	queue = []
	queue.append([start])
	
	visited = set() # 和树中的BFS的最大区别
	
	while queue：
		node = queue.pop（）
		visited.add(node)
		
		process(node)
		nodes = generate_related_nodes(node)
		queue.push(nodes)
	

~~~

##### 图的高级算法

1. 联通图个数
2. 拓扑排序
3. 最短路径
4. 最小生成树