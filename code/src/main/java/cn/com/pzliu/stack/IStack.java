package cn.com.pzliu.stack;

public interface IStack<T> {

    /**
     * 压栈
     * @param value
     */
    void push(T value);

    /**
     * 弹出栈顶
     * @return
     */
    T pop();

    /**
     * 取出栈顶
     * @return
     */
    T peek();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否满
     * @return
     */
    boolean isFull();

}
