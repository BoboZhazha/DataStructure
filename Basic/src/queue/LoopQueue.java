package queue;


/**
 * 对于循环队列来说, 判断队列是否为满 (tail +1) % data.length == front
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    // 指向队首所在的索引
    private int front;

    // 队列最后一个元素的下一个位置即新入队的索引
    private int tail;

    private int size;

    public LoopQueue(int capacity) {

        // 因为队列满和队列空都是front=tail, 所以有意识的浪费一个作为区分, 加1才能容纳用户所期望的容量
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    // 容量实际上是数组的底层数组的长度-1
    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public void enqueue(E e) {
        // 先判断是否满
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        // 防止tail 无限制加下去, 所以,(tail + 1) % data.length的意思就是只要超过了长度就是在长度内换行重新计数
        tail = (tail + 1) % data.length;
        size++;
    }

    // 扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // 扩容以后,是把队列放置成头是索引0的那种
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from a empty queue!");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        // 缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    // 看一眼队首的元素
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from a empty queue!");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size =  %d , capacity = %d\n", size, getCapacity()));
        res.append(" front [");
        // 这个是另外一种遍历循环队列的方法
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>(10);
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }

        }
    }
}
