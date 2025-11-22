package com.tuempresa.payment_initiation.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * CreditorAccount
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-20T22:58:52.212689100-05:00[America/Guayaquil]", comments = "Generator version: 7.17.0")
public class CreditorAccount {

  private String iban;

  public CreditorAccount() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreditorAccount(String iban) {
    this.iban = iban;
  }

  public CreditorAccount iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * Get iban
   * @return iban
   */
  @NotNull 
  @Schema(name = "iban", example = "EC98CREDITOR", requiredMode = Schema.RequiredMode.REQUIRED)
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
    CreditorAccount creditorAccount = (CreditorAccount) o;
    return Objects.equals(this.iban, creditorAccount.iban);
  }

  @Override
  public int hashCode() {
    return Objects.hash(iban);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditorAccount {\n");
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

