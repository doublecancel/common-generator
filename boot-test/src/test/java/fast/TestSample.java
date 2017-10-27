package fast;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2017/10/27.
 */
public class TestSample {


    @Test
    public void test(){
        System.out.println(Long.toBinaryString(-1L));
        System.out.println(Long.toBinaryString(Long.MAX_VALUE));
        System.out.println(Long.MAX_VALUE + 1);

        IntStream.range(1, 20)
                .forEach(a -> {
                    Long max = -1L ^ (-1L << a);
                    System.out.println("a:" + a + ",max:" + max);
                    System.out.println((1 << a) - 1);
                    System.out.println(Long.toBinaryString(max));

                });

    }

    @Test
    public void test2(){

        System.out.println(new SimpleDateFormat("yyyy年MM月dd日hh：mm：ss E")
                .format(new Date(-1L ^ (-1L << 41))).toString());


        System.currentTimeMillis();
        Long a = -1L ^ (-1L << 41);
        Timestamp timestamp = new Timestamp(a);
        LocalDateTime time = timestamp.toLocalDateTime();

        System.out.println(System.currentTimeMillis() - (-1L ^ (-1L << 40)));


        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        System.out.println();

    }


}
