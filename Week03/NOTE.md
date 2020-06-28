# 学习笔记 - 第三周

回顾：
树的面试题解法一般都是**递归**
1. 节点的定义
2. 重复性（字相似性）

## 第7课 泛型递归、树的递归

### 递归 Recursion

- 递归-循环（依次类推，自相似性）
- 通过函数体来进行的循环（自己调自己）

计算 n!

n! = 1*2*3*...*n

```python
def factorial(n):
	if n <= 1:
		return 1
	return n*factorial(n - 1)
	
```

#### 递归代码模板 

**Python**
```python
def recursion(level, param1, param2, ...):
	# recursion terminator 递归终结条件
	if level > MAX_LEVEL:
	process_result
	return
	
	# process logic in current level 处理当前层逻辑
	process(level, data, ...)
	
	# drill down 下探到下一层
	self.recursion(level + 1, p1, ...)
	
	# reverse the current level status if needed 清理当前层
```

> 递归终结条件 <br/>
> 处理当前层逻辑 <br/>
> 下探到下一层 <br/>
> 清理当前层 <br/>


**java**

```java
public void recur(int level, int param) {
	
	// terminator 
	if (level > MAX_LEVEL) {
		// process result
		return;
	}
	
	// process current logic
	process(level, param);
	
	// drill down 
	recur(level + 1, newParam);
	
	// restore current status
}

```

#### 思维要点

1. 不要人肉进行递归 （最大误区），**抵制人肉递归诱惑**
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）- **找最近重复性**
3. **数学归纳法思维**


## 第8课 分治、回溯

本质也是递归，可以理解为特殊或复杂的递归

### 分治 Divide & Conquer

找重复性

分治代码模板：

```python
def divide_conquer(problem, param1, param2, ... ):
	# recursion terminator
	if problem is None: 
		print_result
		return
	# prepare data
	data = prepare_data(problem)
	subproblems = split_problem(problem, data)
	# conquer subproblems
	subresult1 = self.divide_conquer(subproblems[0], p1, ...)
	subresult2 = self.divide_conquer(subproblems[1], p1, ...)
	subresult3 = self.divide_conquer(subproblems[2], p1, ...)
	...
	# process and generate the final result
	result = process_result(subresult1, subresult2, subresult3, ...)
	
	#revert the current level states
```

### 回溯 Backtracking 

<p>
回溯法采用**试错的思想**，它尝试**分步**的去解决一个问题。在分步解决问题的过程中，当它通过**尝试**发现，现有的分步答案不能得到有效的正确的解答的时候，它将**取消**上一步甚至上几步的计算，再通过其他的可能的分步解答**再次尝试**寻找问题的答案。
</p>

<p>
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种可能情况：
</p>

- 找到一个可能存在的正确答案；
- 在尝试了所有可能分步方式后宣告该问题没有答案。

**在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。**

八皇后问题和数独问题。




