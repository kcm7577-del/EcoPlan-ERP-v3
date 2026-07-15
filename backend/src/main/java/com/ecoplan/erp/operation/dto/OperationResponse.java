package com.ecoplan.erp.operation.dto;

import com.ecoplan.erp.operation.domain.Operation;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class OperationResponse {

    private Long id;

    private LocalDate operationDate;

    private String driverName;

    private Long vehicleId;

    private String vehicleNumber;

    private String departure;

    private String destination;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private Integer departureKm;

    private Integer arrivalKm;

    private Integer distanceKm;

    public static OperationResponse from(Operation operation) {

        return OperationResponse.builder()
                .id(operation.getId())
                .operationDate(operation.getOperationDate())
                .driverName(operation.getDriverName())
                .vehicleId(operation.getVehicle().getId())
                .vehicleNumber(operation.getVehicle().getVehicleNumber())
                .departure(operation.getDeparture())
                .destination(operation.getDestination())
                .departureTime(operation.getDepartureTime())
                .arrivalTime(operation.getArrivalTime())
                .departureKm(operation.getDepartureKm())
                .arrivalKm(operation.getArrivalKm())
                .distanceKm(operation.getDistanceKm())
                .build();
    }
}