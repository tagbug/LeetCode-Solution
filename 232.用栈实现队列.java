import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    Stack<Integer> enStack, deStack;
    Mode mode;

    enum Mode {
        ENTER, DELETE
    }

    public MyQueue() {
        this.enStack = new Stack<>();
        this.deStack = new Stack<>();
        this.mode = Mode.ENTER;
    }

    public void push(int x) {
        if (mode == Mode.DELETE) {
            mode = Mode.ENTER;
            while (!deStack.isEmpty()) {
                enStack.push(deStack.pop());
            }
        }
        enStack.push(x);
    }

    public int pop() {
        if (mode == Mode.ENTER) {
            mode = Mode.DELETE;
            while (!enStack.isEmpty()) {
                deStack.push(enStack.pop());
            }
        }
        return deStack.pop();
    }

    public int peek() {
        if (mode == Mode.ENTER) {
            mode = Mode.DELETE;
            while (!enStack.isEmpty()) {
                deStack.push(enStack.pop());
            }
        }
        return deStack.peek();
    }

    public boolean empty() {
        if (mode == Mode.ENTER) {
            return enStack.isEmpty();
        }
        return deStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
