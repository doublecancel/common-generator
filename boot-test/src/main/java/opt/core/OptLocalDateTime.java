package opt.core;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import opt.core.serialize.DateDerialize;
import opt.core.serialize.DateSerialize;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/9/24 0024.
 */
public class OptLocalDateTime {
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";
    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime start;
    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime end;

    public OptLocalDateTime(){}

    public static OptLocalDateTime now(){
        return create(LocalDateTime.now(), null );
    }

    public static OptLocalDateTime create(String start, String end){
        return create(strToLocalDateTime(start), strToLocalDateTime(end));
    }


    public static OptLocalDateTime create(String start){
        return create(strToLocalDateTime(start));
    }

    public static OptLocalDateTime create(LocalDateTime start){
        return create(start, null);
    }

    public static OptLocalDateTime create(LocalDateTime start, LocalDateTime end){
        OptLocalDateTime optLocalDate = new OptLocalDateTime();
        optLocalDate.start = start;
        optLocalDate.end = end  ;
        return optLocalDate;
    }

    private static LocalDateTime  strToLocalDateTime(String time){
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }
    private static String localDateTimeToStr(LocalDateTime time){
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }


    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
