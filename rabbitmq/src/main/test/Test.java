import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * User: LinXiaoHui
 * Date: 2018/6/28
 */
public class Test {

    @org.junit.Test
    public void thenApply() {
        String result = CompletableFuture.supplyAsync(() -> "hello")
                .thenApplyAsync((Void) -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "world";
                }).join();
    System.out.println(result);
    }

    @org.junit.Test
    public void thenAccept(){
        Void v = CompletableFuture.supplyAsync(() -> 1)
                .thenAccept(i -> System.out.println(i+1)).join();
    }

    @org.junit.Test
    public void thenRun(){
        List<CompletableFuture<String>> futures = new ArrayList<>();
        futures.toArray(new CompletableFuture[0]);
        CompletableFuture.supplyAsync(() -> 1)
                .thenRun(() -> System.out.println(1));
    }
}
