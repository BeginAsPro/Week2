package Week4;

import java.util.concurrent.*;

public class GetResult3 {
    public static void main(String[] args) {
        int result = 0;
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return AddNumber(3);
            }
        };
        FutureTask<Integer> fGet = new FutureTask<>(task);
        ExecutorService excutor = Executors.newFixedThreadPool(6);
        excutor.submit(fGet);

        try{
            result = fGet.get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        excutor.shutdownNow();

        System.out.println("结果为: " + result);
        System.out.println("结束");
    }

    private static int AddNumber(int num){
        return num + 1;
    }
}
