package opt.core;

import com.google.common.base.Strings;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/11/18.
 */
@Data
public class Required {

    private List<String> fields;

    public static Params require(String... fs){
        Required required = new Required();
        List<String> list = Arrays.stream(fs).filter(a -> !Strings.isNullOrEmpty(a))
                .collect(Collectors.toList());
        required.setFields(list);
        return new Params();
    }

}
