package LinkedList;

public class LinkedList<E> {

    // 在链表里有一个Node的内部类
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    // 获取元素的个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 头部添加
    public void addFirst(E e) {
//        Node node = new Node(e);
        // 让新节点的next指向之前的那个头(连接)
//        node.next = head;
        // 更新头部节点为新的节点
//        head = node;

        head = new Node(e, head);
        size ++;
    }


}
