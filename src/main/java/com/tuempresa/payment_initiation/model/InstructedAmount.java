package com.tuempresa.payment_initiation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import java.math.BigDecimal;

/**
 * InstructedAmount
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-20T22:58:52.212689100-05:00[America/Guayaquil]", comments = "Generator version: 7.17.0")
public class InstructedAmount {

  private BigDecimal amount;

  private String currency;

  public InstructedAmount() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InstructedAmount(BigDecimal amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  public InstructedAmount amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   */
  @NotNull 
  @Schema(name = "amount", example = "150.75", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public InstructedAmount currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   */
  @NotNull 
  @Schema(name = "currency", example = "USD", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("currency")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstructedAmount instructedAmount = (InstructedAmount) o;
    return Objects.equals(this.amount, instructedAmount.amount) &&
        Objects.equals(this.currency, instructedAmount.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InstructedAmount {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

