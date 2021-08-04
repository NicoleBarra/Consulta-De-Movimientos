
package com.ibm.spring.retrieve.api.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customerId",
    "date",
    "transactionDescription"
})
@Generated("jsonschema2pojo")
public class TransactionResponse {

    @JsonProperty("customerId")
    private Integer customerId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("transactionDescription")
    private TransactionDescription transactionDescription;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("customerId")
    public Integer getCustomerId() {
        return customerId;
    }

    @JsonProperty("customerId")
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("transactionDescription")
    public TransactionDescription getTransactionDescription() {
        return transactionDescription;
    }

    @JsonProperty("transactionDescription")
    public void setTransactionDescription(TransactionDescription transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
