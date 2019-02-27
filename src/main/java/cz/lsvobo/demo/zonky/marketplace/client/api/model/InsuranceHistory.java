
package cz.lsvobo.demo.zonky.marketplace.client.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class InsuranceHistory {

    @JsonProperty("policyPeriodFrom")
    private LocalDate policyPeriodFrom;

    @JsonProperty("policyPeriodTo")
    private LocalDate policyPeriodTo;

}
