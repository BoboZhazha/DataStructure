import java.util.Arrays;

/**
 * Project：DataStructure
 * ClassName：  Array
 * Description：
 *
 * @Author: Zhang
 * CreateDate：  2018/11/26 17:29
 */
public class Array {

    private int[] data;

    private int size;

    /**
     * 构造函数， 传入数组的容量来构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
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
    public void addLast(int e) {
        add(size, e);
    }

    /**
     * 数组头加入一个元素
     *
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 向index位置插入一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Addlast failed. Array is full");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Addlast failed.  Require index >=0 and index<=size");
        }

        // 从最后一个位置，看到index, 然后每个元素都向后挪一个位置
        for (int i = size - 1; i >= index; i--) {
            // 新的最后一个元素等于原来的最后一个元素，挪的时候从末尾往前挪，就可以肆无忌惮的覆盖之前的元素而不用暂存这个数据
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * @param index
     * @return
     */
    int get(int index) {
        if (size == data.length) {
            throw new IllegalArgumentException("Addlast failed. Array is full");
        }
        return data[index];
    }


    /**
     * @param index
     * @param e
     */
    void set(int index, int e) {
        data[index] = e;
    }

    /**
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
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
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Addlast failed.  Require index >=0 and index<=size");
        }
        int ret = data[index];
        for (int i = index + 1 ; i < size; i++) {
            data[i-1] = data[i];
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size =  %d , capacity = %d\n", size, data.length));
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
