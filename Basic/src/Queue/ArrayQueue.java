package Queue;

import Array.Array;

public class ArrayQueue<E> implements Queue<E>{

    private Array<E> array;


    public ArrayQueue() {
        this.array = new Array<E>();
    }

    public ArrayQueue(int capacicy) {
        this.array = new Array<E>(capacicy);
    }

    // 入队
    @Override
    public void enqueue(E e) {
        array.addLast(e);

    }

    // 出队
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    //
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayQuene: ");
        res.append("head: [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
            if (i % 3 == 0) {
                queue.dequeue();
                System.out.println(queue.toString());
            }
        }
    }
}
