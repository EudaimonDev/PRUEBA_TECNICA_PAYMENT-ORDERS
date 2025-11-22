package com.tuempresa.payment_initiation.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import com.tuempresa.payment_initiation.model.CreditorAccount;
import com.tuempresa.payment_initiation.model.DebtorAccount;
import com.tuempresa.payment_initiation.model.InstructedAmount;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PaymentOrderResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-20T22:58:52.212689100-05:00[America/Guayaquil]", comments = "Generator version: 7.17.0")
public class PaymentOrderResponse {

  private @Nullable String id;

  private @Nullable String externalReference;

  private @Nullable DebtorAccount debtorAccount;

  private @Nullable CreditorAccount creditorAccount;

  private @Nullable InstructedAmount instructedAmount;

  private @Nullable String remittanceInformation;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private @Nullable LocalDate requestedExecutionDate;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("PENDING"),
    
    PROCESSING("PROCESSING"),
    
    COMPLETED("COMPLETED"),
    
    FAILED("FAILED");

    private final String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable StatusEnum status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  public PaymentOrderResponse id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", example = "PO-0001", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  public PaymentOrderResponse externalReference(@Nullable String externalReference) {
    this.externalReference = externalReference;
    return this;
  }

  /**
   * Get externalReference
   * @return externalReference
   */
  
  @Schema(name = "externalReference", example = "EXT-1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("externalReference")
  public @Nullable String getExternalReference() {
    return externalReference;
  }

  public void setExternalReference(@Nullable String externalReference) {
    this.externalReference = externalReference;
  }

  public PaymentOrderResponse debtorAccount(@Nullable DebtorAccount debtorAccount) {
    this.debtorAccount = debtorAccount;
    return this;
  }

  /**
   * Get debtorAccount
   * @return debtorAccount
   */
  @Valid 
  @Schema(name = "debtorAccount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("debtorAccount")
  public @Nullable DebtorAccount getDebtorAccount() {
    return debtorAccount;
  }

  public void setDebtorAccount(@Nullable
          DebtorAccount debtorAccount) {
    this.debtorAccount = debtorAccount;
  }

  public PaymentOrderResponse creditorAccount(@Nullable CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
    return this;
  }

  /**
   * Get creditorAccount
   * @return creditorAccount
   */
  @Valid 
  @Schema(name = "creditorAccount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creditorAccount")
  public @Nullable CreditorAccount getCreditorAccount() {
    return creditorAccount;
  }

  public void setCreditorAccount(@Nullable CreditorAccount creditorAccount) {
    this.creditorAccount = creditorAccount;
  }

  public PaymentOrderResponse instructedAmount(@Nullable InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
    return this;
  }

  /**
   * Get instructedAmount
   * @return instructedAmount
   */
  @Valid 
  @Schema(name = "instructedAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("instructedAmount")
  public @Nullable InstructedAmount getInstructedAmount() {
    return instructedAmount;
  }

  public void setInstructedAmount(@Nullable InstructedAmount instructedAmount) {
    this.instructedAmount = instructedAmount;
  }

  public PaymentOrderResponse remittanceInformation(@Nullable String remittanceInformation) {
    this.remittanceInformation = remittanceInformation;
    return this;
  }

  /**
   * Get remittanceInformation
   * @return remittanceInformation
   */
  
  @Schema(name = "remittanceInformation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("remittanceInformation")
  public @Nullable String getRemittanceInformation() {
    return remittanceInformation;
  }

  public void setRemittanceInformation(@Nullable String remittanceInformation) {
    this.remittanceInformation = remittanceInformation;
  }

  public PaymentOrderResponse requestedExecutionDate(@Nullable LocalDate requestedExecutionDate) {
    this.requestedExecutionDate = requestedExecutionDate;
    return this;
  }

  /**
   * Get requestedExecutionDate
   * @return requestedExecutionDate
   */
  @Valid 
  @Schema(name = "requestedExecutionDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestedExecutionDate")
  public @Nullable LocalDate getRequestedExecutionDate() {
    return requestedExecutionDate;
  }

  public void setRequestedExecutionDate(@Nullable LocalDate requestedExecutionDate) {
    this.requestedExecutionDate = requestedExecutionDate;
  }

  public PaymentOrderResponse status(@Nullable StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public @Nullable StatusEnum getStatus() {
    return status;
  }

  public void setStatus(@Nullable StatusEnum status) {
    this.status = status;
  }

  public PaymentOrderResponse createdAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public @Nullable OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentOrderResponse paymentOrderResponse = (PaymentOrderResponse) o;
    return Objects.equals(this.id, paymentOrderResponse.id) &&
        Objects.equals(this.externalReference, paymentOrderResponse.externalReference) &&
        Objects.equals(this.debtorAccount, paymentOrderResponse.debtorAccount) &&
        Objects.equals(this.creditorAccount, paymentOrderResponse.creditorAccount) &&
        Objects.equals(this.instructedAmount, paymentOrderResponse.instructedAmount) &&
        Objects.equals(this.remittanceInformation, paymentOrderResponse.remittanceInformation) &&
        Objects.equals(this.requestedExecutionDate, paymentOrderResponse.requestedExecutionDate) &&
        Objects.equals(this.status, paymentOrderResponse.status) &&
        Objects.equals(this.createdAt, paymentOrderResponse.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, externalReference, debtorAccount, creditorAccount, instructedAmount, remittanceInformation, requestedExecutionDate, status, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentOrderResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    externalReference: ").append(toIndentedString(externalReference)).append("\n");
    sb.append("    debtorAccount: ").append(toIndentedString(debtorAccount)).append("\n");
    sb.append("    creditorAccount: ").append(toIndentedString(creditorAccount)).append("\n");
    sb.append("    instructedAmount: ").append(toIndentedString(instructedAmount)).append("\n");
    sb.append("    remittanceInformation: ").append(toIndentedString(remittanceInformation)).append("\n");
    sb.append("    requestedExecutionDate: ").append(toIndentedString(requestedExecutionDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

