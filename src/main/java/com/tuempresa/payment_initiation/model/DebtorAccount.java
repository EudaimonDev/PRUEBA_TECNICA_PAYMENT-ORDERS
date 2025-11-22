package com.tuempresa.payment_initiation.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * DebtorAccount
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-20T22:58:52.212689100-05:00[America/Guayaquil]", comments = "Generator version: 7.17.0")
public class DebtorAccount {

  private String iban;

  public DebtorAccount() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DebtorAccount(String iban) {
    this.iban = iban;
  }

  public DebtorAccount iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
   */
  @NotNull 
  @Schema(name = "iban", example = "EC12DEBTOR", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("iban")
  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DebtorAccount debtorAccount = (DebtorAccount) o;
    return Objects.equals(this.iban, debtorAccount.iban);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iban);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DebtorAccount {\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
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

