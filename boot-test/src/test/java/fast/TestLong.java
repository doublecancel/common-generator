package fast;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/10/27.
 * //-----------------------localpage 100 18.4
 * //-----------------------normal 100 19.4
 *
 * //-----------------------localpage cache 100 4
 * //-----------------------normal cache 100 4
 */
public class TestLong {


    private static CyclicBarrier barrier = new CyclicBarrier(100);//100个线程同时请求
    private static ExecutorService pool = Executors.newFixedThreadPool(100);

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Test
    public void testQUerylocalPage() throws Exception{
//        Long start = System.currentTimeMillis();
//        execute("http://localhost:10004/findPage");
//        System.out.println("执行完成1----------------------------");
//        System.out.println("执行消耗时间1：" + (System.currentTimeMillis() - start));

        Long start1 = System.currentTimeMillis();
        execute("http://localhost:10004/findLocalPage");
        System.out.println("执行完成2----------------------------");
        System.out.println("执行消耗时间2：" + (System.currentTimeMillis() - start1));

    }

    private void execute(String url) throws Exception{
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            RequestBody body = RequestBody
                    .create(JSON, "{\"status\":\"1\",\"currentPage\":\"2\", \"rowNum\":\"30\"}");

            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

                IntStream.range(1, 101).forEach(y -> {
                    Long start = System.currentTimeMillis();
                    try {
                        Response response = null;
                        response = client.newCall(request).execute();
                        if(response.isSuccessful()){
//                            System.out.println(response.body().string());
                        }
                        response.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("本次请求" + y + "时间：" + (System.currentTimeMillis() - start));
                });




    }


    public ThreadFactory newFactory(){
        ThreadFactory factory = (r) -> {
            Thread t = new Thread(r);
            t.setName("测试请求线程");
            return t;
        };
        return factory;
    }



}
