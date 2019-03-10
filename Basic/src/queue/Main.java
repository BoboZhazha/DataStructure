package queue;

public class Main {


    public static double testQueue(Queue<Integer> queue, int optCount) {
        long startTime = System.nanoTime();

        for (int i = 0; i < optCount; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < optCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }

    public static void main(String[] args) {

        int count = 100000;
        double time2 = testQueue(new LoopQueue<Integer>(), count);
        double time = testQueue(new ArrayQueue<Integer>(), count);


        System.out.println(time);
        System.out.println(time2);

        // 不严谨的测试 发现有350倍的差距
        System.out.println(time / time2);
    }
}
