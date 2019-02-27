
package cz.lsvobo.demo.zonky.marketplace.client.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Photo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

}
