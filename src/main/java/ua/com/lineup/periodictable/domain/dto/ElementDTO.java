package ua.com.lineup.periodictable.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElementDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("atomic_number")
    private Integer atomicNumber;

    @JsonProperty(value = "alternative_name", defaultValue = "none")
    private String alternativeName;

    @JsonProperty(value = "symbol")
    private String symbol;

    @JsonProperty(value = "appearance")
    private String appearance;

    @JsonProperty(value = "discovery")
    private String discovery;

    @JsonProperty(value = "discovery_and_first_isolation", defaultValue = "unknown")
    private String discoveryYear;

    @JsonProperty(value = "group_block")
    private Integer groupBlock = 0;

    @JsonProperty(value = "period")
    private Integer period;

    public void setDiscoveryYear(String discoveryYear) {
        if (discoveryYear.equals("n/a")) {
            this.discoveryYear = "unknown";
        }
    }

    //todo "group 12, d-block"
    public void setGroupBlock(String groupBlock) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(groupBlock);

        if (m.find()) {
            this.groupBlock = Integer.valueOf(m.group());
        }
    }
}
