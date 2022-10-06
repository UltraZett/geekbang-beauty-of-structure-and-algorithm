package cn.com.pzliu.stack;


import java.util.Arrays;

// TODO: 2022/10/6 可使用先前的可自动扩容数组来实现自动扩容的栈
public class StackBasedOnArray<T> implements IStack<T>{

    private T[] array;
    private int size;
    private int length;
    private int tail;



    public StackBasedOnArray(int size) {
        this.size = size;
        this.array = (T[]) new Object[size];
        this.tail = -1;
    }

    @Override
    public void push(T value) {
        if (isFull()){
            throw new IllegalStateException("栈已满");
        }

        this.array[++tail] = value;

    }

    @Override
    public T pop() {
        if (isEmpty()){
            throw new IllegalStateException("栈已空");
        }

        return this.array[tail--];
    }

    @Override
    public T peek() {
        if (isEmpty()){
            throw new IllegalStateException("栈已空");
        }

        return this.array[tail];
    }

    @Override
    public boolean isEmpty() {
        return tail == -1;
    }

    @Override
    public boolean isFull() {
        return tail +1 == size;
    }


    @Override
    public String toString() {

        StringBuilder arrayStr = new StringBuilder("[");

        for (int i = tail; i >=0 ; i--) {
            arrayStr.append(array[i]).append(",");
        }
        arrayStr.append("]");

        return "StackBasedOnArray{" +
                "array=" + arrayStr +
                ", size=" + size +
                ", length=" + length +
                ", tail=" + tail +
                '}';
    }


    public static void main(String[] args) {
        StackBasedOnArray<Integer> arrayStack = new StackBasedOnArray<>(3);
        System.out.println(arrayStack);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack);
//        arrayStack.push(4);
//        System.out.println(arrayStack);
        arrayStack.peek();
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
    }


}
