package Stack;

import Array.Array;

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacicy) {
        this.array = new Array<E>(capacicy);
    }

    public ArrayStack() {
        this.array = new Array<E>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);

    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 看一眼栈顶是啥
     *
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }


    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
