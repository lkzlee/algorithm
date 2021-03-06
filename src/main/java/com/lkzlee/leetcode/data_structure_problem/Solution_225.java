package com.lkzlee.leetcode.data_structure_problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * @author: lkzlee
 * @date: 2019-10-29 15:48
 * @desc:使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_225 {
    Queue<Integer> queue1 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public Solution_225() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        List<Integer> tmpList = new ArrayList<>();
        int lens = queue1.size();
        tmpList.add(x);
        for (int i = 0; i < lens; i++) {
            tmpList.add(queue1.poll());
        }
        for (int i = 0; i < tmpList.size(); i++) {
            queue1.add(tmpList.get(i));
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {

    }
}
