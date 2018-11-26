/**
 * Project：DataStructure
 * ClassName：  Array
 * Description：
 * Author: Zhang
 * CreateDate：  2018/11/26 17:29
 */
public class Array<E> {
    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组的容量capacity=10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Requre index >= 0 and index <= size");
        }




    }

    // 向所有元素后添加一个新元素
    public void addLast(E e) {
    }

    // 在所有元素前添加一个新元素
    public void addFirst(E e) {
    }

    // 获取index索引位置的元素
    public E get(int index) {
        return null;
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e) {
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        return 0;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove(int index) {
        return null;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return null;
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return null;
    }

    // 从数组中删除元素e
    public void removeElement(E e) {

    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        return "";

    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            //
            newData[i] = data[i];
        }
        data = newData;
    }
}
