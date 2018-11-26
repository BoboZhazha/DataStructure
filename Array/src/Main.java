
/**
 * Project：DataStructure
 * ClassName：  main
 * Description：
 * @Author: Zhang
 * CreateDate：  2018/11/26 20:15
 */
public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.addLast(9999);
        System.out.println(arr);

    }

}
