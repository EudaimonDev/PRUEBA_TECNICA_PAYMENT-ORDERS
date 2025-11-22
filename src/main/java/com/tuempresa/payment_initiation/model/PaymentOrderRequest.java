package com.tuempresa.payment_initiation.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import com.tuempresa.payment_initiation.model.CreditorAccount;
import com.tuempresa.payment_initiation.model.DebtorAccount;
import com.tuempresa.payment_initiation.model.InstructedAmount;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PaymentOrderRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-20T22:58:52.212689100-05:00[America/Guayaquil]", comments = "Generator version: 7.17.0")
public class PaymentOrderRequest {

  private String externalReference;

  private DebtorAccount debtorAccount;

  private CreditorAccount creditorAccount;

  private InstructedAmount instructedAmount;

  private @Nullable String remittanceInformation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate requestedExecutionDate;

  public PaymentOrderRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaymentOrderRequest(String externalReference, DebtorAccount debtorAccount, CreditorAccount creditorAccount, InstructedAmount instructedAmount, LocalDate requestedExecutionDate) {
    this.externalReference = externalReference;
    this.debtorAccount = debtorAccount;
    this.creditorAccount = creditorAccount;
    this.instructedAmount = instructedAmount;
    this.requestedExecutionDate = requestedExecutionDate;
  }

  public PaymentOrderRequest externalReference(String externalReference) {
    this.externalReference = externalReference;
    return this;
  }

  /**
   * Get externalReference
   * @return externalReference
   */
  @NotNull 
  @Schema(name = "externalReference", example = "EXT-1", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("externalReference")
  public String getExternalReference() {
    return externalReference;
  }

  public void setExternalReference(String externalReference) {
    this.externalReference = externalReference;
  }

  public PaymentOrderRequest debtorAccount(DebtorAccount debtorAccount) {
    this.debtorAccount = debtorAccount;
    return this;
  }

  /**
   * Get debtorAccount
   * @return debtorAccount
   */
  @NotNull @Valid 
  @Schema(name = "debtorAccount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("debtorAccount")
  public DebtorAccount getDebtorAccount() {
    return debtorAccount;
  }

  public void setDebtorAccount(DebtorAccount debtorAccount) {
    this.debtorAccount = debtorAccount;
  }

  public PaymentOrderRequest creditorAccount(CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
    return this;
  }

  /**
   * Get creditorAccount
   * @return creditorAccount
   */
  @NotNull @Valid 
  @Schema(name = "creditorAccount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("creditorAccount")
  public CreditorAccount getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  public PaymentOrderRequest instructedAmount(InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
    return this;
  }

  /**
   * Get instructedAmount
   * @return instructedAmount
   */
  @NotNull @Valid 
  @Schema(name = "instructedAmount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("instructedAmount")
  public InstructedAmount getInstructedAmount() {
    return instructedAmount;
  }

  public void setInstructedAmount(InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
  }

  public PaymentOrderRequest remittanceInformation(@Nullable String remittanceInformation) {
    this.remittanceInformation = remittanceInformation;
    return this;
  }

  /**
   * Get remittanceInformation
   * @return remittanceInformation
   */
  
  @Schema(name = "remittanceInformation", example = "Factura 001-123", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("remittanceInformation")
  public @Nullable String getRemittanceInformation() {
    return remittanceInformation;
  }

  public void setRemittanceInformation(@Nullable String remittanceInformation) {
    this.remittanceInformation = remittanceInformation;
  }

  public PaymentOrderRequest requestedExecutionDate(LocalDate requestedExecutionDate) {
    this.requestedExecutionDate = requestedExecutionDate;
    return this;
  }

  /**
   * Get requestedExecutionDate
   * @return requestedExecutionDate
   */
  @NotNull @Valid 
  @Schema(name = "requestedExecutionDate", example = "2025-10-31", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requestedExecutionDate")
  public LocalDate getRequestedExecutionDate() {
    return requestedExecutionDate;
  }

  public void setRequestedExecutionDate(LocalDate requestedExecutionDate) {
    this.requestedExecutionDate = requestedExecutionDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentOrderRequest paymentOrderRequest = (PaymentOrderRequest) o;
    return Objects.equals(this.externalReference, paymentOrderRequest.externalReference) &&
        Objects.equals(this.debtorAccount, paymentOrderRequest.debtorAccount) &&
        Objects.equals(this.creditorAccount, paymentOrderRequest.creditorAccount) &&
        Objects.equals(this.instructedAmount, paymentOrderRequest.instructedAmount) &&
        Objects.equals(this.remittanceInformation, paymentOrderRequest.remittanceInformation) &&
        Objects.equals(this.requestedExecutionDate, paymentOrderRequest.requestedExecutionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalReference, debtorAccount, creditorAccount, instructedAmount, remittanceInformation, requestedExecutionDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentOrderRequest {\n");
    sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
    sb.append("    debtorAccount: ").append(toIndentedString(debtorAccount)).append("\n");
    sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
    sb.append("    instructedAmount: ").append(toIndentedString(instructedAmount)).append("\n");
    sb.append("    remittanceInformation: ").append(toIndentedString(remittanceInformation)).append("\n");
    sb.append("    requestedExecutionDate: ").append(toIndentedString(requestedExecutionDate)).append("\n");
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

