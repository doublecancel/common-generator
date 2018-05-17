package opt.entity;

import lombok.Data;
import opt.core.enums.Status;

import java.time.LocalDateTime;

@Data
public class TestFormatUser {
    private Long id;
    private String name;

    private LocalDateTime create_date;

    private Status status;
}
