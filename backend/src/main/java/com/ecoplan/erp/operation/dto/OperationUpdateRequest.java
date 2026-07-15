package com.ecoplan.erp.operation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OperationUpdateRequest {

    @NotNull
    private LocalDate operationDate;

    @NotBlank
    private String driverName;

    @NotNull
    private Long vehicleId;

    @NotBlank
    private String departure;

    @NotBlank
    private String destination;

    @NotNull
    private LocalDateTime departureTime;

    @NotNull
    private LocalDateTime arrivalTime;

    @NotNull
    private Integer departureKm;

    @NotNull
    private Integer arrivalKm;

}