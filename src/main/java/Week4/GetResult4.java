package Week4;

public class GetResult4 {
    static Object o1 = new Object();
    public static int result;

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                result = AddNumber(3);
                synchronized (o1) {
                    o1.notify();
                }
                System.out.println("完成当前操作....");
            }
        };

        try {
            Thread t = new Thread(task);
            t.start();
            synchronized (o1) {
                o1.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("输出最后结果为: " + result);
            System.out.println("退出主线程。。");
        }

    }

    private static int AddNumber(int num){
        return num + 1;
    }
}
