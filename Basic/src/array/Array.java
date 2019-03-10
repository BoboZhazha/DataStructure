package array;

/**
 * Project：DataStructure
 * ClassName：  array.array
 * Description：
 *
 * @Author: Zhang
 * CreateDate：  2018/11/26 17:29
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * 构造函数， 传入数组的容量来构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        // JAVA没有new E语法, 所以这样转型
        data = (E[])new Object[capacity];
        size = 0;
    }


    public Array() {
        this(10);
    }

    /**
     * 获取数组中元素的个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组末尾插入元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 数组头加入一个元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 向index位置插入一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Addlast failed.  Require index >=0 and index<=size");
        }

        // 扩容
        if (size == data.length) {
            resize(2 * data.length);
        }

        // 从最后一个位置，看到index, 然后每个元素都向后挪一个位置
        for (int i = size - 1; i >= index; i--) {
            // 新的最后一个元素等于原来的最后一个元素，挪的时候从末尾往前挪，就可以肆无忌惮的覆盖之前的元素而不用暂存这个数据
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }


    /**
     * @param index
     * @param e
     */
    void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Index is illegal");
        }
        data[index] = e;
    }

    /**
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param index
     * @return 返回被删除的
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Addlast failed.  Require index >=0 and index<=size");
        }
        E ret = data[index];
        for (int i = index + 1 ; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    public E removeLast() {
        return this.remove(size-1);
    }

    public E removeFirst() {
        return this.remove(0);
    }

    private void resize(int newCapacity) {
        int cap = getCapacity();
//        String logStr = String.format("扩容 %d => %d", cap, newCapacity);
//        System.out.println(logStr);
        E[] newData = (E [])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array.array: size =  %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
