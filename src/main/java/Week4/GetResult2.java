package Week4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class GetResult2 {
    public static void main(String[] args) {
        int result = 0;
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return AddNumber(3);
            }
        };
        FutureTask<Integer> fGet = new FutureTask<>(task);
        new Thread(fGet).start();
        try{
            result = fGet.get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        System.out.println("结果为: " + result);
        System.out.println("结束");
    }
    private static int AddNumber(int num){
        return num + 1;
    }
}
