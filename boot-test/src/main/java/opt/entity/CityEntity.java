package opt.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import opt.core.serialize.DateDerialize;
import opt.core.serialize.DateSerialize;
import opt.core.enums.Status;
import opt.core.serialize.StatusDerialize;
import opt.core.serialize.StatusSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Administrator on 2017/12/26.
 */

@Data
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;
    @Column(name = "CountryCode")
    private String countryCode;


    private String district;
    private Integer population;

    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime create_date;

    @JsonSerialize(using = DateSerialize.class)
    @JsonDeserialize(using = DateDerialize.class)
    private LocalDateTime modify_date;

    @JsonSerialize(using = StatusSerialize.class)
    @JsonDeserialize(using = StatusDerialize.class)
    private Status status;

    private Integer version;

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", create_date=" + create_date +
                ", modify_date=" + modify_date +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
