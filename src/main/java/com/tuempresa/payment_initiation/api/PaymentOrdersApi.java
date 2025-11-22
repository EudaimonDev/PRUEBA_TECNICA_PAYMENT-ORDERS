package com.tuempresa.payment_initiation.api;

import com.tuempresa.payment_initiation.model.PaymentOrderRequest;
import com.tuempresa.payment_initiation.model.PaymentOrderResponse;
import com.tuempresa.payment_initiation.model.PaymentStatusResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-20T22:58:52.212689100-05:00[America/Guayaquil]", comments = "Generator version: 7.17.0")
@Validated
@Tag(name = "PaymentOrders", description = "the PaymentOrders API")
public interface PaymentOrdersApi {

    String PATH_CREATE_PAYMENT_ORDER = "/payment-initiation/payment-orders";
    /**
     * POST /payment-initiation/payment-orders : Create a payment order
     *
     * @param paymentOrderRequest  (required)
     * @return Payment order created (status code 201)
     *         or Invalid request (status code 400)
     */
    @Operation(
        operationId = "createPaymentOrder",
        summary = "Create a payment order",
        tags = { "PaymentOrders" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Payment order created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentOrderResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid request")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = PaymentOrdersApi.PATH_CREATE_PAYMENT_ORDER,
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<PaymentOrderResponse> createPaymentOrder(
        @Parameter(name = "PaymentOrderRequest", description = "", required = true) @Valid @RequestBody PaymentOrderRequest paymentOrderRequest
    );


    String PATH_GET_PAYMENT_ORDER = "/payment-initiation/payment-orders/{paymentOrderId}";
    /**
     * GET /payment-initiation/payment-orders/{paymentOrderId} : Get payment order by ID
     *
     * @param paymentOrderId  (required)
     * @return Payment order retrieved (status code 200)
     *         or Not found (status code 404)
     */
    @Operation(
        operationId = "getPaymentOrder",
        summary = "Get payment order by ID",
        tags = { "PaymentOrders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Payment order retrieved", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentOrderResponse.class), examples = {
                    @ExampleObject(
                        name = "",
                        value = "{\"id\":\"PO-0001\",\"externalReference\":\"EXT-1\",\"debtorAccount\":{\"iban\":\"EC12DEBTOR\"},\"creditorAccount\":{\"iban\":\"EC98CREDITOR\"},\"instructedAmount\":{\"amount\":150.75,\"currency\":\"USD\"},\"remittanceInformation\":\"Factura 001-123\",\"requestedExecutionDate\":\"2025-10-31\",\"status\":\"PENDING\",\"createdAt\":\"2025-11-21T03:00:00Z\"}"
                    )
                })

            }),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = PaymentOrdersApi.PATH_GET_PAYMENT_ORDER,
        produces = { "application/json" }
    )
    ResponseEntity<PaymentOrderResponse> getPaymentOrder(
        @NotNull @Parameter(name = "paymentOrderId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("paymentOrderId") String paymentOrderId
    );


    String PATH_GET_PAYMENT_ORDER_STATUS = "/payment-initiation/payment-orders/{paymentOrderId}/status";
    /**
     * GET /payment-initiation/payment-orders/{paymentOrderId}/status : Get payment order status
     *
     * @param paymentOrderId  (required)
     * @return Payment order status retrieved (status code 200)
     *         or Not found (status code 404)
     */
    @Operation(
        operationId = "getPaymentOrderStatus",
        summary = "Get payment order status",
        tags = { "PaymentOrders" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Payment order status retrieved", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentStatusResponse.class), examples = {
                    @ExampleObject(
                        name = "",
                        value = "{\"id\":\"PO-0001\",\"status\":\"PENDING\",\"lastUpdated\":\"2025-11-21T03:00:00Z\"}"
                    )
                })

            }),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = PaymentOrdersApi.PATH_GET_PAYMENT_ORDER_STATUS,
        produces = { "application/json" }
    )
    ResponseEntity<PaymentStatusResponse> getPaymentOrderStatus(
        @NotNull @Parameter(name = "paymentOrderId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("paymentOrderId") String paymentOrderId
    );

}
