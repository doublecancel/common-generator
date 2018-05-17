package opt.controller.editors;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Administrator on 2017/12/26.
 */
@Component
public class LocalDateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        super.setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    @Override
    public void setValue(Object value) {
        super.setValue(value);
    }
}
