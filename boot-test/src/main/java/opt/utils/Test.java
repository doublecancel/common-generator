package opt.utils;

import java.time.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class Test {

    public static void main(String[] args) {

//        java.util.Date date = new java.util.Date();
//
//        LocalDateTime localDateTime = date.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDateTime();
//        System.out.println();
//
//        LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        System.out.println("LocalDateTime = " + localDateTime);
        System.out.println("Date = " + date);


    }

}
