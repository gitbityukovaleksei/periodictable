package ua.com.lineup.periodictable.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Element implements Serializable {

    private String name;

    @Id
    private Integer atomicNumber;

    private String alternativeName = "none";

    private String symbol;

    private String appearance;

    private String discovery;

    private String discoveryYear = "unknown";

    private Integer groupBlock;

    private Integer period;

}

