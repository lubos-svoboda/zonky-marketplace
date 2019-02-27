
package cz.lsvobo.demo.zonky.marketplace.client.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Loan {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("story")
    private String story;
    @JsonProperty("purpose")
    private String purpose;
    @JsonProperty("photos")
    private List<Photo> photos = null;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("nickName")
    private String nickName;
    @JsonProperty("termInMonths")
    private Integer termInMonths;
    @JsonProperty("interestRate")
    private BigDecimal interestRate;
    @JsonProperty("revenueRate")
    private BigDecimal revenueRate;
    @JsonProperty("annuity")
    private BigDecimal annuity;
    @JsonProperty("premium")
    private Integer premium;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("topped")
    private Boolean topped;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("remainingInvestment")
    private BigDecimal remainingInvestment;
    @JsonProperty("investmentRate")
    private BigDecimal investmentRate;
    @JsonProperty("covered")
    private Boolean covered;
    @JsonProperty("reservedAmount")
    private BigDecimal reservedAmount;
    @JsonProperty("datePublished")
    private OffsetDateTime datePublished;
    @JsonProperty("published")
    private Boolean published;
    @JsonProperty("deadline")
    private OffsetDateTime deadline;
    @JsonProperty("investmentsCount")
    private Integer investmentsCount;
    @JsonProperty("questionsCount")
    private Integer questionsCount;
    @JsonProperty("region")
    private String region;
    @JsonProperty("mainIncomeType")
    private String mainIncomeType;
    @JsonProperty("questionsAllowed")
    private Boolean questionsAllowed;
    @JsonProperty("activeLoansCount")
    private Integer activeLoansCount;
    @JsonProperty("insuranceActive")
    private Boolean insuranceActive;
    @JsonProperty("insuranceHistory")
    private List<InsuranceHistory> insuranceHistory = null;
    @JsonProperty("fastcash")
    private Boolean fastcash;
    @JsonProperty("multicash")
    private Boolean multicash;
    @JsonProperty("annuityWithInsurance")
    private BigDecimal annuityWithInsurance;
}
