import array.Array;
import stack.ArrayStack;

/**
 * Project：DataStructure
 * ClassName：  main
 * Description：
 * @Author: Zhang
 * CreateDate：  2018/11/26 20:15
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<Integer>();
        for (int i = 0; i < 10; i++) {
            s.push(i);
            System.out.println(s);
        }

        s.pop();
        System.out.println(s);

        s.peek();
        System.out.println(s);

        s.push(333);
        System.out.println(s);

        s.push(444);
        System.out.println(s);

    }


    public static void tArray() {
        Array<Float> arr = new Array<Float>(3);
        for (int i = 0; i < 10; i++) {
            arr.addLast((float)i);
        }

        arr.add(1, 100f);
        System.out.println(arr);

        arr.addFirst(-1f);
        System.out.println(arr);

        arr.addLast(9999f);
        System.out.println(arr);
    }

}
